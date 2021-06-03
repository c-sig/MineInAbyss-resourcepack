@file:JvmName("Main")

package com.mineinabyss.resourcepack

import com.mineinabyss.resourcepack.steps.collectBlueprints
import com.mineinabyss.resourcepack.steps.generateWithModelEngine
import com.mineinabyss.resourcepack.steps.zipFiles

fun main() {
    collectBlueprints()
    generateWithModelEngine()
    zipFiles()
}
