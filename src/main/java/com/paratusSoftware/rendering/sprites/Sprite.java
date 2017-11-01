package com.paratusSoftware.rendering.sprites;

import com.paratusSoftware.input.InputHandler;

import java.awt.image.BufferedImage;

public abstract class Sprite implements InputHandler {

    protected int yPosition;
    protected int xPosition;

    public Sprite(
            final int xPosition, final int yPosition) {
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public abstract BufferedImage getImage();

}
