package com.tgorgics.barcode.dto;

import lombok.Getter;
import lombok.Setter;

public class BarcodeDTO {

    @Getter
    @Setter
    protected String data;
    @Getter
    @Setter
    protected String label;
    @Getter
    @Setter
    protected boolean drawText = true;
    @Getter
    @Setter
    protected int width = 2;
    @Getter
    @Setter
    protected int height = 50;
    @Getter
    @Setter
    private int resolution;

    private final boolean headless = false;

    public String getData() {
        return this.data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public boolean isDrawText() {
        return this.drawText;
    }

    public void setDrawText(final boolean drawText) {
        this.drawText = drawText;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getResolution() {
        return this.resolution;
    }

    public void setResolution(final int resolution) {
        this.resolution = resolution;
    }

    public boolean isHeadless() {
        return this.headless;
    }

    @Override
    public String toString() {
        return "BarcodeDTO [data=" + this.data + ", label=" + this.label + ", drawText=" + this.drawText + ", width=" + this.width
                + ", height=" + this.height + ", resolution=" + this.resolution + "]";
    }

}
