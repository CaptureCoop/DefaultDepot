package org.capturecoop.ccutils

import org.apache.commons.lang3.RandomStringUtils
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.time.LocalDateTime

object CCStringUtils {
    fun removeWhitespace(string: String) = string.replace("\\s+".toRegex(), "")

    fun getDateWithProperZero(date: Int): String {
        date.toString().also { return if(date < 10) "0$it" else it }
    }

    @JvmOverloads
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

    fun getRandomString(length: Int, useLetters: Boolean, useNumbers: Boolean) = RandomStringUtils.random(length, useLetters, useNumbers)

    fun correctSlashes(string: String): String {
        var returnVal = string.replace("\\\\".toRegex(), File.separator + File.separator).replace("/".toRegex(), File.separator + File.separator)
        if (!returnVal.endsWith(File.separator)) returnVal += File.separator
        return returnVal
    }

    fun endsWith(original: String, vararg text: String): Boolean {
        for (str in text) if (original.endsWith(str)) return true
        return false
    }

    fun format(message: String, vararg args: Any?): String? {
        var newMessage = message
        for (arg in args) {
            var replacer = "NULL"
            if (arg != null) replacer = arg.toString()
            newMessage = StringUtils.replaceOnce(newMessage, "%c", replacer)
        }
        return newMessage
    }
}