package com.paratusSoftware.rendering.sprites;

import com.paratusSoftware.input.InputDirection;
import com.paratusSoftware.input.UserInputs;

import java.awt.image.BufferedImage;

public class FourDirctionalSprite extends Sprite {

    private final SpriteSheet spriteSheet;
    private InputDirection direction;
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
        if (direction != InputDirection.NONE) {
            this.gridX++;
            if (this.gridX >= spriteSheet.getColumns()) {
                this.gridX = 0;
            }
        }
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

    @Override
    public BufferedImage getImage() {
        return this.spriteSheet.getSpriteAt(gridX, gridY);
    }
}
