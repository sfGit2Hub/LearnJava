package image;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Locale;

/**
 * Created by SF on 2017/12/18.
 */
public class CompressUntil {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://d3p91sdhs2uwtu.cloudfront.net/44DA7D8A1EF74FFEBA36E0269F23AACE/2df08d9a-65d4-4176-931b-28e36c4bfac3.jpg");
        BufferedImage bi = ImageIO.read(url);
//        BufferedImage bi = ImageIO.read(new File("C:\\Users\\DT287\\Pictures\\2df08d9a-65d4-4176-931b-28e36c4bfac3.jpg"));
        for (float q = 0.2f; q < .9f; q += .2f) {
            OutputStream outStream = new FileOutputStream(new File("E:/log/Image-" + q + ".jpg"));
            ImageWriter imgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
            ImageOutputStream ioStream = ImageIO.createImageOutputStream(outStream);
            imgWriter.setOutput(ioStream);

            JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(
                    Locale.getDefault());
            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(q);

            imgWriter.write(null, new IIOImage(bi, null, null), jpegParams);

            ioStream.flush();
            ioStream.close();
            imgWriter.dispose();
        }
    }
}
