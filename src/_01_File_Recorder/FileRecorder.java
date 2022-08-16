package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public void run() {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/message.txt");
			fw.write(JOptionPane.showInputDialog("What do you want your message to be?"));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
