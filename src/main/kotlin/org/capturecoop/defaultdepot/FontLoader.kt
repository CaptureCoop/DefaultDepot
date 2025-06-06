package org.capturecoop.defaultdepot

import java.awt.Font
import java.io.InputStream

object FontLoader {
    fun loadFromInputStream(inputStream: InputStream): Font {
        return Font.createFont(Font.TRUETYPE_FONT, inputStream)
    }

    fun loadFromInternal(path: String): Font {
        return FileUtils.getInternalInputStream(path).use { inputStream ->
            loadFromInputStream(inputStream)
        }
    }

    fun loadFromInternal(path: String, size: Float): Font {
        return loadFromInternal(path).deriveFont(size)
    }

    fun loadFromFile(path: String): Font {
        return FileUtils.getFileInputStream(path).use { inputStream ->
            loadFromInputStream(inputStream)
        }
    }

    fun loadFromFile(path: String, size: Float): Font {
        return loadFromFile(path).deriveFont(size)
    }
}