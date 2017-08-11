package userInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import backend.MainWindowBackend;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.PopupMenu;

import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import java.awt.TextField;

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
	// The back end operations of the main window
	private MainWindowBackend mainWindowBackend;
	private DefaultListModel itemList;

	/**
	 * Initializes the user interface and sets the visibility of the window to "true"
	 */
	public MainWindow() {
		initialize();
		this.mainWindowBackend = new MainWindowBackend();
		//TODO get all entries in file returns ArrayList<String> allEntries
		//populateItemList(ArrayList<String> allEntries)
		this.mainWindow.setVisible(true);
	}

	// Generates the needed user interface
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setResizable(false);
		mainWindow.setTitle("jKeeper Password Manager");
		mainWindow.setBounds(100, 100, 653, 347);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(193, 11, 433, 243);
		mainWindow.getContentPane().add(scrollPane);
		
		itemList = new DefaultListModel();
		
		JList list = new JList(itemList);
		list.setBackground(SystemColor.text);
		scrollPane.setViewportView(list);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(44, 46, 109, 23);
		mainWindow.getContentPane().add(btnLogin);
		
		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.setBounds(44, 83, 109, 23);
		mainWindow.getContentPane().add(btnCreditCard);
		
		JButton btnComputer = new JButton("Computer");
		btnComputer.setBounds(44, 117, 109, 23);
		mainWindow.getContentPane().add(btnComputer);
		
		JLabel lblPasswordTypes = new JLabel("Categories");
		lblPasswordTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordTypes.setFont(new Font("Arial", Font.BOLD, 15));
		lblPasswordTypes.setBounds(54, 11, 89, 24);
		mainWindow.getContentPane().add(lblPasswordTypes);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.setBounds(193, 263, 123, 23);
		mainWindow.getContentPane().add(btnAddEntry);
		
		JButton btnEditEntry = new JButton("Edit Entry");
		btnEditEntry.setBounds(351, 263, 123, 23);
		mainWindow.getContentPane().add(btnEditEntry);
		
		JButton btnRemoveEntry = new JButton("Remove Entry");
		btnRemoveEntry.setBounds(503, 263, 123, 23);
		mainWindow.getContentPane().add(btnRemoveEntry);
		
		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItemAddEntry = new JMenuItem("Add Entry");
		mnFile.add(menuItemAddEntry);
		
		JMenuItem mntmEditEntry = new JMenuItem("Edit Entry");
		mnFile.add(mntmEditEntry);
		
		JMenuItem mntmRemoveEntry = new JMenuItem("Remove Entry");
		mnFile.add(mntmRemoveEntry);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help...");
		mnHelp.add(mntmHelp);
	}
	
	// This will read a file and populate the list of existing items
	// @params type The type you want to populate
	private void populateItemList(String type) {
		ArrayList<String> itemsToPopulate;
		itemsToPopulate = new ArrayList<String>();
		
		itemsToPopulate = this.mainWindowBackend.getEntriesByType(type);
		
		for(int i = 0; i < itemsToPopulate.size(); i++) {
			this.itemList.addElement(itemsToPopulate.get(i));
		}
	}
}
