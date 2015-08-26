package com.jtsymon.exptest.impl.items;

import com.jtsymon.exptest.impl.Impl;
import com.jtsymon.exptest.impl.gui.GraphicsObject;
import com.jtsymon.exptest.items.AText;
import com.jtsymon.exptest.misc.Rectangle;

import java.awt.*;

public class Text extends AText {

    private Font _font;

    public Text (int id) {
        super(id);
    }

    @Override
    protected void _setFont (String font, int size) {
        super._setFont(font, size);
        this._font = new Font(font, Font.PLAIN, size);
    }

    protected Rectangle measure() {
        FontMetrics metrics = Impl._measureG.getFontMetrics(this._font);
        return new Rectangle(
                this.x - 1,
                this.y - metrics.getMaxAscent() - 1,
                metrics.stringWidth(this.getText()) + 2,
                metrics.getMaxAscent() + metrics.getMaxDescent() + 2
        );
    }

    public void draw(GraphicsObject go) {
        Graphics g = go.g;
        System.out.println(g.getClipBounds());
        g.setFont(this._font);
        g.drawString(this.getText(), this.x, this.y);
        System.out.println(this.getHighlighted());
        if (this.getHighlighted()) {
            Rectangle rect = this.getRect();
            g.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
}
