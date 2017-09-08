import rendering.Background;
import rendering.Java2DRenderer;
import rendering.Renderable;
import rendering.Sprite;

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
    private final Renderable environment;

    private BossFight() {
        this.gameWindow = initFrame();
        this.renderer = new Java2DRenderer(this.gameWindow);
        this.environment = initEnvironment();
    }

    private void loop() {
        while (true) {
            draw();
        }
    }

    private void draw() {
        this.environment.renderOn(this.renderer);
    }

    private Renderable initEnvironment() {
        try {
            final BufferedImage backgroundImage = ImageIO.read(new File("./res/green_background.JPG"));
            final BufferedImage spriteImage = ImageIO.read(new File("./res/black mage.png"));
            final Background background = new Background(backgroundImage);
            final Sprite sprite = new Sprite(spriteImage, 50, 50);

            return renderer -> {
                renderer.addBackground(background)
                        .addSprite(sprite)
                        .render();
            };
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
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

                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
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
