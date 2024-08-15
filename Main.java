import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeLogo();
        new Caesar().input();
    }

    private static void writeLogo() {
        String logoPath = "C:/Users/MR-Kotuk/IdeaProjects/SAP Encryption/text/logo.txt";
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