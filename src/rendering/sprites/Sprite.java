package rendering.sprites;

import input.InputHandler;

import java.awt.image.BufferedImage;

public abstract class Sprite implements InputHandler {

    protected int yPosition;
    protected int xPosition;

    public Sprite(
                  final int xPosition, final int yPosition) {
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    public int getxPosition() {
        return this.xPosition;
    }

    public int getyPosition() {
        return this.yPosition;
    }

    public abstract BufferedImage getImage();

}
