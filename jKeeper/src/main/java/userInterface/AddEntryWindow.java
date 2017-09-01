package userInterface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.EntryXMLWriter;
import entries.ComputerEntry;
import entries.CreditCardEntry;
import entries.LoginEntry;

import javax.swing.JButton;

/**
 * JFrame window for adding a new entry
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 14-AUG-2017
 */
public class AddEntryWindow extends JFrame {

	private static final long serialVersionUID = 8053793453165823745L;
	private JPanel contentPane;
	private JTextField txtEntryName;
	private JTextField txtEntryUsername;
	private JTextField txtEntryPassword;
	private JTextField txtEntryURL;
	private JTextField txtEntryEmail;
	private JTextField txtEntryCCNumber;
	private JTextField txtEntryExpiration;
	private JTextField txtEntrySecurityCode;

	/**
	 * Sets the default window options and initializes the user interface
	 */
	public AddEntryWindow() {
		defaultWindowOptions();
	}
	
	/**
	 * Sets the UI components that are common to all entry additions
	 */
	private final void defaultWindowOptions() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add New Entry");
		setBounds(100, 100, 450, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final JLabel lblSelectANew = new JLabel("Select a new entry to add");
		lblSelectANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectANew.setBounds(146, 63, 151, 14);
		contentPane.add(lblSelectANew);
		
		final JButton btnCreditCard, btnComputer, btnLogin;
		
		btnCreditCard = new JButton("Credit Card");
		btnComputer = new JButton("Computer");
		btnLogin = new JButton("Login");
		
		
		btnCreditCard.setBounds(173, 88, 98, 23);
		contentPane.add(btnCreditCard);
		btnCreditCard.addActionListener(e -> {
			btnCreditCard.setVisible(false);
			btnComputer.setVisible(false);
			btnLogin.setVisible(false);
			lblSelectANew.setVisible(false);
			showCreditCardUI("Credit Card");
		});
		
		btnComputer.setBounds(299, 88, 98, 23);
		contentPane.add(btnComputer);
		btnComputer.addActionListener(e -> {
			btnCreditCard.setVisible(false);
			btnComputer.setVisible(false);
			btnLogin.setVisible(false);
			lblSelectANew.setVisible(false);
			showSimpleUI("Computer");
		});
		
		btnLogin.setBounds(52, 88, 98, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(e -> {
			btnCreditCard.setVisible(false);
			btnComputer.setVisible(false);
			btnLogin.setVisible(false);
			lblSelectANew.setVisible(false);
			showSimpleUI("Login");
		});
		
		final JLabel lblAddNewEntry = new JLabel("Add New Entry");
		lblAddNewEntry.setFont(new Font("Arial", Font.BOLD, 20));
		lblAddNewEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewEntry.setBounds(10, 0, 424, 50);
		contentPane.add(lblAddNewEntry);
	
		centerWindow();
		setResizable(false);
		setVisible(true);
	}
	
	// Centers the window in the middle of the user's screen
	private void centerWindow(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
	
	// Shows the "simple" UI for ComputerEntrys and LoginEntrys
	private void showSimpleUI(String type) {
		setTitle("Add New Entry");
		setBounds(100, 100, 450, 458);
		centerWindow();
		
		JLabel lblEntryName = new JLabel("Entry name:");
		lblEntryName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryName.setBounds(113, 104, 73, 14);
		contentPane.add(lblEntryName);
		
		JLabel lblEntryUsername = new JLabel("Entry username:");
		lblEntryUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUsername.setBounds(91, 129, 95, 14);
		contentPane.add(lblEntryUsername);
		
		JLabel lblEntryPassword = new JLabel("Entry password:");
		lblEntryPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryPassword.setBounds(91, 154, 95, 14);
		contentPane.add(lblEntryPassword);
		
		JLabel lblEntryUrl = new JLabel("Entry URL:");
		lblEntryUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUrl.setBounds(113, 179, 73, 14);
		contentPane.add(lblEntryUrl);
		
		JLabel lblEntryEmail = new JLabel("Entry email:");
		lblEntryEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryEmail.setBounds(113, 204, 73, 14);
		contentPane.add(lblEntryEmail);
		
		txtEntryName = new JTextField();
		txtEntryName.setBounds(196, 101, 187, 20);
		contentPane.add(txtEntryName);
		txtEntryName.setColumns(10);
		
		txtEntryUsername = new JTextField();
		txtEntryUsername.setBounds(196, 126, 187, 20);
		contentPane.add(txtEntryUsername);
		txtEntryUsername.setColumns(10);
		
		txtEntryPassword = new JTextField();
		txtEntryPassword.setBounds(196, 151, 187, 20);
		contentPane.add(txtEntryPassword);
		txtEntryPassword.setColumns(10);
		
		txtEntryURL = new JTextField();
		txtEntryURL.setBounds(196, 176, 187, 20);
		contentPane.add(txtEntryURL);
		txtEntryURL.setColumns(10);
		
		txtEntryEmail = new JTextField();
		txtEntryEmail.setBounds(196, 201, 187, 20);
		contentPane.add(txtEntryEmail);
		txtEntryEmail.setColumns(10);
		
		JButton btnAddEntry = new JButton("Add Entry");
		
		if(type.equals("Login")) {
			btnAddEntry.addActionListener(e -> {
				LoginEntry loginEntry = new LoginEntry(txtEntryName.getText(), txtEntryUsername.getText(),
						txtEntryPassword.getText(), txtEntryURL.getText(), txtEntryEmail.getText());
				EntryXMLWriter.getInstance().writeLoginEntryToFile(loginEntry);
				dispose();
			});
		}
		else if(type.equals("Computer")) {
			btnAddEntry.addActionListener(e -> {
				ComputerEntry computerEntry = new ComputerEntry(txtEntryName.getText(), txtEntryUsername.getText(),
						txtEntryPassword.getText(), txtEntryURL.getText(), txtEntryEmail.getText());
				EntryXMLWriter.getInstance().writeComputerEntryToFile(computerEntry);
				dispose();
			});
		}
		
		btnAddEntry.setBounds(177, 327, 89, 23);
		contentPane.add(btnAddEntry);
	}
	
	// Shows the UI for adding a CreditCardEntry
	private void showCreditCardUI(String type) {
		setTitle("Add Credit Card Entry");
		setBounds(100, 100, 450, 458);
		centerWindow();
		
		JLabel lblEntryName = new JLabel("Entry name:");
		lblEntryName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryName.setBounds(113, 104, 73, 14);
		contentPane.add(lblEntryName);
		
		JLabel lblEntryUsername = new JLabel("Entry username:");
		lblEntryUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUsername.setBounds(91, 129, 95, 14);
		contentPane.add(lblEntryUsername);
		
		JLabel lblEntryPassword = new JLabel("Entry password:");
		lblEntryPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryPassword.setBounds(91, 154, 95, 14);
		contentPane.add(lblEntryPassword);
		
		JLabel lblEntryUrl = new JLabel("Entry URL:");
		lblEntryUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUrl.setBounds(113, 179, 73, 14);
		contentPane.add(lblEntryUrl);
		
		JLabel lblEntryEmail = new JLabel("Entry email:");
		lblEntryEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryEmail.setBounds(113, 204, 73, 14);
		contentPane.add(lblEntryEmail);
		
		JLabel lblCreditCardNumber = new JLabel("Credit card number:");
		lblCreditCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCardNumber.setBounds(64, 229, 122, 14);
		contentPane.add(lblCreditCardNumber);
		
		JLabel lblCreditCardExpiration = new JLabel("Credit card expiration:");
		lblCreditCardExpiration.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCardExpiration.setBounds(56, 254, 130, 14);
		contentPane.add(lblCreditCardExpiration);
		
		JLabel lblCreditCardSecurity = new JLabel("Credit card security code:");
		lblCreditCardSecurity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCardSecurity.setBounds(40, 279, 146, 14);
		contentPane.add(lblCreditCardSecurity);
		
		txtEntryName = new JTextField();
		txtEntryName.setBounds(196, 101, 187, 20);
		contentPane.add(txtEntryName);
		txtEntryName.setColumns(10);
		
		txtEntryUsername = new JTextField();
		txtEntryUsername.setBounds(196, 126, 187, 20);
		contentPane.add(txtEntryUsername);
		txtEntryUsername.setColumns(10);
		
		txtEntryPassword = new JTextField();
		txtEntryPassword.setBounds(196, 151, 187, 20);
		contentPane.add(txtEntryPassword);
		txtEntryPassword.setColumns(10);
		
		txtEntryURL = new JTextField();
		txtEntryURL.setBounds(196, 176, 187, 20);
		contentPane.add(txtEntryURL);
		txtEntryURL.setColumns(10);
		
		txtEntryEmail = new JTextField();
		txtEntryEmail.setBounds(196, 201, 187, 20);
		contentPane.add(txtEntryEmail);
		txtEntryEmail.setColumns(10);
		
		txtEntryCCNumber = new JTextField();
		txtEntryCCNumber.setBounds(196, 226, 187, 20);
		contentPane.add(txtEntryCCNumber);
		txtEntryCCNumber.setColumns(10);
		
		txtEntryExpiration = new JTextField();
		txtEntryExpiration.setBounds(196, 251, 187, 20);
		contentPane.add(txtEntryExpiration);
		txtEntryExpiration.setColumns(10);
		
		txtEntrySecurityCode = new JTextField();
		txtEntrySecurityCode.setBounds(196, 276, 187, 20);
		contentPane.add(txtEntrySecurityCode);
		txtEntrySecurityCode.setColumns(10);
		
		// Create a new CreditCardEntry and write it to the userData.xml file
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(e -> {
			CreditCardEntry cce = new CreditCardEntry(txtEntryName.getText(), txtEntryUsername.getText(),
					txtEntryPassword.getText(), txtEntryURL.getText(), txtEntryEmail.getText(),
					txtEntryCCNumber.getText(), txtEntryExpiration.getText(), 
					txtEntrySecurityCode.getText());
			EntryXMLWriter.getInstance().writeCreditCardEntryToFile(cce);
			dispose();
		});
		btnAddEntry.setBounds(177, 327, 89, 23);
		contentPane.add(btnAddEntry);
	}
}
