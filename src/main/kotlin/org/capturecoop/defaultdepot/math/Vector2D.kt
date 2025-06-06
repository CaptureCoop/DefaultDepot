package org.capturecoop.defaultdepot.math

import java.awt.Point

class Vector2D(var x: Double = 0.0, var y: Double = 0.0) {
    constructor(vec2i: Vector2D): this(vec2i.x, vec2i.y)
    constructor(pos: Point): this(pos.x.toDouble(), pos.y.toDouble())
    constructor(x: Int, y: Int): this(x.toDouble(), y.toDouble())
    constructor(x: Float, y: Float): this(x.toDouble(), y.toDouble())

    fun limitX(min: Double, max: Double): Vector2D {
        x = x.coerceIn(min, max)
        return this
    }

    fun limitY(min: Double, max: Double): Vector2D {
        y = y.coerceIn(min, max)
        return this
    }

    fun limit(min: Double, max: Double): Vector2D {
        limitX(min, max)
        limitY(min, max)
        return this
    }

    fun toPoint() = Point(x.toInt(), y.toInt())

    operator fun plus(other: Vector2I) = Vector2I(x + other.x, y + other.y)
    operator fun minus(other: Vector2I) = Vector2I(x - other.x, y - other.y)

    override fun toString() = "Vector2I(x=$x, y=$y)"
    override fun equals(other: Any?) = if(other is Vector2D) x == other.x && y == other.y else false
    override fun hashCode() = (31 * x + y).toInt()
}