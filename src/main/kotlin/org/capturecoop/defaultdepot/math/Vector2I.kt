package org.capturecoop.defaultdepot.math

import java.awt.Point

class Vector2I(var x: Int = 0, var y: Int = 0) {
    constructor(vec2i: Vector2I): this(vec2i.x, vec2i.y)
    constructor(pos: Point): this(pos.x, pos.y)
    constructor(x: Double, y: Double): this(x.toInt(), y.toInt())
    constructor(x: Float, y: Float): this(x.toInt(), y.toInt())

    fun limitX(min: Int, max: Int): Vector2I {
        x = x.coerceIn(min, max)
        return this
    }

    fun limitY(min: Int, max: Int): Vector2I {
        y = y.coerceIn(min, max)
        return this
    }

    fun limit(min: Int, max: Int): Vector2I {
        limitX(min, max)
        limitY(min, max)
        return this
    }

    fun toPoint() = Point(x, y)

    operator fun plus(other: Vector2I) = Vector2I(x + other.x, y + other.y)
    operator fun minus(other: Vector2I) = Vector2I(x - other.x, y - other.y)

    override fun toString() = "Vector2I(x=$x, y=$y)"
    override fun equals(other: Any?) = if(other is Vector2I) x == other.x && y == other.y else false
    override fun hashCode() = (31 * x + y)
}