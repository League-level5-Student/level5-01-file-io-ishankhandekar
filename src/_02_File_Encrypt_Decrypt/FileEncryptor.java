package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public void main() {
		String input;
        String message = "";
        do {
            input = JOptionPane.showInputDialog("Enter a message to be encripted(letters)");
            if (input.matches("^[a-zA-Z\\s+]*$")) {
                message = input;
                
            } else {
            	 JOptionPane.showMessageDialog(null, "Please enter letters");
            }
        } while (!input.matches("^[a-zA-Z\\s+]*$"));
		
        
        
		String input2;
        String key = "";
        do {
            input2 = JOptionPane.showInputDialog("Enter the key (number) ");
            if (input2.matches("^[0-9]*$")) {
                key = input2;
               
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number");
            }
        } while (!input2.matches("^[0-9]*$"));
        
        try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptedMessage.txt");
			fw.write(cipher(message,Integer.parseInt(key)));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	static String cipher(String msg, int shift){
	    String s = "";
	    int len = msg.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(msg.charAt(x) + shift);
	        if (c > 'z')
	            s += (char)(msg.charAt(x) - (26-shift));
	        else
	            s += (char)(msg.charAt(x) + shift);
	    }
	    return s;
	}
}
