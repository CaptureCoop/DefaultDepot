package org.capturecoop.ccutils.utils

import kotlin.math.min
import kotlin.math.max

class CCMathUtils {
    companion object {
        fun clamp(number: Int, min: Int, max: Int) = min(max(number, min), max)
        fun clamp(number: Float, min: Float, max: Float) = min(max(number, min), max)
    }
}