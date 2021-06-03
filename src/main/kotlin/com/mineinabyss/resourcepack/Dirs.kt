package com.mineinabyss.resourcepack

import com.mineinabyss.resourcepack.helpers.div
import java.io.File

object Dirs {
    val out = File("out")
    val modelEngine = out / "modelengine"
    val blueprints = modelEngine / "blueprints"
    val creatureModels = Assets.minecraft / "models/creatures"
    val creatureTextures = Assets.minecraft / "textures/creatures"
}

object Assets: File("assets") {
    val minecraft: File = this / "minecraft"
    val mineinabyss = this / "hit"
    val hit = this / "hit"
}
