
/**
 * Generates a key to ENCRYPT and/or DECRYPT somethin
 * 
 * @LM 
 * @12/20/18
 */
public class Keygen
{
    private int length;
    
    public Keygen(int length)
    {
        this.length = length;
    }

    public String toString()
    {
        String rand = "";
        for(int i = 0; i < length; i++) {
            int randSymb = (int)(Math.random()*93 + 36);
            char characterIndex = (char)randSymb;
            rand = rand + characterIndex;
        }
        return rand;
    }
}
