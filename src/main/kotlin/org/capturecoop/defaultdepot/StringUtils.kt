package org.capturecoop.defaultdepot

import java.io.File
import java.time.LocalDateTime

/**
 * String Utils
 *
 */
object StringUtils {
    private val lettersLowercase = ('a'..'z').toList()
    private val lettersUppercase = ('A'..'Z').toList()
    private val numbers = (0..9).toList().map { it.toString().first() }

    /**
     * Remove whitespace
     *
     * @param string
     * @return [String]
     */
    fun removeWhitespace(string: String) = string.replace("\\s+".toRegex(), "")

    /**
     * Get date with proper zero. Adds a 0 to any Number under 10.
     *
     * Example:
     *
     * 5 returns 05
     *
     * 10 returns 10
     *
     * @param date
     * @return [String]
     */
    fun getDateWithProperZero(date: Int): String {
        date.toString().also { return if(date < 10) "0$it" else it }
    }

    /**
     * Formats a String with some time based placeholders.
     *
     * Available placeholders:
     * %hour%, %minute%, %second%, %ms%, %day%, %month%, %year%
     *
     * @param string Input String with formatting variables
     * @param time The time to use for the transformation. Defaults to [LocalDateTime.now()]
     * @return [String] Formatted String
     */
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

    /**
     * Generate a random [String]
     *
     * @param length Length of the generated String
     * @param lowercaseLetters Use Lowercase letters. Default is true
     * @param uppercaseLetters Use Uppercase letters. Default is true
     * @param numbers Use Numbers. Default is true
     * @return [String] Random String
     */
    fun getRandomString(
        length: Int,
        lowercaseLetters: Boolean = true,
        uppercaseLetters: Boolean = true,
        numbers: Boolean = true
    ): String {
        val available = ArrayList<Char>()
        if(lowercaseLetters) available.addAll(lettersLowercase)
        if(uppercaseLetters) available.addAll(lettersUppercase)
        if(numbers) available.addAll(this.numbers)
        return Array(length) { available.random() }.joinToString(separator = "")
    }

    /**
     * Replaces Backwards (\) Slashes with Forward Slashes (/)
     *
     * @param string Input String
     * @return [String] Output String
     */
    fun correctSlashes(string: String): String {
        var returnVal = string.replace("\\\\".toRegex(), File.separator + File.separator).replace("/".toRegex(), File.separator + File.separator)
        if (!returnVal.endsWith(File.separator)) returnVal += File.separator
        return returnVal
    }

    /**
     * Checks if [original] ends with any one of [text]
     *
     * @param original The String to search
     * @param text List of Strings to search in
     * @return [Boolean]
     */
    fun endsWith(original: String, vararg text: String): Boolean {
        for (str in text) if (original.endsWith(str)) return true
        return false
    }
}