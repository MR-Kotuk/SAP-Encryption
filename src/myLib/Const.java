package myLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Const {
    public static final String RESET_COLOR = "\033[0m";

    public static String RED_COLOR = "\033[0;31m";
    public static String GREEN_COLOR = "\033[0;32m";

    public static void writeLogo(String logoPath) {
        File logoFile = new File(logoPath);

        if (!logoFile.exists()) {
            System.out.println("Cannot find the logo with path: " + logoPath);
            return;
        }

        System.out.println(Const.RED_COLOR);

        try (Scanner logoReader = new Scanner(logoFile)) {
            while (logoReader.hasNextLine()) {
                System.out.println(logoReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the logo with path: " + logoPath);
        }

        System.out.println(Const.RESET_COLOR);
    }
}