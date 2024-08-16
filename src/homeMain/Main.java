package homeMain;

import encryptions.Caesar;
import interfaces.IEncryption;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import myLib.Const;

public class Main {
    private static HashMap<String, IEncryption> encryptions = new HashMap<>();

    public static void main(String[] args) {
        addEncryptions();
        Const.writeLogo("logo/sapEncryption.txt");

        Scanner input = new Scanner(System.in);

        System.out.println(Const.RED_COLOR + "Choose the encryption:" + Const.GREEN_COLOR);
        displayHashMap(encryptions);
        
        try {
            System.out.println(Const.RESET_COLOR);
            encryptions.get(input.nextLine()).main();
        } catch (Exception e) {
            System.out.println(Const.RED_COLOR + "Non found..." + Const.RESET_COLOR);
        }
    }

    private static void displayHashMap(HashMap<String, IEncryption> hashMap) {
        Set<String> keys = hashMap.keySet();

        int i = 0;
        for (String key : keys){
            i++;
            System.out.println(i + ". " + key);
        }
    }

    private static void addEncryptions() {
        encryptions.put("Caesar", new Caesar());
    }
}