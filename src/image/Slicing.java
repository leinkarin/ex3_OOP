package image;
import java.awt.*;
import java.io.IOException;

public class Slicing {
    private final int resolution;
    private final Image image;
    private Image[][] subPictures;


    public Slicing(int resolution, Image image) {
        this.resolution = resolution;
        this.image = image;
        this.subPictures = makeSubPicByRes();
    }


    //todo- check this func is working well
//    private Image[][] makeSubPicByRes(){
//        int sizeOfSubIm = image.getWidth()/resolution;
//        int subRow = resolution;
//        int subCol = image.getHeight()/sizeOfSubIm;
//        this.subPictures = new Image[subRow][subCol];
//        for (int row = 0; row < subRow; row++) {
//            for (int col = 0; col < subCol; col++) {
//                Color[][] subPixels = new Color[sizeOfSubIm][sizeOfSubIm];
//
//                for (int i = 0; i < sizeOfSubIm; i++) {
//                    for (int j = 0; j < sizeOfSubIm; j++) {
//                        int x = col * sizeOfSubIm + j;
//                        int y = row * sizeOfSubIm + i;
//                        subPixels[i][j] = image.getPixel(y, x);
//                    }
//                }
//                this.subPictures[row][col] = new Image(subPixels, sizeOfSubIm, sizeOfSubIm);
//            }
//        }
//        return this.subPictures;
//    }

    private Image[][] makeSubPicByRes() {
        int subWidth = image.getWidth() / resolution;
        int subHeight = image.getHeight() / resolution;

        System.out.println("Image Width: " + image.getWidth() + ", Image Height: " + image.getHeight());
        System.out.println("Sub-Image Width: " + subWidth + ", Sub-Image Height: " + subHeight);

        int rows = image.getHeight() / subHeight;
        int cols = image.getWidth() / subWidth;

        System.out.println("Rows: " + rows + ", Columns: " + cols);

        this.subPictures = new Image[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Color[][] subPixels = new Color[subHeight][subWidth];

                for (int i = 0; i < subHeight; i++) {
                    for (int j = 0; j < subWidth; j++) {
                        int x = col * subWidth + j;
                        int y = row * subHeight + i;
                        if (x < image.getWidth() && y < image.getHeight()) {
                            subPixels[i][j] = image.getPixel(y, x);
                        } else {
                            subPixels[i][j] = new Color(255, 255, 255); // White color for padding
                        }
                    }
                }
                this.subPictures[row][col] = new Image(subPixels, subWidth, subHeight);
            }
        }
        return this.subPictures;

    }

    public Image[][] getSubPictures() {
        return subPictures;
    }

    public static void main(String[] args) {
        try {
            // Load the image
            Image image = new Image("examples/new_dingo.png"); // Use your image path here

            // Pad the image
            Padding padding = new Padding(image);
            Image paddedImage = padding.paddingTheImage();

            // Slice the padded image
            Slicing slicing = new Slicing(8, paddedImage);
            Image[][] subImages = slicing.getSubPictures();

            // Save each sub-image
            int count = 1;
            for (int row = 0; row < subImages.length; row++) {
                for (int col = 0; col < subImages[row].length; col++) {
                    subImages[row][col].saveImage("out/sub_image_" + count);
                    System.out.println("Sub-image saved as out/sub_image_" + count + ".jpeg");
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

