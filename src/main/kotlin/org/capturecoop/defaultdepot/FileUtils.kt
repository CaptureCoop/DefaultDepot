package org.capturecoop.defaultdepot

import java.io.File

object FileUtils {
    fun getInternalInputStream(path: String) =  FileUtils::class.java.getResourceAsStream(path) ?: throw Exception("Internal file $path not found.")
    fun getFileInputStream(path: String) = File(path).inputStream()
}