package com.jtsymon.exptest.misc;

public class Rectangle {
    public final int x, y, width, height;
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Rectangle translate(int dx, int dy) {
        return new Rectangle(this.x + dx, this.y + dy, this.width, this.height);
    }
    public boolean contains(int x, int y) {
        return  this.x <= x && this.x + this.width >= x &&
                this.y <= y && this.y + this.height >= y;
    }
    public String toString() {
        return "[" + this.x + "," + this.y + " : " + this.width + "x" + this.height + "]";
    }
}
