// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;

class ImageResizer
{
    public static int MAX_WIDTH;
    public static int MAX_HEIGHT;
    
    static {
        ImageResizer.MAX_WIDTH = 220;
        ImageResizer.MAX_HEIGHT = 160;
    }
    
    public static void copyImage(final String filePath, final String copyPath) {
        BufferedImage bimage = loadImage(filePath);
        if (bimage.getHeight() > bimage.getWidth()) {
            final int heigt = bimage.getHeight() * ImageResizer.MAX_WIDTH / bimage.getWidth();
            bimage = resize(bimage, ImageResizer.MAX_WIDTH, heigt);
            final int width = bimage.getWidth() * ImageResizer.MAX_HEIGHT / bimage.getHeight();
            bimage = resize(bimage, width, ImageResizer.MAX_HEIGHT);
        }
        else {
            final int width2 = bimage.getWidth() * ImageResizer.MAX_HEIGHT / bimage.getHeight();
            bimage = resize(bimage, width2, ImageResizer.MAX_HEIGHT);
            final int heigt2 = bimage.getHeight() * ImageResizer.MAX_WIDTH / bimage.getWidth();
            bimage = resize(bimage, ImageResizer.MAX_WIDTH, heigt2);
        }
        saveImage(bimage, copyPath);
    }
    
    public static BufferedImage loadImage(final String pathName) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(new File(pathName));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
    
    public static void saveImage(final BufferedImage bufferedImage, final String pathName) {
        try {
            final String format = pathName.endsWith(".png") ? "png" : "jpg";
            final File file = new File(pathName);
            file.getParentFile().mkdirs();
            ImageIO.write(bufferedImage, format, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static BufferedImage resize(final BufferedImage bufferedImage, final int newW, final int newH) {
        final int w = bufferedImage.getWidth();
        final int h = bufferedImage.getHeight();
        final BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        final Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
}
