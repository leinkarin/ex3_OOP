package image_char_matching;

import ascii_output.AsciiOutput;
import ascii_output.HtmlAsciiOutput;
import image.Image;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;

public class SubImgCharMatcher {


    char[] charSet;

    public SubImgCharMatcher(char[] charset){

        ///todo- might be wrong;
        this.charSet = new char[charset.length];
        for(int i = 0; i<charset.length; i++){
            this.charSet[i] = charset[i];
        }
    }


    //todo- this func gets a value of brightness and return the right char from the charSet in the class
    public char getCharByImageBrightness(double brightness){
        return 'g';
    }

    //todo- this func add c to the chrSet
    public void addChar(char c){

    }

    //todo- this func remove c from thecharSet
    public void removeChar(char c){}

    //todo- if we add more public funcs we need to explain in the README file



//
//
//package ascii_art.img_to_char;
//
//import ascii_output.AsciiOutput;
//import ascii_output.HtmlAsciiOutput;
//import image.Image;
//
//import java.awt.*;
//import java.util.Arrays;
//import java.util.Iterator;
//
//    public class BrightnessImgCharMatcher {
//
//
//
//        public char[][] chooseChars(Image img, int numCharsInRow, Character[] charSet) {
//            int pixels = img.getWidth() / numCharsInRow;
//            double[] brightnessLevels = linearStretch(calculateBrightnessLevels(charSet));
//            char[][] asciiArt = new char[img.getHeight() / pixels][img.getWidth() / pixels];
//
//            Iterator<Image> subImages = img.squareSubImagesOfSize(pixels).iterator();
//            for (int row = 0; row < asciiArt.length; row++) {
//                for (int col = 0; col < asciiArt[row].length; col++) {
//                    Image subImage = subImages.next();
//                    double avgBrightness = calculateImageBrightness(subImage);
//                    asciiArt[row][col] = matchBrightness(avgBrightness, brightnessLevels, charSet);
//                }
//            }
//            return asciiArt;
//        }
//
//
//        /////////my implementation//////
//        private double[] calculateBrightnessLevels(Character[] charSet) {
//            double[] brightnessLevels = new double[charSet.length];
//            for (int i = 0; i < charSet.length; i++) {
//                boolean[][] img = CharRenderer.getImg(charSet[i], 16, "Arial");
//                int whitePixels = 0;
//                int totalPixels = img.length * img[0].length;
//                for (boolean[] row : img) {
//                    for (boolean pixel : row) {
//                        if (pixel) {
//                            whitePixels++;
//                        }
//                    }
//                }
//                brightnessLevels[i] = (double) whitePixels / totalPixels;
//            }
//            return brightnessLevels;
//        }
//
//
//        private double[] linearStretch(double[] brightnessLevels) {
//            double minBrightness = Double.MAX_VALUE;
//            double maxBrightness = Double.MIN_VALUE;
//
//            for (double brightness : brightnessLevels) {
//                if (brightness < minBrightness) {
//                    minBrightness = brightness;
//                }
//                if (brightness > maxBrightness) {
//                    maxBrightness = brightness;
//                }
//            }
//            double[] stretchedLevels = new double[brightnessLevels.length];
//            for (int i = 0; i < brightnessLevels.length; i++) {
//                stretchedLevels[i] = (brightnessLevels[i] - minBrightness) / (maxBrightness - minBrightness);
//            }
//            return stretchedLevels;
//        }
//
//
//        public double calculateImageBrightness(Image image) {
//            int sumBrightness = 0;
//            int count = 0;
//            for (Color pixel : image.pixels()) {
//                int brightness = (int) (0.3 * pixel.getRed() + 0.59 * pixel.getGreen() + 0.11 * pixel.getBlue());
//                sumBrightness += brightness;
//                count++;
//            }
//            return (double) sumBrightness / count;
//        }
//
//        // שיטה למציאת התו המתאים לפי רמת הבהירות
//        private char matchBrightness(double avgBrightness, double[] brightnessLevels, Character[] charSet) {
//            double closestDiff = Double.MAX_VALUE;
//            char bestChar = charSet[0];
//            for (int i = 0; i < brightnessLevels.length; i++) {
//                double diff = Math.abs(brightnessLevels[i] - avgBrightness);
//                if (diff < closestDiff) {
//                    closestDiff = diff;
//                    bestChar = charSet[i];
//                }
//            }
//            return bestChar;
//        }
//
//
//
//
//        public static void main(String[] args) {
//            Image img = Image.fromFile("board.jpeg");
//            Character[] charSet = {'m', 'o'};
//            BrightnessImgCharMatcher charMatcher = new BrightnessImgCharMatcher();
//            AsciiOutput asciiOutput = new HtmlAsciiOutput("output.html", "Arial");
//            char[][] chars = charMatcher.chooseChars(img, 2, charSet);
//            asciiOutput.output(chars);
//            // Print to console for verification
//            System.out.println(Arrays.deepToString(chars));
//        }
//    }
}
