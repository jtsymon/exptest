package com.jtsymon.exptest.impl;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Impl {
    public static final BufferedImage _measureBI =
        new BufferedImage (1, 1, BufferedImage.TYPE_INT_ARGB);
    public static final Graphics _measureG =
        _measureBI.getGraphics();
}
