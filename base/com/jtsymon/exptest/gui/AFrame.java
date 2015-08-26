package com.jtsymon.exptest.gui;

import com.jtsymon.exptest.impl.Browser;
import com.jtsymon.exptest.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class AFrame {
    protected final List<Item> items = new ArrayList<>();
    protected int mx, my;
    protected Item selected = null;

    public void addItem (Item i) {
        this.items.add(i);
    }

    public void saveFrame () {
        StringBuilder sb = new StringBuilder();
        for (Item i : this.items) {
            sb.append(i.save()).append("\n");
        }
        System.out.println(sb);
    }

    protected Item findAtPosition (int x, int y) {
        for (Item i : this.items) {
            if (i.getRect().contains(x, y)) {
                return i;
            }
        }
        return null;
    }

    public void onMouseMoved (int mx, int my) {
        this.mx = mx;
        this.my = my;
        Item selected = findAtPosition(this.mx, this.my);
        if (selected != this.selected) {
            if (this.selected != null) {
                this.selected.setHighlight (false);
                Browser._instance.invalidateRect(this.selected.getRect());
            }
            if (selected != null) {
                selected.setHighlight(true);
                Browser._instance.invalidateRect(selected.getRect());
            }
        }
        this.selected = selected;
    }
}
