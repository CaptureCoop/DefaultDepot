package org.capturecoop.defaultdepot

import java.io.File
import java.time.LocalDateTime

object StringUtils {
    private val lettersLowercase = ('a'..'z').toList()
    private val lettersUppercase = ('A'..'Z').toList()
    private val numbers = (0..9).toList().map { it.toChar() }

    fun removeWhitespace(string: String) = string.replace("\\s+".toRegex(), "")

    fun getDateWithProperZero(date: Int): String {
        date.toString().also { return if(date < 10) "0$it" else it }
    }

    fun formatDateTimeString(string: String, time: LocalDateTime = LocalDateTime.now()): String {
        var returnVal = string
        returnVal = returnVal.replace("%hour%", getDateWithProperZero(time.hour))
        returnVal = returnVal.replace("%minute%", getDateWithProperZero(time.minute))
        returnVal = returnVal.replace("%second%", getDateWithProperZero(time.second))
        returnVal = returnVal.replace("%ms%", getDateWithProperZero(time.nano / 10000000))
        returnVal = returnVal.replace("%day%", getDateWithProperZero(time.dayOfMonth))
        returnVal = returnVal.replace("%month%", getDateWithProperZero(time.monthValue))
        returnVal = returnVal.replace("%year%", time.year.toString())
        return returnVal
    }

    fun getRandomString(length: Int, lowercaseLetters: Boolean, uppercaseLetters: Boolean, useNumbers: Boolean): String {
        val available = ArrayList<Char>()
        if(lowercaseLetters) available.addAll(lettersLowercase)
        if(uppercaseLetters) available.addAll(lettersUppercase)
        if(useNumbers) available.addAll(numbers)
        return Array(length) { available.random() }.joinToString(separator = "")
    }

    fun correctSlashes(string: String): String {
        var returnVal = string.replace("\\\\".toRegex(), File.separator + File.separator).replace("/".toRegex(), File.separator + File.separator)
        if (!returnVal.endsWith(File.separator)) returnVal += File.separator
        return returnVal
    }

    fun endsWith(original: String, vararg text: String): Boolean {
        for (str in text) if (original.endsWith(str)) return true
        return false
    }
}