package com.jtsymon.exptest.impl.gui;

import com.jtsymon.exptest.gui.AFrame;
import com.jtsymon.exptest.impl.Browser;
import com.jtsymon.exptest.items.Item;
import com.jtsymon.exptest.misc.Rectangle;

public class Frame extends AFrame {
    public void draw(GraphicsObject go) {
        for (Item i : this.items) {
            i.draw(go);
        }
    }

    public void invalidateRect (Rectangle rect) {
        Browser._instance.repaint(rect.x - 1, rect.y - 1, rect.width + 2, rect.height + 2);
    }
}
