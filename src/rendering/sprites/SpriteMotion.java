package rendering.sprites;

import input.InputDirection;

public class SpriteMotion {

    private Sprite sprite;
    private int maxWidth;
    private int maxHeight;
    private int speed;

    public SpriteMotion(int maxWidth, int maxHeight, int speed){

        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.speed = speed;
    }

    public void updatePosition(Sprite sprite, InputDirection direction){
        switch (direction) {
            case UP:
                sprite.yPosition -= this.speed;
                if (sprite.yPosition < 0) {
                    sprite.yPosition = 0;
                }
                break;
            case DOWN:
                sprite.yPosition += this.speed;
                if (sprite.yPosition > maxHeight) {
                    sprite.yPosition = maxHeight;
                }
                break;
            case LEFT:
                sprite.xPosition -= this.speed;
                if (sprite.xPosition < 0) {
                    sprite.xPosition = 0;
                }
                break;
            case RIGHT:
                sprite.xPosition += this.speed;
                if (sprite.xPosition > maxWidth) {
                    sprite.xPosition = maxWidth;
                }
                break;
            default:
                break;
        }
    }
}
