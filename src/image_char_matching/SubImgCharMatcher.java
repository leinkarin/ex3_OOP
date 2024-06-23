package image_char_matching;

import ascii_output.AsciiOutput;
import ascii_output.HtmlAsciiOutput;
import image.Image;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//todo- if we add more public func we need to explain in the README file

public class SubImgCharMatcher {


    char[] charSet;
    private HashMap<Character, Double> brightnessMap;


    /**
     *  ///todo- might be wrong;
     * @param charset
     */
    public SubImgCharMatcher(char[] charset){
        this.charSet = charset;
        this.brightnessMap = new HashMap<>();
        for (char c : this.charSet){
            this.brightnessMap.put(c, calculateBrightnessLevels(c));
        }
//        linearStretch();



    }


    //todo- this func gets a value of brightness and return the right char from the charSet in the class
    public char getCharByImageBrightness(double brightness){

        return 'g';
    }

    //todo- this func add c to the chrSet
    public void addChar(char c){
        char[] newCharSet = new char[charSet.length+1];
        System.arraycopy(charSet, 0, newCharSet, 0, charSet.length);
        newCharSet[charSet.length] = c;
        this.charSet = newCharSet;

    }

    //todo- this func remove c from the charSet
    public void removeChar(char c){
        //todo- add an exception if the char is not found
        char[] newCharSet = new char[charSet.length-1];
        int index = 0;
        for (char value : charSet) {
            if (value == c) {
                continue;
            }
            newCharSet[index] = value;
            index++;
        }
        this.charSet = newCharSet;
    }



    /**
     * step 1 + 2;
     * @param theCar
     * @return
     */
    private double calculateBrightnessLevels(char theCar) {
        boolean[][] charAsMatrix = CharConverter.convertToBoolArray(theCar);
        double whitePixels = 0;
        for (boolean[] row : charAsMatrix) {
            for (boolean pixel : row){
                if (pixel) {
                    whitePixels++;
                }
            }
        }
        return whitePixels / (charAsMatrix.length*charAsMatrix[0].length);
    }


    /**step 3
     *
     * @param
     * @return
     */
    private void linearStretch() {
        double minBrightness = Double.MAX_VALUE;
        double maxBrightness = Double.MIN_VALUE;

        for (char brightness : brightnessMap.keySet()) {
            if (brightnessMap.get(brightness) < minBrightness) {
                minBrightness = brightnessMap.get(brightness);
            }
            if (brightnessMap.get(brightness) > maxBrightness) {
                maxBrightness = brightnessMap.get(brightness);
            }
        }
        for (char key : brightnessMap.keySet()) {
            double newBrightness = (brightnessMap.get(key) - minBrightness) / (maxBrightness - minBrightness);
            brightnessMap.replace(key, newBrightness);
        }
    }




    public static void main(String[] args) {

        char[] charSet = {'m', 'o'};
        char[] charSet2 = {'A', 'B', 'C', 'D'};
        SubImgCharMatcher macher = new SubImgCharMatcher(charSet2);
        for ( char key : macher.brightnessMap.keySet()){
            System.out.println(macher.brightnessMap.get(key));
        }
        macher.linearStretch();
        for ( char key : macher.brightnessMap.keySet()){
            System.out.println(macher.brightnessMap.get(key));
        }

    }








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
