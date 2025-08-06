package sh.miles.voidcr.task.build

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class CreateBuildDataTask : DefaultTask() {
    @get:Optional // not optional but makes gradle happy
    @get:Input
    var downloadUrl: String? = null

    @get:Input
    abstract val version: Property<String>

    @get:Input
    abstract val mainClass: Property<String>

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @TaskAction
    fun execute() {
        outputFile.asFile.get().writeText("$downloadUrl\n${version.get()}\n${mainClass.get()}")
    }
}
