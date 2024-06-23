package image;

import java.awt.*;

public class BrightnessCalculation {

    private final Image subImage;
    private final int MAX_RBG = 255;


    public BrightnessCalculation(Image subImage) {
        this.subImage = subImage;
    }


    public double greyPixelCalculation(Color color) {
        return color.getRed() * 0.2126 + color.getGreen() * 0.7152 + color.getBlue() * 0.0722;
    }

    public double calculateImageBrightness() {
        double totalBrightness = 0;
        int width = subImage.getWidth();
        int height = subImage.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = subImage.getPixel(i, j);
                totalBrightness += greyPixelCalculation(color);
            }
        }
        //todo- check you are dividing by the right number
        return totalBrightness / (width * height)/MAX_RBG;
    }




    //todo main func for checks
    //todo main func for checks
    //todo main func for checks
    //todo main func for checks
    //todo main func for checks
    public static void main(String[] args) {

    }
}
