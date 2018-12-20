import java.util.ArrayList;
/**
 * Decryption (SUPER SECRET)
 * 
 * @LM
 * @12/20/18
 */
public class Decryption
{
    private String message = "";
    private String key = "";
    private int protocol = 0;
    private String decryptedMessage = "";
    private ArrayList<Integer> spaces;
    public Decryption(String message, String key)
    {
        this.message = message;
        this.key = key;
        decryptionProtocol();
        this.spaces = new ArrayList<Integer>(message.length());
        findSpaces();
    }
    
    private void decryptionProtocol(){
        for (int i = 0; i < key.length(); i++) {
            char charOfi = key.charAt(i);
            int intOfi = (int)charOfi;
            protocol += intOfi;
        }
    }
    
    private void findSpaces(){
        for (int i = 0; i <= message.length(); i++){
            spaces.add(0);
            if (i == (message.length()-1)){
                break;
            }
            if (message.substring(i, i+1).equals(" ")) spaces.set(i, i);
        }
        spaceIndexRemovalAssistant(spaces);
        spaces.add(0,0);
    }
    
    public static ArrayList<Integer> spaceIndexRemovalAssistant(ArrayList<Integer> spaceIndexes) {
        for (int i = 0; i < spaceIndexes.size(); i++) {
            if (spaceIndexes.get(i) == 0) {
                spaceIndexes.remove(i);
                spaceIndexRemovalAssistant(spaceIndexes);
            }
        }
        return spaceIndexes;
    }
    
    public void decrypt()
    {
        int block = 0;
        
        for (int c = 0; c < spaces.size(); c++) {
            if (c == 0) {
                    block = Integer.parseInt(message.substring(0, spaces.get(1)));
                    decryptedMessage += Character.toString((char)(block/protocol)) + "";
                c++;
            }
            while (c > 0 && c != spaces.size() - 1) {
                    block = Integer.parseInt(message.substring(spaces.get(c)+1, spaces.get(c+1)));
                    decryptedMessage += Character.toString((char)(block/protocol)) + "";
                c++;
            }
            if (c == spaces.size() - 1) {
                    block = Integer.parseInt(message.substring(spaces.get(c)+1));
                    decryptedMessage += Character.toString((char)(block/protocol)) + "";
                c++;
            }
    }
    }
    
    private ArrayList<Integer> getSpaceList(){
        return spaces;
    }
    
    public String getDecryptedMessage() {
        return decryptedMessage;
    }
}
