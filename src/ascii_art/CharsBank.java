package ascii_art;

import java.util.HashSet;
import java.util.Set;

public class CharsBank {
     private Set<Character> charSet = new HashSet<>();

     public CharsBank(){
         initCharSet();
     }

     private void initCharSet(){
        // Add characters '0' to '9' to the set
        for (char ch = '0'; ch <= '9'; ch++) {
            this.charSet.add(ch);
        }
    }

    public void printCharSet(){
        for (char ch : this.charSet) {
            if (ch!=9){
                System.out.print(ch + " ");
            }
            else {
                System.out.print(ch);
            }
        }
    }

    public void add(Character c){
        this.charSet.add(c);

    }
}
