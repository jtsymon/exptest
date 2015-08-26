package com.jtsymon.exptest.impl.gui;

import com.jtsymon.exptest.gui.AFrame;
import com.jtsymon.exptest.items.Item;
import com.jtsymon.exptest.misc.Rectangle;

public class Frame extends AFrame {

    @Override
    public void draw(GraphicsObject go) {
        for (Item i : this.items) {
            i.draw (go);
        }
    }

    @Override
    public void invalidateRect(Rectangle rect) {

    }
}
