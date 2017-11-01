package com.paratusSoftware.rendering.sprites;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BasicSpriteTest {

    static BufferedImage image;

    @BeforeAll
    public static void setupClass() {
        try {
            image = ImageIO.read(new File("./res/sprite_sheet.jpg"));
        } catch (final IOException e) {
            fail("couldn't load image");
        }
    }

    @Test
    public void testConstruction() throws Exception {
        final BasicSprite basicSprite = new BasicSprite();
    }


}