package org.capturecoop.defaultdepot.math

import java.awt.Point

class Vector2F(var x: Float = 0.0F, var y: Float = 0.0F) {
    constructor(vec2f: Vector2F): this(vec2f.x, vec2f.y)
    constructor(pos: Point): this(pos.x.toFloat(), pos.y.toFloat())
    constructor(x: Double, y: Double): this(x.toFloat(), y.toFloat())
    constructor(x: Int, y: Int): this(x.toFloat(), y.toFloat())

    fun limitX(min: Float, max: Float): Vector2F {
        x = x.coerceIn(min, max)
        return this
    }

    fun limitY(min: Float, max: Float): Vector2F {
        y = y.coerceIn(min, max)
        return this
    }

    fun limit(min: Float, max: Float): Vector2F {
        limitX(min, max)
        limitY(min, max)
        return this
    }

    fun toPoint() = Point(x.toInt(), y.toInt())

    operator fun plus(other: Vector2F) = Vector2F(x + other.x, y + other.y)
    operator fun minus(other: Vector2F) = Vector2F(x - other.x, y - other.y)

    override fun toString() = "Vector2F(x=$x, y=$y)"
    override fun equals(other: Any?) = if(other is Vector2F) x == other.x && y == other.y else false
    override fun hashCode() = (31 * x + y).toInt()
}