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
		mainWindow.setResizable(false);
		mainWindow.setTitle("jKeeper Password Manager");
		mainWindow.setBounds(100, 100, 653, 347);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(183, 28, 464, 269);
		mainWindow.getContentPane().add(scrollPane);
		
		DefaultListModel listItems = new DefaultListModel();
		listItems.addElement("GMail account");
		listItems.addElement("Yahoo email");
		
		JList list = new JList(listItems);
		list.setBackground(SystemColor.text);
		scrollPane.setViewportView(list);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(37, 46, 109, 23);
		mainWindow.getContentPane().add(btnLogin);
		
		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.setBounds(37, 83, 109, 23);
		mainWindow.getContentPane().add(btnCreditCard);
		
		JButton btnComputer = new JButton("Computer");
		btnComputer.setBounds(37, 117, 109, 23);
		mainWindow.getContentPane().add(btnComputer);
		
		JLabel lblPasswordTypes = new JLabel("Categories");
		lblPasswordTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordTypes.setFont(new Font("Arial", Font.BOLD, 15));
		lblPasswordTypes.setBounds(0, 11, 183, 24);
		mainWindow.getContentPane().add(lblPasswordTypes);
		
		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItemAddEntry = new JMenuItem("Add Entry");
		mnFile.add(menuItemAddEntry);
		
		JMenuItem mntmRemoveEntry = new JMenuItem("Remove Entry");
		mnFile.add(mntmRemoveEntry);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help...");
		mnHelp.add(mntmHelp);
		
		
	}
}
