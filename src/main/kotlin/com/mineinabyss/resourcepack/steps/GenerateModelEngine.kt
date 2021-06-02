package com.mineinabyss.resourcepack.steps

import com.google.gson.Gson
import com.mineinabyss.resourcepack.Dirs
import com.mineinabyss.resourcepack.helpers.div
import com.ticxo.modelengine.ModelEngine
import com.ticxo.modelengine.api.ModelEngineAPI
import com.ticxo.modelengine.api.util.ConfigManager
import com.ticxo.modelengine.generator.MEModelGenerator
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.slot
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration

fun generateWithModelEngine() {
    println("Generating entity models with ModelEngine")
    mockkStatic(Bukkit::class)
    every { Bukkit.getConsoleSender() } returns mockk {
        val slot = slot<String>()
        every { sendMessage(capture(slot)) } answers { println(slot.captured) }
    }
    every { Bukkit.getViewDistance() } returns 8

    val mockedModelEngine = mockk<ModelEngine>() {
        ModelEngine.core = this
        ModelEngineAPI.api = this

        every { gson } returns Gson()
        every { config } returns YamlConfiguration.loadConfiguration(Dirs.modelEngine / "config.yml")
        every { saveDefaultConfig() } returns Unit
        every { saveResource(any(), any()) } returns Unit
        every { saveConfig() } returns Unit

        every { dataFolder } returns Dirs.modelEngine
        val customConfigManager = ConfigManager().apply {
            readConfig(false, true)
        }
        every { configManager } returns (customConfigManager)
    }

    println(ModelEngine.core.dataFolder)

    MEModelGenerator().apply {
        init()
        generateModels()
    }
}
