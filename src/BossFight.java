import input.InputMap;
import rendering.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BossFight {

    private final Frame gameWindow;
    private final Java2DRenderer renderer;
    private final Environment environment;
    private final input.InputMap inputMap;

    private BossFight() {
        this.gameWindow = initFrame();
        this.renderer = new Java2DRenderer(this.gameWindow);
        this.environment = initEnvironment();
        this.inputMap = new input.InputMap();
    }

    private void loop() {
        while (true) {
            update();
            draw();
        }
    }

    private void draw() {
        this.environment.renderOn(this.renderer);
    }

    private void update(){
        this.environment.updateWith(this.inputMap);
    }

    private Environment initEnvironment() {
        try {
            final BufferedImage backgroundImage = ImageIO.read(new File("./res/green_background.JPG"));
            final BufferedImage spriteImage = ImageIO.read(new File("./res/black mage.png"));
            final Background background = new Background(backgroundImage);
            final Sprite sprite = new Sprite(spriteImage, 50, 50){

                @Override
                public void updateWith(InputMap map) {
                    final int maxVerticalValue = gameWindow.getHeight() - this.image.getHeight();
                    final int maxHoriontalValue = gameWindow.getWidth() - this.image.getWidth();
                    if(map.at(KeyEvent.VK_DOWN)){
                        this.yPosition += speed;
                        if (this.yPosition > maxVerticalValue) {
                            this.yPosition = maxVerticalValue;
                        }
                    }else if (map.at(KeyEvent.VK_UP)){
                        this.yPosition -= speed;
                        if (this.yPosition < 0) {
                            this.yPosition = 0;
                        }
                    }else if (map.at(KeyEvent.VK_RIGHT)){
                        this.xPosition += speed;
                        if (this.xPosition > maxHoriontalValue) {
                            this.xPosition = maxHoriontalValue;
                        }
                    }else if (map.at(KeyEvent.VK_LEFT)){
                        this.xPosition -= speed;
                        if (this.xPosition < 0) {
                            this.xPosition = 0;
                        }
                    }
                }
            };


            return new Environment() {
                @Override
                public void updateWith(input.InputMap map) {
                    //theres an input map in swing.
                    sprite.updateWith(map);
                }

                @Override
                public void renderOn(Java2DRenderer renderer) {
                    renderer.addBackground(background)
                            .addSprite(sprite)
                            .render();
                }
            };

        } catch (final IOException e) {
            e.printStackTrace();
            return new Environment() {
                @Override
                public void updateWith(input.InputMap map) {
                    //NO-OP
                }

                @Override
                public void renderOn(Java2DRenderer renderer) {
                    //NO-OP
                }
            };
        }
    }

    private Frame initFrame() {
        final Frame frame = new Frame("BOSS FIGHT!!");
        frame.add(new JPanel());


        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {
            }

            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else {
                    inputMap.press(e.getKeyCode());
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                inputMap.release(e.getKeyCode());
            }
        });
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice gs = ge.getDefaultScreenDevice();
        gs.setFullScreenWindow(frame);
        frame.validate();
        return frame;
    }


    public static void main(final String[] args) {
        final BossFight bossFight = new BossFight();
        bossFight.loop();
    }


}
