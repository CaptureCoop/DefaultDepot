package org.capturecoop.ccutils.math

import org.capturecoop.ccutils.utils.CCMathUtils
import java.awt.Point

class CCVector2Int(var x: Int = 0, var y: Int = 0) {
    constructor(vector: CCVector2Int): this(vector.x, vector.y)
    constructor(point: Point): this(point.x, point.y)
    constructor(x: Double, y: Double): this(x.toInt(), y.toInt())

    fun limitX(min: Int, max: Int): CCVector2Int {
        x = CCMathUtils.clamp(x, min, max)
        return this
    }

    fun limitY(min: Int, max: Int): CCVector2Int {
        y = CCMathUtils.clamp(y, min, max)
        return this
    }

    fun limit(min: Int, max: Int): CCVector2Int {
        limitX(min, max)
        limitY(min, max)
        return this
    }

    fun toPoint() = Point(x, y)

    operator fun plus(other: CCVector2Int) = CCVector2Int(x + other.x, y + other.y)
    operator fun minus(other: CCVector2Int) = CCVector2Int(x - other.x, y - other.y)
    //operator fun plusAssign(other: CCVector2Int) = kotlin.run { x += other.x; y += other.y }
    //operator fun minusAssign(other: CCVector2Int) = kotlin.run { x -= other.x; y -= other.y }

    override fun toString() = "CCVector2Int[%c, %c]"
    override fun equals(other: Any?) = if(other is CCVector2Int) x == other.x && y == other.y else false
    override fun hashCode() = 31 * x + y
}

class CCVector2Float(var x: Float = 0.0F, var y: Float = 0.0F) {
    constructor(vector: CCVector2Float): this(vector.x, vector.y)
    constructor(point: Point): this(point.x.toFloat(), point.y.toFloat())
    constructor(x: Double, y: Double): this(x.toFloat(), y.toFloat())

    fun limitX(min: Float, max: Float): CCVector2Float {
        x = CCMathUtils.clamp(x, min, max)
        return this
    }

    fun limitY(min: Float, max: Float): CCVector2Float {
        y = CCMathUtils.clamp(y, min, max)
        return this
    }

    fun limit(min: Float, max: Float): CCVector2Float {
        limitX(min, max)
        limitY(min, max)
        return this
    }

    fun toPoint() = Point(x.toInt(), y.toInt())

    operator fun plus(other: CCVector2Float) = CCVector2Float(x + other.x, y + other.y)
    operator fun minus(other: CCVector2Float) = CCVector2Float(x - other.x, y - other.y)
    //operator fun plusAssign(other: CCVector2Float) = kotlin.run { x += other.x; y += other.y }
    //operator fun minusAssign(other: CCVector2Float) = kotlin.run { x -= other.x; y -= other.y }

    override fun toString() = "CCVector2Float[%c, %c]"
    override fun equals(other: Any?) = if(other is CCVector2Float) x == other.x && y == other.y else false
    override fun hashCode() = (31 * x + y).toInt()
}