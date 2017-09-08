package rendering;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Sprite implements Renderable {

    private final BufferedImage image;
    private int yPosition;
    private int xPosition;

    public Sprite(final BufferedImage image, final int xPosition, final int yPosition) {
        this.image = image;
        this.yPosition = yPosition;
        this.xPosition = xPosition;
    }

    @Override
    public void renderOn(final Java2DRenderer renderer) {
        renderer.addSprite(this);
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

    public void update(final int keyCode) {
        final int maxVerticalValue = 1080 - this.image.getHeight();
        final int maxHoriontalValue = 1920 - this.image.getWidth();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                this.yPosition--;
                if (this.yPosition < 0) {
                    this.yPosition = 0;
                }
                break;
            case KeyEvent.VK_DOWN:
                this.yPosition--;
                if (this.yPosition > maxVerticalValue) {
                    this.yPosition = maxVerticalValue;
                }
                break;
            case KeyEvent.VK_RIGHT:
                this.xPosition++;
                if (this.xPosition > maxHoriontalValue) {
                    this.xPosition = maxHoriontalValue;
                }
                break;
            case KeyEvent.VK_LEFT:
                this.xPosition--;
                if (this.yPosition < 0) {
                    this.yPosition = 0;
                }
                break;
        }
    }
}
