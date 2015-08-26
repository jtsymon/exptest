package com.jtsymon.exptest.items;

import com.jtsymon.exptest.io.FrameLoader;

public abstract class AText extends Item {
    private String text;
    private String font;
    private int size;

    public AText (int id) {
        super(id);
        this._setFont ("sans", 12);
        this._setText ("");
    }

    protected void _setFont (String font, int size) {
        this.font = font;
        this.size = size;
    }

    public void setFont (String font, int size) {
        this._setFont(font, size);
        this.rect = this.measure();
    }

    public void setFont (String font) {
        this.setFont(font, this.size);
    }

    public String getFont() {
        return this.font;
    }

    public void setSize (int size) {
        this.setFont(this.font, size);
    }

    public int getSize() {
        return this.size;
    }

    protected void _setText (String text) {
        this.text = text;
    }

    public void setText (String text) {
        this._setText (text);
        this.rect = this.measure();
    }

    public String getText() {
        return this.text;
    }

    public String save() {
        return FrameLoader.saveItem(super.save(), this.getFont(), this.getSize(), this.getText());
    }
}
