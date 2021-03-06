package userInterface;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import backend.MainWindowBackend;
import entries.BasicEntry;
import entries.ComputerEntry;
import entries.CreditCardEntry;
import entries.LoginEntry;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.JSeparator;

/**
 * 
 * The main window that the user interacts with after logging in successfully.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 14-AUG-2017
 */
public class MainWindow {

	// The JFrame that is shown
	private JFrame mainWindow;
	// The back end operations of the main window
	private MainWindowBackend mainWindowBackend;
	// The item list where the names of user entries will be held
	private DefaultListModel<String> itemList;
	// Used for searching entry type "login"
	private static final int ENTRY_TYPE_LOGIN = 0;
	// Used for searching entry type "computer"
	private static final int ENTRY_TYPE_COMPUTER = 1;
	// Used for searching entry type "credit card"
	private static final int ENTRY_TYPE_CREDIT_CARD = 2;
	// Used for retrieving all entry types
	private static final int ENTRY_TYPE_ALL = 3;

	/**
	 * Initializes the user interface and sets the visibility of the window to "true"
	 */
	public MainWindow() {
		initialize();
		this.mainWindowBackend = new MainWindowBackend();
		this.mainWindow.setVisible(true);
		
		this.populateItemList(ENTRY_TYPE_ALL);
	}

	// Generates the needed user interface
	private final void initialize() {
		mainWindow = new JFrame();
		mainWindow.setResizable(false);
		mainWindow.setTitle("jKeeper Password Manager");
		mainWindow.setBounds(100, 100, 653, 375);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		// Center the JFrame on the user's screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainWindow.setLocation(dim.width/2-mainWindow.getSize().width/2, dim.height/2-mainWindow.getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(193, 11, 433, 247);
		mainWindow.getContentPane().add(scrollPane);
		
		itemList = new DefaultListModel<String>();
		
		final JList<String> list = new JList<String>(itemList);
		list.setBackground(SystemColor.text);
		scrollPane.setViewportView(list);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(44, 46, 109, 23);
		mainWindow.getContentPane().add(btnLogin);
		btnLogin.addActionListener(e -> {
			populateItemList(ENTRY_TYPE_LOGIN);
		});
		
		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.setBounds(44, 83, 109, 23);
		mainWindow.getContentPane().add(btnCreditCard);
		btnCreditCard.addActionListener(e -> {
			populateItemList(ENTRY_TYPE_CREDIT_CARD);
		});
		
		JButton btnComputer = new JButton("Computer");
		btnComputer.setBounds(44, 117, 109, 23);
		mainWindow.getContentPane().add(btnComputer);
		btnComputer.addActionListener(e -> {
			populateItemList(ENTRY_TYPE_COMPUTER);
		});
		
		JLabel lblPasswordTypes = new JLabel("Categories");
		lblPasswordTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordTypes.setFont(new Font("Arial", Font.BOLD, 15));
		lblPasswordTypes.setBounds(54, 11, 89, 24);
		mainWindow.getContentPane().add(lblPasswordTypes);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.setBounds(186, 291, 123, 23);
		mainWindow.getContentPane().add(btnAddEntry);
		btnAddEntry.addActionListener(e -> {
			new AddEntryWindow();
		});
		
		JButton btnEditEntry = new JButton("Edit Entry");
		btnEditEntry.setBounds(345, 291, 123, 23);
		mainWindow.getContentPane().add(btnEditEntry);
		
		JButton btnRemoveEntry = new JButton("Remove Entry");
		btnRemoveEntry.setBounds(503, 291, 123, 23);
		mainWindow.getContentPane().add(btnRemoveEntry);
		btnRemoveEntry.addActionListener(e -> {
			if(list.getSelectedValue() != null) {
				mainWindowBackend.removeEntry(list.getSelectedValue());
			}
		});
		
		JButton btnViewEntry = new JButton("View Entry");
		btnViewEntry.setBounds(30, 291, 123, 23);
		mainWindow.getContentPane().add(btnViewEntry);
		btnViewEntry.addActionListener(e -> {
			int arrayIndex = list.getSelectedIndex();
			if(arrayIndex != -1){
				BasicEntry elementToView = mainWindowBackend.getEntriesCurrentlyDisplayed().get(arrayIndex);
				Class<?> classType = elementToView.getClass();
				
				// Create new ViewEntryWindow
				if(classType == LoginEntry.class) {
					LoginEntry viewLoginEntryElement = (LoginEntry) elementToView;
					new ViewEntryWindow<LoginEntry>(viewLoginEntryElement);
				}
				else if(classType == ComputerEntry.class) {
					ComputerEntry viewComputerEntryElement = (ComputerEntry) elementToView;
					new ViewEntryWindow<ComputerEntry>(viewComputerEntryElement);
				}
				else if(classType == CreditCardEntry.class) {
					CreditCardEntry viewCreditCardEntryElement = (CreditCardEntry) elementToView;
					new ViewEntryWindow<CreditCardEntry>(viewCreditCardEntryElement);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 275, 627, 5);
		mainWindow.getContentPane().add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItemAddEntry = new JMenuItem("Add Entry");
		mnFile.add(menuItemAddEntry);
		menuItemAddEntry.addActionListener(e -> {
			new AddEntryWindow();
		});
		
		JMenuItem mntmEditEntry = new JMenuItem("Edit Entry");
		mnFile.add(mntmEditEntry);
		
		JMenuItem mntmRemoveEntry = new JMenuItem("Remove Entry");
		mnFile.add(mntmRemoveEntry);
		mntmRemoveEntry.addActionListener(e -> {
			if(list.getSelectedValue() != null) {
				mainWindowBackend.removeEntry(list.getSelectedValue());
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help...");
		mnHelp.add(mntmHelp);
		mntmHelp.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "To add an entry, click the 'Add Entry' button"
					+ " and enter the relevant information.\nTo edit an existing entry, select"
					+ " the entry that is in the main window, and click the 'Edit Entry' button."
					+ "\nTo remove an entry, select the entry that you want to remove and click"
					+ " the 'Remove Entry' button.");
		});
	}
	
	// This will read a file and populate the list of existing items
	// @params type The type you want to populate
	// Type 0: "Login". Type 1: "Computer". Type 2: "Credit Card". Type 3: All entries. 
	private final void populateItemList(int type) {
		this.itemList.clear();
		
		ArrayList<BasicEntry> itemsToPopulate;
		itemsToPopulate = new ArrayList<BasicEntry>();
		
		itemsToPopulate = this.mainWindowBackend.getEntriesByType(type);
		
		for(int i = 0; i < itemsToPopulate.size(); i++) {
			this.itemList.addElement(itemsToPopulate.get(i).getEntryName());
		}
	}
}