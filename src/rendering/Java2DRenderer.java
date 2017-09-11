package rendering;

import rendering.sprites.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DRenderer {

    private final Frame frame;
    private final Graphics graphics;
    private final Image renderingBuffer;
    private final Graphics graphicsBuffer;

    public Java2DRenderer(final Frame frame) {
        this.frame = frame;
        this.renderingBuffer = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        this.graphicsBuffer = this.renderingBuffer.getGraphics();
        this.graphics = frame.getGraphics();
    }

    public Java2DRenderer addBackground(final Background background) {
        this.graphicsBuffer.drawImage(background.getCurrentFrame(), 0, 0, this.frame.getWidth(), this.frame.getHeight(), this.frame);
        return this;
    }

    public Java2DRenderer addSprite(final Sprite sprite) {
        final BufferedImage image = sprite.getImage();
        this.graphicsBuffer.drawImage(image, sprite.getxPosition(), sprite.getyPosition(), this.frame);
        return this;
    }

    public void render() {
        this.graphics.drawImage(this.renderingBuffer, 0, 0, this.frame.getWidth(), this.frame.getHeight(), this.frame);
    }
}

