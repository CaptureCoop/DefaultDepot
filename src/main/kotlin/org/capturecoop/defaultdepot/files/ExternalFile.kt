package org.capturecoop.defaultdepot.files

import java.io.File
import java.io.InputStream

class ExternalFile(override val path: String) : FileHandle() {
    private val file = File(path)

    override fun readText(): String = file.readText()

    override fun readBytes(): ByteArray = file.readBytes()

    override fun exists(): Boolean = file.exists()

    override fun getInputStream(): InputStream = file.inputStream()
}