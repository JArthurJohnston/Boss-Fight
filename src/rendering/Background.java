package rendering;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {

    private final BufferedImage image;

    public Background(final BufferedImage image) {
        this.image = image;
    }

    Image getCurrentFrame() {
        return this.image.getSubimage(0, 0, this.image.getWidth(), this.image.getHeight());
    }
}
