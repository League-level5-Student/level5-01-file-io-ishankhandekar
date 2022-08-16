package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	public void main() {
		ArrayList <String> tasks = new ArrayList<String>();
		ArrayList <String> names = new ArrayList<String>();
		JFrame frame = new JFrame("To Do List");
		JPanel panel = new JPanel();
		JButton addTask = new JButton("Add a task");
		JButton viewTasks = new JButton("View tasks");
		JButton removeTask = new JButton("Remove tasks");
		JButton saveList = new JButton("Save the list");
		JButton loadList = new JButton("Load a new list");
		
		try {
			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			fw.write("");
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addTask.addActionListener(e -> {tasks.add(JOptionPane.showInputDialog("What task do you want to add?"));});
		
		
		viewTasks.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, tasks);
			});
		
		
		removeTask.addActionListener(e -> 
		{tasks.remove(JOptionPane.showOptionDialog(null, "What task do you want to remove"
				, "To do list",  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tasks.toArray(), 0));});
		
		
		saveList.addActionListener(e -> {String fileName = JOptionPane.showInputDialog("What do you want the todo list to be named");
		names.add(fileName);
			try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/" + fileName + ".txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			String whatToWrite = "";
			for (int i = 0; i < tasks.size(); i++) {
				whatToWrite += (tasks.get(i) + "\n");
			}
			fw.write(whatToWrite);
				
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		});
		
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
