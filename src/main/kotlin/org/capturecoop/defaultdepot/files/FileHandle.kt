package org.capturecoop.defaultdepot.files

import java.io.File
import java.io.InputStream

/**
 * FileHandle
 *
 * Allows access to data via InternalFile (In Jar / Classpath) and ExternalFile (on disk).
 *
 */
sealed class FileHandle {
    abstract val path: String
    abstract fun readText(): String
    abstract fun readBytes(): ByteArray
    abstract fun exists(): Boolean
    abstract fun getInputStream(): InputStream

    companion object {
        fun internal(path: String): FileHandle = InternalFile(path)
        fun external(path: String): FileHandle = ExternalFile(path)
        fun external(file: File): FileHandle = ExternalFile(file.absolutePath)
    }
}