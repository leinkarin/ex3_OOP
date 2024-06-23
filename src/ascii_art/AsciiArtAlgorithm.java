package ascii_art;

import image.*;
import image_char_matching.SubImgCharMatcher;


public class AsciiArtAlgorithm {
    private int resolution;
    private Image image;
    private SubImgCharMatcher imageAsciiConvertor;
    private BrightnessCalculation brightnessCalculation;


    public AsciiArtAlgorithm(int resolution,Image image, SubImgCharMatcher imageAsciiConvertor) {
        this.resolution = resolution;
        this.image = image;
        this.imageAsciiConvertor = imageAsciiConvertor;
        this.brightnessCalculation = new BrightnessCalculation(this.image);

    }


    //todo check this func works well
    public char[][] run() {

        Padding padding = new Padding(image);
        Image paddedImage = padding.paddingTheImage();
        // Slice the padded image into smaller sub-images based on the resolution
        Slicing slicing = new Slicing(resolution, paddedImage);
        Image[][] subImages = slicing.getSubPictures();
        // Initialize the ASCII art character array
        char[][] asciiArt = new char[resolution][subImages[0].length];
        // Convert each sub-image to an ASCII character
        for (int row = 0; row < resolution; row++) {
            for (int col = 0; col < subImages[row].length; col++) {
                brightnessCalculation = new BrightnessCalculation(subImages[row][col]);
                double brightness = brightnessCalculation.calculateImageBrightness();
                asciiArt[row][col] = imageAsciiConvertor.getCharByImageBrightness(brightness);
            }
        }
        return asciiArt;
    }
}
