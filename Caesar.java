import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Caesar {
    private final List<String> alphabet = new ArrayList<>(Arrays.asList(
    "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i",
        "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r",
        "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z", " ", ",", 
        ".", "?", "!", ";", ":", "(", ")", "{", "}", "[", "]", "/", "@", "#", "$", "%", "^", "&", 
        "*", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    ));
    
    public void input() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(Const.GREEN_COLOR + "\nWrite a message:" + Const.RESET_COLOR);
            String message = input.nextLine();

            System.out.println(Const.GREEN_COLOR + "Generate a key (Yes/No)?" + Const.RESET_COLOR);
            String result = input.nextLine();

            int key;

            try {
                if (!result.equalsIgnoreCase("Yes")) {
                    System.out.println(Const.GREEN_COLOR + "Write a key:" + Const.RESET_COLOR);
                    key = Integer.parseInt(input.nextLine());
                } else {
                    key = GenerateKey();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid key input. Please enter a valid number.");
                return;
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                return;
            }

            System.out.println(Const.RED_COLOR + "\nResult:\n" + Const.GREEN_COLOR + encryption(message, key) + Const.RESET_COLOR);

            input.nextLine();
            System.out.println("--------------------");

            input();
        }
    }

    private int GenerateKey() {
        Random random = new Random();

        int privateKey = random.nextInt(Integer.MAX_VALUE);
        int publicKey = -privateKey;

        System.out.println(Const.RED_COLOR + "   --Keys--   " + Const.RESET_COLOR);
        System.out.println(Const.GREEN_COLOR + "Private key: " + Const.RED_COLOR + privateKey);
        System.out.println(Const.GREEN_COLOR + "Public key: " + Const.RED_COLOR + publicKey + Const.RESET_COLOR);

        return privateKey;
    }

    private String encryption(String text, int key) {
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