package com.paratusSoftware.rendering.sprites;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage image;
    private int numberOfRows;
    private int numberOfColumns;
    private final int spriteHeight;
    private final int spriteWidth;

    public SpriteSheet(BufferedImage image, int numberOfRows, int numberOfColumns){
        this.image = image;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        spriteWidth = image.getWidth() / numberOfColumns;
        spriteHeight = image.getHeight() / numberOfRows;
    }

    public BufferedImage getSpriteAt(int row, int column){
        int xPosition = row * spriteWidth;
        int yPosition = column * spriteHeight;
        return this.image.getSubimage(xPosition, yPosition, spriteHeight, spriteWidth);
    }

    public int getColumns() {
        return numberOfColumns;
    }
}
