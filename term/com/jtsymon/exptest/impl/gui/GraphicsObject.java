package com.jtsymon.exptest.impl.gui;


import java.util.Arrays;

public class GraphicsObject {
    public final char[][] buffer;

    public GraphicsObject() {
        this.buffer = new char[24][80];
        for (int y = 0; y < this.buffer.length; y++) {
            Arrays.fill(buffer[y], ' ');
        }
    }
}
