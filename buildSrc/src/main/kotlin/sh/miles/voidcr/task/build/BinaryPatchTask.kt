package sh.miles.voidcr.task.build

import io.sigpipe.jbsdiff.ui.FileUI
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class BinaryPatchTask : DefaultTask() {

    @get:InputFile
    abstract val cosmicReachJar: RegularFileProperty

    @get:InputFile
    abstract val voidCRJar: RegularFileProperty

    @get:OutputFile
    abstract val patchFile: RegularFileProperty

    @TaskAction
    fun execute() {
        val original = cosmicReachJar.asFile.get()
        val modified = voidCRJar.asFile.get()
        val patchFile = patchFile.asFile.get()

        FileUI.diff(original, modified, patchFile)
    }
}
