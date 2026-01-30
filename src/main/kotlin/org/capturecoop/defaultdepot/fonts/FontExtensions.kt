package org.capturecoop.defaultdepot.fonts

import org.capturecoop.defaultdepot.files.FileHandle
import java.awt.Font

fun FileHandle.getFont(format: Int = Font.TRUETYPE_FONT, size: Float = 12f): Font {
    return getInputStream().use { stream -> Font.createFont(format, stream) }.deriveFont(size)
}