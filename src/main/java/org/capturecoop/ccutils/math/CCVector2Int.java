package org.capturecoop.ccutils.math;

import org.capturecoop.ccutils.utils.CCStringUtils;

import java.awt.Point;

public class CCVector2Int {
    private int x;
    private int y;

    public CCVector2Int() {
        x = 0;
        y = 0;
    }

    public CCVector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CCVector2Int(CCVector2Int vector) {
        if(vector != null) {
            x = vector.x;
            y = vector.y;
        } else {
            x = 0;
            y = 0;
        }
    }

    public CCVector2Int(Point point) {
        x = point.x;
        y = point.y;
    }

    public CCVector2Int(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public boolean isSame(CCVector2Int vector) {
        return x == vector.x && y == vector.y;
    }

    public CCVector2Int add(CCVector2Int vector) {
        this.x += vector.getX();
        this.y += vector.getY();
        return this;
    }

    public CCVector2Int sub(CCVector2Int vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
        return this;
    }

    public static CCVector2Int add(CCVector2Int vector1, CCVector2Int vector2) {
        return new CCVector2Int(vector1).add(vector2);
    }

    public static CCVector2Int sub(CCVector2Int vector1, CCVector2Int vector2) {
        return new CCVector2Int(vector1).sub(vector2);
    }

    public CCVector2Int limitX(int min, int max) {
        x = Math.min(Math.max(x, min), max);
        return this;
    }

    public CCVector2Int limitY(int min, int max) {
        y = Math.min(Math.max(y, min), max);
        return this;
    }

    public CCVector2Int limit(int min, int max) {
        limitX(min, max);
        limitY(min, max);
        return this;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public Point toPoint() {
        return new Point(x,y);
    }

    public String toString() {
        return CCStringUtils.format("Vector2Int[%c, %c]", x, y);
    }
}