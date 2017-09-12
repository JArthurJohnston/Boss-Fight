package rendering.sprites;

import input.InputDirection;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteImageStateMachine {

    private final Image spriteSheet;
    private final int gridX;
    private final int gridY;

    public SpriteImageStateMachine(final BufferedImage spriteSheet, final int gridX, final int gridY) {

        this.spriteSheet = spriteSheet;
        this.gridX = gridX;
        this.gridY = gridY;

        final int spriteWidth = spriteSheet.getWidth() / gridX;
        final int spriteHeight = spriteSheet.getHeight() / gridY;
    }

    public void update(final InputDirection direction) {

    }

    private abstract class ImageState {

        private final int xPosition;
        private final int yPosition;

        public ImageState(final int xPosition, final int yPosition) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }

        public void update(final InputDirection direction) {

        }

    }
}
