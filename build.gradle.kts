import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

repositories {
    mavenCentral()
//    maven("https://mvn.lumine.io/repository/maven-releases/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.codemc.io/repository/nms/")
    maven("https://repo.mineinabyss.com/releases/com/ticxo/modelengine/2.1.6/modelengine-2.1.6.jar")
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.7")
    implementation("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    implementation("com.destroystokyo.paper:paper:1.16.5-R0.1-SNAPSHOT")
    implementation(files("libs/modelengine.jar"))
    implementation("io.mockk:mockk:1.11.0")
    implementation("io.mockk:mockk-agent-jvm:1.11.0")
}

application {
    mainClass.set("com.mineinabyss.resourcepack.Main")
}
