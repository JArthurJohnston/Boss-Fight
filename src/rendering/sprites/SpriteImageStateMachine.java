package rendering.sprites;

import input.InputDirection;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteImageStateMachine {

    private final Image spriteSheet;
    private final int gridX;
    private final int gridY;
    private ImageState state;

    public SpriteImageStateMachine(final BufferedImage spriteSheet, final int gridX, final int gridY) {

        this.spriteSheet = spriteSheet;
        this.gridX = gridX;
        this.gridY = gridY;

        final int spriteWidth = spriteSheet.getWidth() / gridX;
        final int spriteHeight = spriteSheet.getHeight() / gridY;

        state = new ImageState(0,0) {
            @Override
            ImageState update(InputDirection direction) {
                return null;
            }
        };
    }

    private abstract class ImageState {

        private int xPosition;
        private int yPosition;

        public ImageState(int xPosition, int yPosition){
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }

        abstract ImageState update(InputDirection direction);

    }
}
