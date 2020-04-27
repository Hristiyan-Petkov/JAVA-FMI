package cipher;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class RouteCipherTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Choose an option: 1.Encrypt, 2.Decrypt ");
        int option = scanner.nextInt();
        RouteCipher a = new RouteCipher(4);

        switch (option){
            case 1:
                System.out.println("Please enter message to encrypt! ");
                String plainText= scanner1.nextLine();
                System.out.println(a.encrypt(plainText));
                break;
            case 2:
                System.out.println("Please enter message to decrypt! ");
                String cipherText= scanner1.nextLine();
                System.out.println(a.decrypt(cipherText));
                break;
        }
    }
}
