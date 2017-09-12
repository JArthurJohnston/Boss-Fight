package rendering.sprites;

import input.InputDirection;
import input.UserInputs;

import java.awt.image.BufferedImage;

public class FourDirctionalSprite extends Sprite {

    private final InputDirection direction;
    private final SpriteSheet spriteSheet;
    private int gridX;
    private int gridY;

    public FourDirctionalSprite(final int xPosition, final int yPosition,
                                SpriteSheet sheet, final int gridX, final int gridY) {
        super(xPosition, yPosition);
        this.spriteSheet = sheet;
        this.gridX = gridX;
        this.gridY = gridY;
        this.direction = InputDirection.DOWN;
    }

    @Override
    public void updateWith(final UserInputs inputs) {
        final InputDirection direction = InputDirection.getDirectionFrom(inputs);
        if (direction == this.direction) {
            this.gridX++;
            if (this.gridX >= spriteSheet.getColumns()) {
                this.gridX = 0;
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
        final int x = this.gridX * this.spriteSheet.getWidth();
        final int y = this.gridY * this.spriteSheet.getHeight();
        return this.spriteSheet.getSpriteAt(x, y);
    }
}
