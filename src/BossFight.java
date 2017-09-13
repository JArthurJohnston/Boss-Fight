import input.InputDirection;
import input.UserInputs;
import rendering.*;
import rendering.sprites.FourDirctionalSprite;
import rendering.sprites.Sprite;
import rendering.sprites.SpriteMotion;
import rendering.sprites.SpriteSheet;

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
    private final UserInputs userInputs;

    private BossFight() {
        this.gameWindow = initFrame();
        this.renderer = new Java2DRenderer(this.gameWindow);
        this.environment = initEnvironment();
        this.userInputs = new UserInputs();
    }

    private void loop() {
        int fps = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();
        final double frameRate = 60.0;
        long gameTick = System.nanoTime();
        final double frameRateInNanoSeconds = 1000000000.0 / frameRate;
        double delta = 0;
        while (true) {
            final long now = System.nanoTime();

            delta += (now - gameTick) / frameRateInNanoSeconds;
            gameTick = now;
            while (delta >= 1) {
                updates++;
                update();
                delta--;
            }
            fps++;
            draw();
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + fps);
                System.out.println("Updates : " + updates);
                updates = 0;
                fps = 0;
            }
        }
    }

    private void draw() {
        this.environment.renderOn(this.renderer);
    }

    private void update() {
        this.environment.updateWith(this.userInputs);
    }

    private Environment initEnvironment() {
        try {
            final BufferedImage backgroundImage = ImageIO.read(new File("./res/green_background.JPG"));
            final BufferedImage spriteImage = ImageIO.read(new File("./res/sprite_sheet.png"));
            final Background background = new Background(backgroundImage);
            SpriteMotion spriteMotion = new SpriteMotion(this.gameWindow.getWidth(), this.gameWindow.getHeight(), 3);
            SpriteSheet spriteSheet = new SpriteSheet(spriteImage, 5, 4);
            final Sprite sprite = new FourDirctionalSprite(50, 50, spriteSheet, 0, 0);


            return new Environment() {
                @Override
                public void updateWith(final UserInputs map) {
                    sprite.updateWith(map);
                    InputDirection direction = InputDirection.getDirectionFrom(map);
                    spriteMotion.updatePosition(sprite, direction);
                }

                @Override
                public void renderOn(final Java2DRenderer renderer) {
                    renderer.addBackground(background)
                            .addSprite(sprite)
                            .render();
                }
            };

        } catch (final IOException e) {
            e.printStackTrace();
            return new Environment() {
                @Override
                public void updateWith(final UserInputs map) {
                    //NO-OP
                }

                @Override
                public void renderOn(final Java2DRenderer renderer) {
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
                    BossFight.this.userInputs.press(e.getKeyCode());
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                BossFight.this.userInputs.release(e.getKeyCode());
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
