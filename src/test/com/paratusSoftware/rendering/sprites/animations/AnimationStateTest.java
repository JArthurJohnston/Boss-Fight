package com.paratusSoftware.rendering.sprites.animations;

import com.paratusSoftware.rendering.sprites.FourDirctionalSprite;
import com.paratusSoftware.rendering.sprites.Sprite;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AnimationStateTest {

    static BufferedImage image;
    static Sprite sprite;


    static {
        try {
            image = ImageIO.read(new File("./res/sprite_sheet.jpg"));
//            sprite = new FourDirctionalSprite()
        } catch (final IOException e) {
            fail("couldn't load test image");
        }
    }


    @Test
    public void testUpdateState() throws Exception {
//        new AnimationState()
    }

}