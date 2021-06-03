package com.mineinabyss.resourcepack.helpers

import kotlinx.serialization.Serializable

@Serializable
data class Model(
    val textures: Map<String, String> = mapOf()
)
