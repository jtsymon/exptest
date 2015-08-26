package com.jtsymon.exptest.impl.items;

import com.jtsymon.exptest.impl.gui.GraphicsObject;
import com.jtsymon.exptest.items.AText;
import com.jtsymon.exptest.misc.Rectangle;

public class Text extends AText {
    public Text(int id) {
        super(id);
    }

    @Override
    protected Rectangle measure() {
        return new Rectangle(
                this.x,
                this.y,
                this.getText().length(),
                1
        );
    }

    @Override
    public void draw(GraphicsObject go) {
        int sx = this.x / 20,
            sy = this.y / 20;
        char[] line = go.buffer[sy];
        char[] text = this.getText().toCharArray();
        for (int i = sx, n = Math.min(sx + this.getText().length(), 80); i < n; i++) {
            line[i] = text[i - sx];
        }
    }
}
