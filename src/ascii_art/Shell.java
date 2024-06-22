package ascii_art;

//todo- this code is right from the getting ready code!
//todo- this code is right from the getting ready code!
//todo- this code is right from the getting ready code!
//todo- this code is right from the getting ready code!
//todo- this code is right from the getting ready code!




// in ex6 its:
//import ascii_art.img_to_char.BrightnessImgCharMatcher;
//now in the new folder its:
import ascii_art.AsciiArtAlgorithm;
//

import ascii_output.HtmlAsciiOutput;
import image.Image;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Shell {

    private CharsBank charBank;


    public Shell(){
        this.charBank = new CharsBank();

    }


    public void run(){
         // ask for input
         System.out.print(">>> ");
         String input = KeyboardInput.readLine();
         // ask for input until exit
         while (!input.equals("exit")){
             if(input.startsWith("chars ") || input.equals("chars")){
                this.charBank.printCharSet();
             }

             else if (input.startsWith("add ")){
                 addCharToBank(input);
             }

             System.out.print("\n>>> ");
             input = KeyboardInput.readLine();
         }
         System.exit(0); // exit the program
    }

    private void addCharToBank(String input){
         String command = input.substring(4).trim();

        if (command.equals("all")) {
            for (char c = 32; c <= 126; c++) {
                charBank.add(c);
            }
        } else if (command.equals("space")) {
            charBank.add(' ');
        } else if (command.length() == 1) {
            char c = command.charAt(0);
            if (c >= 32 && c <= 126) {
                charBank.add(c);
            } else {
                System.out.println("Did not add due to incorrect format.");
            }
        } else if (command.length() == 3 && command.charAt(1) == '-') {
            char start = command.charAt(0);
            char end = command.charAt(2);

            if (start > end) {
                char temp = start;
                start = end;
                end = temp;
            }

            if (start >= 32 && start <= 126 && end >= 32 && end <= 126) {
                for (char c = start; c <= end; c++) {
                    charBank.add(c);
                }
            } else {
                System.out.println("Did not add due to incorrect format.");
            }
        } else {
            System.out.println("Did not add due to incorrect format.");
        }
    }
     public static void main(String[] args) {
       Shell shell = new Shell();
         shell.run();
    }


}
//    private Set<Character> charSet = new HashSet<>();
//    private static final String CMD_EXIT = "exit";
//    private final Image img;
//
//    public Shell(Image img) {
//        this.img = img;
//    }
//
//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(">>> ");
//        String cmd = scanner.next().trim();
//        while(!cmd.toLowerCase().equals(CMD_EXIT)) {
//            var param = scanner.nextLine().trim();
//            System.out.print(">>> ");
//            cmd = scanner.next();
//        }
//        Character[] charSet = {'a', 'b', 'c', 'd'};
//        BrightnessImgCharMatcher charMatcher = new BrightnessImgCharMatcher();
//        char[][] chars = charMatcher.chooseChars(img,4, charSet);
//        HtmlAsciiOutput asciiOutput = new HtmlAsciiOutput("output.html", "Ariel");
//        asciiOutput.output(chars);
//        System.out.println(Arrays.deepToString(chars));
//    }
//

