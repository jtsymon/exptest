package com.jtsymon.exptest.impl;

import com.jtsymon.exptest.impl.gui.Frame;
import com.jtsymon.exptest.impl.gui.GraphicsObject;
import com.jtsymon.exptest.io.FrameLoader;
import com.jtsymon.exptest.misc.Rectangle;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Browser extends java.awt.Frame {
    public static final long serialVersionUID = 1;
    public static final Browser _instance = new Browser();

    public static void main(String[] args) {
        _instance.setVisible(true);
    }

    Frame frame;

    public Browser() {
        this.frame = FrameLoader.loadFrame("testframe");
        this.setSize(1000, 800);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                Browser.this.frame.saveFrame();
                Browser.this.dispose();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Browser.this.frame.onMouseMoved(e.getX(), e.getY());
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void invalidateRect (Rectangle rect) {
        this.repaint(rect.x - 1, rect.y - 1, rect.width + 2, rect.height + 2);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        System.out.println ("Painting!");
        GraphicsObject go = new GraphicsObject(g);
        this.frame.draw(go);
    }
}
