package com.mineinabyss.resourcepack.steps

import com.mineinabyss.resourcepack.Dirs
import com.mineinabyss.resourcepack.helpers.div
import java.io.File

fun collectBlueprints() {
    println("Collecting blueprints")
    val existing = Dirs.blueprints.walk().filter { it.isFile }
    val copied = File("assets").walk()
        .filter { it.extension == "bbmodel" }
        .map { it.copyTo((Dirs.blueprints / it.name), overwrite = true) }

    val deleted = (existing - copied).toList().onEach { it.delete() }
    if (deleted.count() != 0)
        println("Removed blueprints: ${deleted.joinToString { it.name }}")
}
