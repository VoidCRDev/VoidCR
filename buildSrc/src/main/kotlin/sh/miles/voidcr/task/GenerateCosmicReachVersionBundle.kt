package sh.miles.voidcr.task

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.extensions.core.extra
import sh.miles.voidcr.VersionBundle
import java.io.InputStreamReader
import java.net.URI

abstract class GenerateCosmicReachVersionBundle : DefaultTask() {
    private val gson = GsonBuilder().create()

    @get:Input
    abstract val archiveRepoUrl: Property<String>

    @get:Input
    abstract val phase: Property<String>

    @get:Input
    abstract val version: Property<String>

    @TaskAction
    fun execute() {
        val versionsURL = URI("${archiveRepoUrl.get()}/versions.json").toURL();
        val expectedId = "${version.get()}-${phase.get()}"
        var versionBundle: VersionBundle? = null
        versionsURL.openStream().use { input ->
            val tree = gson.fromJson(InputStreamReader(input), JsonObject::class.java)
            val versionsArray = tree.get("versions").asJsonArray
            for (element in versionsArray) {
                val versionObj = element.asJsonObject
                val id = versionObj.get("id").asString

                if (expectedId == id) {
                    val server = versionObj.get("server").asJsonObject
                    versionBundle = VersionBundle(
                        URI(server.get("url").asString).toURL(),
                        server.get("sha256").asString,
                        server.get("size").asInt
                    )
                    break
                }
            }
        }

        if (versionBundle == null) {
            throw GradleException("Unable to retrieve version bundle")
        }

        project.extra["versionBundle"] = versionBundle
    }
}
