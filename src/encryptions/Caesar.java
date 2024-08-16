package encryptions;

import interfaces.IEncryption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import myLib.Const;

public class Caesar implements IEncryption {
    private final List<String> alphabet = new ArrayList<>(Arrays.asList(
    "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i",
        "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r",
        "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z", " ", ",", 
        ".", "?", "!", ";", ":", "(", ")", "{", "}", "[", "]", "/", "@", "#", "$", "%", "^", "&", 
        "*", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    ));
    
    @Override
    public void main() {
        System.out.println("------------------------------------------------------------");
        Const.writeLogo("logo/caesar.txt");
        input();
    }

    @Override
    public void input() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(Const.GREEN_COLOR + "\nWrite a message:" + Const.RESET_COLOR);
            String message = input.nextLine();

            System.out.println(Const.GREEN_COLOR + "Write a key (if you don't have a key, press enter):" + Const.RESET_COLOR);

            int key;
            try {
                key = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                key = generateKey();
            }
            

            System.out.println(Const.RED_COLOR + "\nResult:\n" + Const.GREEN_COLOR + encryption(message, key) + Const.RESET_COLOR);

            input.nextLine();
            System.out.println("--------------------");

            input();
        }
    }

    @Override
    public int generateKey() {
        Random random = new Random();

        int privateKey = random.nextInt(Integer.MAX_VALUE);
        int publicKey = -privateKey;

        System.out.println(Const.RED_COLOR + "   --Keys--   " + Const.RESET_COLOR);
        System.out.println(Const.GREEN_COLOR + "Private key: " + Const.RED_COLOR + privateKey);
        System.out.println(Const.GREEN_COLOR + "Public key: " + Const.RED_COLOR + publicKey + Const.RESET_COLOR);

        return privateKey;
    }

    @Override
    public String encryption(String text, int key) {
        StringBuilder encryption = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            String character = String.valueOf(text.charAt(i));
            int indexOfElement = alphabet.indexOf(character);

            if (indexOfElement != -1) {
                int newIndex = (indexOfElement + key) % alphabet.size();

                if (newIndex < 0)
                    newIndex += alphabet.size();

                encryption.append(alphabet.get(newIndex));
            } else
                encryption.append(character);
        }

        return encryption.toString();
    }
}