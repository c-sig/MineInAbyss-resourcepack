package com.mineinabyss.resourcepack.helpers

import java.io.File

operator fun File.div(path: String) = File(this, path)
