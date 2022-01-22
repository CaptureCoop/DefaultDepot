package org.capturecoop.ccutils.math;

import java.awt.Point;

public class CCVector2Float {
    private float x;
    private float y;

    public CCVector2Float() {
        x = 0;
        y = 0;
    }

    public CCVector2Float(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public CCVector2Float(CCVector2Float vector) {
        if(vector != null) {
            x = vector.x;
            y = vector.y;
        } else {
            x = 0;
            y = 0;
        }
    }

    public CCVector2Float(Point point) {
        x = point.x;
        y = point.y;
    }

    public CCVector2Float(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }

    public boolean isSame(CCVector2Float vector) {
        return x == vector.x && y == vector.y;
    }

    public CCVector2Float add(CCVector2Float vector) {
        this.x += vector.getX();
        this.y += vector.getY();
        return this;
    }

    public CCVector2Float sub(CCVector2Float vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
        return this;
    }

    public static CCVector2Float add(CCVector2Float vector1, CCVector2Float vector2) {
        return new CCVector2Float(vector1).add(vector2);
    }

    public static CCVector2Float sub(CCVector2Float vector1, CCVector2Float vector2) {
        return new CCVector2Float(vector1).sub(vector2);
    }

    public CCVector2Float limitX(float min, float max) {
        x = Math.min(Math.max(x, min), max);
        return this;
    }

    public CCVector2Float limitY(float min, float max) {
        y = Math.min(Math.max(y, min), max);
        return this;
    }

    public CCVector2Float limit(float min, float max) {
        limitX(min, max);
        limitY(min, max);
        return this;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public Point toPoint() {
        return new Point((int)x, (int)y);
    }

    public String toString() {
        return "Vector2Float(" + x + "/" + y + ")";
    }
}