package com.jtsymon.exptest.items;

import com.jtsymon.exptest.impl.gui.GraphicsObject;
import com.jtsymon.exptest.io.FrameLoader;
import com.jtsymon.exptest.misc.Rectangle;

public abstract class Item {
    protected int x, y;
    protected int id;
    protected Rectangle rect;
    protected boolean highlighted = false;

    public Item (int id) {
        this.id = id;
    }

    public void setPosition (int x, int y) {
        int dx = x - this.x, dy = y - this.y;
        this.x = x;
        this.y = y;
        if (this.rect != null) {
            this.rect = this.rect.translate(dx, dy);
        } else {
            this.measure();
        }
    }

    public void setX (int x) {
        this.setPosition(x, this.y);
    }

    public int getX() {
        return this.x;
    }

    public void setY (int y) {
        this.setPosition(this.x, y);
    }

    public int getY() {
        return this.y;
    }

    public Rectangle getRect() {
        return this.rect;
    }

    public void setHighlight (boolean highlighted) {
        this.highlighted = highlighted;
    }

    public boolean getHighlighted () {
        return this.highlighted;
    }

    protected abstract Rectangle measure();

    public abstract void draw(GraphicsObject go);

    public String save() {
        return FrameLoader.saveItem(this.getClass().getSimpleName(), this.id, this.x + " " + this.y);
    }
}
