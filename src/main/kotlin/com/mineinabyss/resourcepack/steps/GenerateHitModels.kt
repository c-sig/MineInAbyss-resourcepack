package com.mineinabyss.resourcepack.steps

import com.mineinabyss.resourcepack.Assets
import com.mineinabyss.resourcepack.Dirs
import com.mineinabyss.resourcepack.helpers.Model
import com.mineinabyss.resourcepack.helpers.div
import com.savvasdalkitsis.jsonmerger.JsonMerger
import kotlinx.serialization.json.Json

val json = Json {
    ignoreUnknownKeys = true
}

//TODO finish
fun generateHitModels() {
    val ignoredModelNames = listOf("move", "walk", "_hit")
    val usedTextures = mutableListOf<String>()

    Dirs.creatureModels.walk().maxDepth(2)
        .filter { file ->
            file.extension == ".json" && ignoredModelNames.none { it in file.name }
        }
        .onEach { println("Generating Hit Model for: $it") }
        .forEach { modelFile ->
            val text = modelFile.readText()
            val model = json.decodeFromString(Model.serializer(), text)
            val hitTexturePath = "$"

            val hitTextures = model.textures.mapValues { (name, path) ->
                val originalTexture = Assets.minecraft / "textures/$path.png"

                val hitTexture = Assets.hit / "textures/$path.png"
                "hit:$path"
            }
            val hitModel = model.copy(textures = hitTextures)
            val hitModelFile = modelFile.parentFile
            val hitOverride = json.encodeToString(Model.serializer(), hitModel)
            modelFile.relativeTo(Assets.minecraft)

            modelFile.writeText(JsonMerger().merge(text, hitOverride))
        }
}
