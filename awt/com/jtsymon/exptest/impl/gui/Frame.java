package com.jtsymon.exptest.impl.gui;

import com.jtsymon.exptest.gui.AFrame;
import com.jtsymon.exptest.items.Item;

public class Frame extends AFrame {
    public void draw(GraphicsObject go) {
        for (Item i : this.items) {
            i.draw(go);
        }
    }
}
