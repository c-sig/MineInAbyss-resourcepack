package com.mineinabyss.resourcepack

import com.mineinabyss.resourcepack.helpers.CopyDir
import com.mineinabyss.resourcepack.helpers.div
import java.io.File
import kotlin.io.path.Path

object Config {
    val zipDirs = listOf(
        CopyDir(Dirs.modelEngine / "resource pack/assets"),
        CopyDir(
            File("assets/"),
            ignoreDirs = listOf(
                Path("assets/modelengine"),
                Path("assets/minecraft/models/item/leather_horse_armor.json")
            )
        ),
        CopyDir(Dirs.out / "hit_gen/assets"),
        CopyDir(File("pack.mcmeta")),
        CopyDir(File("pack.png")),
        CopyDir(File("LICENSE")),
    )
}
