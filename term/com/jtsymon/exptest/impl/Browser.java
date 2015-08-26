package com.jtsymon.exptest.impl;

import com.jtsymon.exptest.impl.gui.Frame;
import com.jtsymon.exptest.impl.gui.GraphicsObject;
import com.jtsymon.exptest.io.FrameLoader;

public class Browser {
    public static void main(String[] args) {
        Frame frame = FrameLoader.loadFrame("testframe");
        GraphicsObject go = new GraphicsObject();
        frame.draw(go);
        for (int y = 0; y < go.buffer.length; y++) {
            System.out.println (new String(go.buffer[y]));
        }
    }
}