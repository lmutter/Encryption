import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
/**
 * UI for Encryption business. Main Class.
 * 
 * @LM
 * @12/20/18
 */
public class UIPanel extends JFrame
{
    JPanel p = new JPanel();
    
    JLabel keyTitle = new JLabel("Key");
    JLabel messageTitle = new JLabel("Message");
    
    JTextField keyField = new JTextField(30);
    JTextArea messageField = new JTextArea(15, 60);
    
    JButton encryptButton = new JButton("Encrypt");
    JButton decryptButton = new JButton("Decrypt");
    
    JTextArea outputField = new JTextArea(15, 60);
    
    JButton generateKeyButton = new JButton("Generate Key");
    JTextField lengthField = new JTextField(2);
    JLabel inLength = new JLabel("characters in length:");
    JTextArea generatedKey = new JTextArea(1, 20);
    
    public UIPanel()
    {
        setTitle("Encryption / Decryption Tool");
        setVisible(true);
        setSize(750,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        messageField.setLineWrap(true);
        outputField.setLineWrap(true);
        
        p.add(keyTitle);
        p.add(keyField);
        p.add(messageTitle);
        p.add(messageField);
            
        p.add(encryptButton);
        p.add(decryptButton);
        
        encryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            String key = keyField.getText();
            String message = messageField.getText();
            
            Encryption encryption = new Encryption(message, key);
            encryption.encrypt();
            outputField.setText(encryption.getEncryptedMessage());
        }
        });
        
        
        decryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            String key = keyField.getText();
            String message = messageField.getText();
            
            Decryption decryption = new Decryption(message, key);
            decryption.decrypt();
            outputField.setText(decryption.getDecryptedMessage());
        }
        });
        
        p.add(outputField);
        
        p.add(generateKeyButton);
        p.add(lengthField);
        p.add(inLength);
        p.add(generatedKey);
        
        generateKeyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
            String length = lengthField.getText();
            generatedKey.setText((new Keygen(Integer.parseInt(length))).toString());
        }
        });
        add(p);
    }

    public static void main(String[] args)
       {
             UIPanel t = new UIPanel();
       }
}
