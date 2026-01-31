package org.capturecoop.defaultdepot.files

import java.io.InputStream

class InternalFile(override val path: String) : FileHandle() {
    override fun readText(): String = getInputStream().use { stream -> String(stream.readAllBytes()) }

    override fun readBytes(): ByteArray = getInputStream().use { stream -> stream.readAllBytes() }

    override fun exists(): Boolean = InternalFile::class.java.getResource(path) != null

    override fun getInputStream(): InputStream = InternalFile::class.java.getResourceAsStream(path) ?: throw Exception("Internal File not found: $path")
}