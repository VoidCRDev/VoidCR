package sh.miles.voidcr.task

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import sh.miles.voidcr.VersionBundle

abstract class DownloadCosmicReachServer : DefaultTask() {

    @Optional // not optional at all but makes gradle happy
    @get:Input
    var versionBundle: VersionBundle? = null

    @get:OutputFile
    abstract val outputJar: RegularFileProperty

    @TaskAction
    fun execute() {
        if (versionBundle == null) {
            GradleException("No VersionBundle found for download cosmic reach server task")
            return
        }

        logger.lifecycle("targeting $versionBundle")

        val file = outputJar.get().asFile

        if (!file.exists()) {
            file.parentFile.mkdirs()
            versionBundle!!.url.openStream().use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
        }
    }
}
