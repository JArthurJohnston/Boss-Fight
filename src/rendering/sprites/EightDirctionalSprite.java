package rendering.sprites;

import input.InputDirection;
import input.UserInputs;
import rendering.sprites.Sprite;

import java.awt.image.BufferedImage;

public class EightDirctionalSprite extends Sprite {

    private final int gridWidth;
    private final int gridHeight;

    public EightDirctionalSprite(final BufferedImage image, final int xPosition, final int yPosition, final int gridWidth, final int gridHeight) {
        super(image, xPosition, yPosition);
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;

    }

    @Override
    public void updateWith(final UserInputs inputs) {
        final InputDirection direction = InputDirection.getDirectionFrom(inputs);
        switch (direction) {
            case UP:
                break;
            case UP_RIGHT:
                break;
            case UP_LEFT:
                break;
            case DOWN:
                break;
            case DOWN_RIGHT:
                break;
            case DOWN_LEFT:
                break;
            case RIGHT:
                break;
            case LEFT:
                break;
            default:
        }

    }

    @Override
    public BufferedImage getImage() {
        return super.getImage();
    }
}
