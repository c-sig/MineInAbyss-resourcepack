package com.mineinabyss.resourcepack.steps

import com.mineinabyss.resourcepack.Config
import com.mineinabyss.resourcepack.Dirs
import com.mineinabyss.resourcepack.helpers.div
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

fun zipFiles() {
    Config
    println("Generating zip file")
    ZipOutputStream(
        BufferedOutputStream(FileOutputStream(Dirs.out / "MineInAbyss-Models.zip"))
    ).also { out ->
        Config.zipDirs.forEach { (dir, relativeTo, ignoredDirs) ->
            dir.walk().forEach file@{ file ->
                val relative = file.relativeTo(relativeTo)

                if (!file.isFile) return@file
                if (ignoredDirs.any { ignored ->
                        relative.startsWith(ignored.toFile())
                    }) return@file

                val entry = ZipEntry(relative.toString())
                out.putNextEntry(entry)
                file.inputStream().copyTo(out, 1024)
                out.closeEntry()

            }
        }
    }.close()
}
