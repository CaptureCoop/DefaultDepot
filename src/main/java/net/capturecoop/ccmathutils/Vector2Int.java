package net.capturecoop.ccmathutils;

import java.awt.Point;

public class Vector2Int {
    private int x;
    private int y;

    public Vector2Int() {
        x = 0;
        y = 0;
    }

    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2Int(Vector2Int vector) {
        if(vector != null) {
            x = vector.x;
            y = vector.y;
        } else {
            x = 0;
            y = 0;
        }
    }

    public Vector2Int(Point point) {
        x = (int) point.getX();
        y = (int) point.getY();
    }

    public Vector2Int(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public boolean isSame(Vector2Int vector) {
        return x == vector.x && y == vector.y;
    }

    public Vector2Int add(Vector2Int vector) {
        this.x += vector.getX();
        this.y += vector.getY();
        return this;
    }

    public Vector2Int sub(Vector2Int vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
        return this;
    }

    public static Vector2Int add(Vector2Int vector1, Vector2Int vector2) {
        return new Vector2Int(vector1).add(vector2);
    }

    public static Vector2Int sub(Vector2Int vector1, Vector2Int vector2) {
        return new Vector2Int(vector1).sub(vector2);
    }

    public Vector2Int limitX(int min, int max) {
        x = Math.min(Math.max(x, min), max);
        return this;
    }

    public Vector2Int limitY(int min, int max) {
        y = Math.min(Math.max(y, min), max);
        return this;
    }

    public Vector2Int limit(int min, int max) {
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
        return "Vector2Int(" + x + "/" + y + ")";
    }
}