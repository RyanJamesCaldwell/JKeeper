package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entries.BasicEntry;
import entries.ComputerEntry;
import entries.CreditCardEntry;
import entries.LoginEntry;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * Class is a JFrame object that displays information for the various types of entries that can be made by the user.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 14-AUG-2017
 */
public class ViewEntryWindow extends JFrame {

	private static final long serialVersionUID = 4948005554005458345L;
	// Content pane to be added to 
	private JPanel contentPane;
	// Entry that is to be viewed in the JFrame window
	private BasicEntry entryToView;
	// Class that the entry is, helps determine which setup call to use
	private Class<?> entryType;
	
	/**
	 * Various UI elements 
	 */
	private JLabel lblUsername;
	private JTextField txtEntryUsername;
	private JLabel lblEntryPassword;
	private JTextField txtEntryPassword;
	private JLabel lblEntryUrl;
	private JTextField txtEntryURL;
	private JLabel lblEntryEmail;
	private JTextField txtEntryEmail;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtURL;
	private JTextField txtEmail;
	private JTextField txtCCNumber;
	private JTextField txtExpirationDate;
	private JTextField txtSecurityNumber;
	

	/**
	 * Create the frame, determines how the UI is set up (which entry is being viewed), and displays to user
	 */
	public ViewEntryWindow(BasicEntry entryToView) {
		this.entryToView = entryToView;
		this.entryType = entryToView.getClass();
		getContentPane().setLayout(null);
		setResizable(false);
		setupInitialUI();
		determineUIType();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
	
	/**
	 * Sets up UI aspects that are common to all entries
	 */
	private void setupInitialUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Determines the type of UI that needs to be initialized based on the entry type
	 */
	private void determineUIType() {
		
		if(this.entryType == LoginEntry.class) {
			initializeUIForLogin();
		}
		else if(this.entryType == CreditCardEntry.class) {
			initializeUIForCreditCard();
		}
		else if(this.entryType == ComputerEntry.class) {
			initializeUIForComputer();
		}
	}

	/**
	 * Initializes the UI components for viewing a ComputerEntry
	 */
	private void initializeUIForComputer() {
		setBounds(100, 100, 450, 300);
		setTitle("View Computer Entry");
		JLabel lblEntryName = new JLabel("");
		lblEntryName.setFont(new Font("Arial", Font.BOLD, 20));
		lblEntryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntryName.setBounds(10, 11, 414, 49);
		contentPane.add(lblEntryName);
		lblEntryName.setText(this.entryToView.getEntryName());
		
		lblUsername = new JLabel("Entry Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(66, 88, 98, 19);
		contentPane.add(lblUsername);
		
		txtEntryUsername = new JTextField();
		txtEntryUsername.setEditable(false);
		txtEntryUsername.setBounds(169, 88, 210, 20);
		contentPane.add(txtEntryUsername);
		txtEntryUsername.setColumns(10);
		txtEntryUsername.setText(this.entryToView.getEntryUsername());
		
		lblEntryPassword = new JLabel("Entry Password:");
		lblEntryPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryPassword.setBounds(66, 117, 98, 19);
		contentPane.add(lblEntryPassword);
		
		txtEntryPassword = new JTextField();
		txtEntryPassword.setEditable(false);
		txtEntryPassword.setBounds(169, 117, 210, 20);
		contentPane.add(txtEntryPassword);
		txtEntryPassword.setColumns(10);
		txtEntryPassword.setText(this.entryToView.getEntryPassword());
		
		lblEntryUrl = new JLabel("Entry URL:");
		lblEntryUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUrl.setBounds(94, 147, 70, 19);
		contentPane.add(lblEntryUrl);
		
		txtEntryURL = new JTextField();
		txtEntryURL.setEditable(false);
		txtEntryURL.setBounds(169, 146, 210, 20);
		contentPane.add(txtEntryURL);
		txtEntryURL.setColumns(10);
		txtEntryURL.setText(this.entryToView.getEntryURL());
		
		lblEntryEmail = new JLabel("Entry Email:");
		lblEntryEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryEmail.setBounds(89, 177, 75, 14);
		contentPane.add(lblEntryEmail);
		
		txtEntryEmail = new JTextField();
		txtEntryEmail.setEditable(false);
		txtEntryEmail.setBounds(169, 174, 210, 20);
		contentPane.add(txtEntryEmail);
		txtEntryEmail.setColumns(10);
		setVisible(true);
		txtEntryEmail.setText(this.entryToView.getEntryEmail());
	}

	/**
	 * Initializes the UI components for viewing a CreditCardEntry
	 */
	private void initializeUIForCreditCard() {
		setBounds(100, 100, 450, 300);
		setTitle("View Credit Card Entry");
		setVisible(true);
		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(10, 11, 414, 50);
		contentPane.add(lblTitle);
		lblTitle.setText(this.entryToView.getEntryName());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEntryUsername = new JLabel("Entry Username:");
		lblEntryUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUsername.setBounds(68, 100, 112, 14);
		contentPane.add(lblEntryUsername);
		
		JLabel lblEntryPassword_1 = new JLabel("Entry Password:");
		lblEntryPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryPassword_1.setBounds(78, 125, 102, 14);
		contentPane.add(lblEntryPassword_1);
		
		JLabel lblEntryUrl_1 = new JLabel("Entry URL:");
		lblEntryUrl_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUrl_1.setBounds(95, 149, 85, 14);
		contentPane.add(lblEntryUrl_1);
		
		JLabel lblEntryEmail_1 = new JLabel("Entry Email:");
		lblEntryEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryEmail_1.setBounds(105, 174, 75, 14);
		contentPane.add(lblEntryEmail_1);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number:");
		lblCreditCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCardNumber.setBounds(51, 199, 129, 14);
		contentPane.add(lblCreditCardNumber);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		lblExpirationDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpirationDate.setBounds(62, 224, 118, 14);
		contentPane.add(lblExpirationDate);
		
		JLabel lblSecurityNumber = new JLabel("Security Number:");
		lblSecurityNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecurityNumber.setBounds(62, 249, 118, 14);
		contentPane.add(lblSecurityNumber);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setBounds(190, 97, 180, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setText(this.entryToView.getEntryUsername());
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setBounds(190, 122, 180, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		txtPassword.setText(this.entryToView.getEntryPassword());
		
		txtURL = new JTextField();
		txtURL.setEditable(false);
		txtURL.setBounds(190, 146, 180, 20);
		contentPane.add(txtURL);
		txtURL.setColumns(10);
		txtURL.setText(this.entryToView.getEntryURL());
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(190, 171, 180, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(this.entryToView.getEntryEmail());
		
		txtCCNumber = new JTextField();
		txtCCNumber.setEditable(false);
		txtCCNumber.setBounds(190, 196, 180, 20);
		contentPane.add(txtCCNumber);
		txtCCNumber.setColumns(10);
		txtCCNumber.setText("");
		txtCCNumber.setText(((CreditCardEntry) this.entryToView).getCreditCardNumber());
		
		txtExpirationDate = new JTextField();
		txtExpirationDate.setEditable(false);
		txtExpirationDate.setBounds(190, 221, 180, 20);
		contentPane.add(txtExpirationDate);
		txtExpirationDate.setColumns(10);
		txtExpirationDate.setText(((CreditCardEntry)this.entryToView).getExpiration());
		
		txtSecurityNumber = new JTextField();
		txtSecurityNumber.setEditable(false);
		txtSecurityNumber.setBounds(190, 246, 180, 20);
		contentPane.add(txtSecurityNumber);
		txtSecurityNumber.setColumns(10);
		setBounds(100, 100, 450, 359);
		txtSecurityNumber.setText(((CreditCardEntry)this.entryToView).getSecurityCode());
	}

	/**
	 * Initializes the UI components for viewing a LoginEntry
	 */
	private void initializeUIForLogin() {
		setBounds(100, 100, 450, 300);
		setTitle("View Login Entry");
		JLabel lblEntryName = new JLabel("");
		lblEntryName.setFont(new Font("Arial", Font.BOLD, 20));
		lblEntryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntryName.setBounds(10, 11, 414, 49);
		contentPane.add(lblEntryName);
		lblEntryName.setText(this.entryToView.getEntryName());
		
		lblUsername = new JLabel("Entry Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(66, 88, 98, 19);
		contentPane.add(lblUsername);
		
		txtEntryUsername = new JTextField();
		txtEntryUsername.setEditable(false);
		txtEntryUsername.setBounds(169, 88, 210, 20);
		contentPane.add(txtEntryUsername);
		txtEntryUsername.setColumns(10);
		txtEntryUsername.setText(this.entryToView.getEntryUsername());
		
		lblEntryPassword = new JLabel("Entry Password:");
		lblEntryPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryPassword.setBounds(66, 117, 98, 19);
		contentPane.add(lblEntryPassword);
		
		txtEntryPassword = new JTextField();
		txtEntryPassword.setEditable(false);
		txtEntryPassword.setBounds(169, 117, 210, 20);
		contentPane.add(txtEntryPassword);
		txtEntryPassword.setColumns(10);
		txtEntryPassword.setText(this.entryToView.getEntryPassword());
		
		lblEntryUrl = new JLabel("Entry URL:");
		lblEntryUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryUrl.setBounds(94, 147, 70, 19);
		contentPane.add(lblEntryUrl);
		
		txtEntryURL = new JTextField();
		txtEntryURL.setEditable(false);
		txtEntryURL.setBounds(169, 146, 210, 20);
		contentPane.add(txtEntryURL);
		txtEntryURL.setColumns(10);
		txtEntryURL.setText(this.entryToView.getEntryURL());
		
		lblEntryEmail = new JLabel("Entry Email:");
		lblEntryEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntryEmail.setBounds(89, 177, 75, 14);
		contentPane.add(lblEntryEmail);
		
		txtEntryEmail = new JTextField();
		txtEntryEmail.setEditable(false);
		txtEntryEmail.setBounds(169, 174, 210, 20);
		contentPane.add(txtEntryEmail);
		txtEntryEmail.setColumns(10);
		setVisible(true);
		txtEntryEmail.setText(this.entryToView.getEntryEmail());
	}
}