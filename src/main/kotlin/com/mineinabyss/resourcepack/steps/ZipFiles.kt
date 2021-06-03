package com.mineinabyss.resourcepack.steps

import com.google.gson.Gson
import com.mineinabyss.resourcepack.Config
import com.mineinabyss.resourcepack.Dirs
import com.mineinabyss.resourcepack.helpers.div
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

val gson = Gson()

fun zipFiles() {
    Config
    println("Generating zip file")
    ZipOutputStream(
        BufferedOutputStream(FileOutputStream(Dirs.out / "MineInAbyss-Models.zip"))
    ).also { out ->
        Config.zipDirs.forEach { (dir, relativeTo, ignoredDirs) ->
            dir.walk().forEach file@{ file ->
                if (!file.isFile) return@file

                val relative = file.relativeTo(relativeTo)

                if (ignoredDirs.any { ignored ->
                        relative.startsWith(ignored.toFile())
                    }) return@file

                val entry = ZipEntry(relative.toString().replace('\\', '/'))
                out.putNextEntry(entry)

//                if (file.extension == "json") {
//                    val parsed = JsonParser.parseReader(file.reader())
//                    val minified = gson.toJson(parsed)
//                    minified.byteInputStream().copyTo(out, 1024)
//                } else {
                file.inputStream().copyTo(out)
//                }

                out.closeEntry()
            }
        }
    }.close()
}
