import java.util.Scanner;
import java.io.IOException;
import java.util.*; 
import java.lang.*; 
/**
 * UI for all that encryption business
 * 
 * @LM 
 * @12/20/18
 */
public class EncryptionUI 
{
    static int keyLength = 0;
    static String response = "";
    static String key;
    static Scanner in = new Scanner(System.in);
    static String newMessage = "";
    static String messageToEncrypt = "";
    static String messageToDecrypt = "";
    
    public static void main(String[] args) throws IOException {
        
        
        System.out.println("\nGenerate key or enter key manually? (g for generate, e for enter)");
        response = in.nextLine();
        
        if (response.equals("g")) {
            generator();
        }
        
        else if (response.equals("e")) {
            System.out.println("Custom key:");
            key = in.nextLine();
        }
        
        else {System.out.println("Not a valid response, try again"); System.exit(0);}
        
        System.out.println("Your key is " + key);
        System.out.println("\nEncrypt or Decrypt a message? (e for encrypt, d for decrypt)");
        response = in.nextLine();
        
        if (response.equals("e")) {
            encrypt();
        }
        
        else if (response.equals("d")) {
           decrypt();
        }
        
        else {System.out.println("Not a valid response, try again"); System.exit(0);}
        
    }
    
    
    private static void generator(){
        System.out.println("How long to make key? (50 characters max)");
        keyLength = (int)Double.parseDouble(in.nextLine());
            if (keyLength > 0 && keyLength < 51){
            key = (new Keygen(keyLength)).toString();
        }
        else {
                System.out.println("Please try again.");
                generator();
        }
        System.out.println("Generating " + keyLength + " characters:");
    }
    
    private static void encrypt(){
        System.out.println("Message to encrypt: ");
        messageToEncrypt = in.nextLine();
        Encryption encryption = new Encryption(messageToEncrypt, key);
        encryption.encrypt();
        System.out.println("Encrypted message: " + encryption.getEncryptedMessage());
    }
    
    private static void decrypt(){
        System.out.println("Message to decrypt: ");
        messageToDecrypt = in.nextLine();
        Decryption decryption = new Decryption(messageToDecrypt, key);
        decryption.decrypt();
        System.out.println("Decrypted message: " + decryption.getDecryptedMessage());
    }
    
}
