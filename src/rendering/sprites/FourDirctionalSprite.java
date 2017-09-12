package rendering.sprites;

import input.InputDirection;
import input.UserInputs;

import java.awt.image.BufferedImage;

public class FourDirctionalSprite extends Sprite {

    private final int spriteWidth;
    private final int spriteHeight;
    private final InputDirection direction;
    private final int numberOfColumns;
    private int gridX;
    private int gridY;

    public FourDirctionalSprite(final BufferedImage image, final int xPosition, final int yPosition,
                                final int numberOfColumns, final int numberOfRows, final int gridX, final int gridY) {
        super(image, xPosition, yPosition);
        this.gridX = gridX;
        this.gridY = gridY;
        this.numberOfColumns = numberOfColumns;
        this.spriteWidth = image.getWidth() / this.numberOfColumns;
        this.spriteHeight = image.getHeight() / numberOfRows;
        this.direction = InputDirection.DOWN;
    }

    @Override
    public void updateWith(final UserInputs inputs) {
        final InputDirection direction = InputDirection.getDirectionFrom(inputs);
        if (direction == this.direction) {
            this.gridX++;
            if(gridX >= numberOfColumns){
                gridX = 0;
            }
        } else {
            this.gridX = 0;
            switch (direction) {
                case UP:
                    this.gridY = 2;
                    break;
                case DOWN:
                    this.gridY = 0;
                    break;
                case RIGHT:
                    this.gridY = 1;
                    break;
                case LEFT:
                    this.gridY = 3;
                    break;
                default:
            }
        }
    }

    @Override
    public BufferedImage getImage() {
        final int x = this.gridX * this.spriteWidth;
        final int y = this.gridY * this.spriteHeight;
        return this.image.getSubimage(x, y, this.spriteWidth, this.spriteHeight);
    }
}
