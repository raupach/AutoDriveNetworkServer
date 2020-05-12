package de.autoDrive.NetworkServer.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageHelper {

    private static Logger LOG = LoggerFactory.getLogger(ImageHelper.class);

    public static BufferedImage loadImage(String path) {
        try {
            URL url = ImageHelper.class.getResource(path);
            return ImageIO.read(url);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
}
