package sh.miles.voidcr.task.build

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class CreateBuildDataTask : DefaultTask() {
    @get:Input
    abstract val archiveRepoUrl: Property<String>

    @get:Input
    abstract val phase: Property<String>

    @get:Input
    abstract val version: Property<String>

    @get:Input
    abstract val mainClass: Property<String>

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @TaskAction
    fun execute() {
        val jarUrl =
            "${archiveRepoUrl.get()}${phase.get()}/${version.get()}/server/Cosmic-Reach-Server-${version.get()}.jar"
        outputFile.asFile.get().writeText("$jarUrl\n${version.get()}\n${mainClass.get()}")
    }
}
