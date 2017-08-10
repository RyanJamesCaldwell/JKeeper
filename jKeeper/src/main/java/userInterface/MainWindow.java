package userInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * The main window that the user interacts with after logging in successfully.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 10-AUG-2017
 */
public class MainWindow {

	// The JFrame that is shown
	private JFrame mainWindow;

	/**
	 * Initializes the user interface and sets the visibility of the window to "true"
	 */
	public MainWindow() {
		initialize();
		this.mainWindow.setVisible(true);
	}

	// Generates the needed user interface
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setTitle("jKeeper Password Manager");
		mainWindow.setBounds(100, 100, 450, 300);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItemAddEntry = new JMenuItem("Add Entry");
		mnFile.add(menuItemAddEntry);
		
	}
}
