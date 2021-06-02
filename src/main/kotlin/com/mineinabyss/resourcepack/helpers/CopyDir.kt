package com.mineinabyss.resourcepack.helpers

import java.io.File
import java.nio.file.Path

data class CopyDir(
    val dir: File,
    val relativeTo: File = dir.parentFile ?: File(""),
    val ignoreDirs: List<Path> = listOf(),
)
