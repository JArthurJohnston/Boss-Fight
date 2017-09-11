package rendering.sprites;

import input.InputHandler;

import java.awt.image.BufferedImage;

public abstract class Sprite implements InputHandler {

    protected final BufferedImage image;
    protected int yPosition;
    protected int xPosition;
    protected final int speed = 3;

    public Sprite(final BufferedImage image,
                  final int xPosition, final int yPosition) {
        this.image = image;
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    public int getxPosition() {
        return this.xPosition;
    }

    public int getyPosition() {
        return this.yPosition;
    }

    public BufferedImage getImage() {
        return this.image;
    }

}
