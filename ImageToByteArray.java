
/**
 * Recommend 
 * This program will convert image to byte array 
 * and print that array in terminal 
 * after that, this program will create a new picture in the same file extension from byte array 
 * 
 * How to use?
 * 1.Put your image address in the pathOfPic variable.
 * 2.Enter a name for the new image that will be born by this program in the newName variable.
 */
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String args[]) throws Exception {
        String pathOfPic = "C:\\Users\\thirawat\\Desktop\\BMP-HW\\BMP\\1.bmp";
        String newName = "createdFormProgram";

        // convert image to byte array
        String fileExtension = pathOfPic.substring(pathOfPic.length() - 3);
        File myPic = new File(pathOfPic);
        BufferedImage buffImage = ImageIO.read(myPic);
        ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
        ImageIO.write(buffImage, fileExtension, byteOS);
        byte[] data = byteOS.toByteArray();

        // print that array from you picture
        System.out.println(Arrays.toString(data));

        // create a new picture
        ByteArrayInputStream byteIS = new ByteArrayInputStream(data);
        BufferedImage buffImage2 = ImageIO.read(byteIS);
        ImageIO.write(buffImage2, fileExtension, new File(newName + "." + fileExtension));
        // System.out.println("image created");
    }
}