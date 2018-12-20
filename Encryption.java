
/**
 * Encryption (SUPER SECRET)
 * 
 * @LM
 * @12/20/18
 */
public class Encryption
{
    private String message = "";
    private String key = "";
    private int protocol = 0;
    private String encryptedMessage = "";
    public Encryption(String message, String key)
    {
        this.message = message;
        this.key = key;
        encryptionProtocol();
    }

    public void encrypt()
    {
        for (int i = 0; i < message.length(); i++){
            encryptedMessage += protocol*(int)(message.charAt(i));
            if (i==message.length() - 1){
                break;
            }
            encryptedMessage += " ";
        }  
    }
    
    private void encryptionProtocol(){
        for (int i = 0; i < key.length(); i++) {
            char charOfi = key.charAt(i);
            int intOfi = (int)charOfi;
            protocol += intOfi;
        }
    }
    
    public String getEncryptedMessage() {
        return encryptedMessage;
    }
}
