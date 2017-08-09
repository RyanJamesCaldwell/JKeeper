package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;

import backend.EnvironmentVerifier;
import backend.LoginBackend;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 * 
 * Displays the log in window for the JKeeper Password Manager.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 9-OCT-2017
 *
 */
public class LoginWindow {

	// JFrame for displaying the login window
	private JFrame frmJkeeperPasswordManager;
	// JPasswordField for entering the user's password
	private JPasswordField pwdPasswordField;
	// Backend login processes
	private LoginBackend loginBackend;
	// Verifies the environment and dependencies
	private EnvironmentVerifier environmentVerifier;

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		this.frmJkeeperPasswordManager = new JFrame();
		this.environmentVerifier = new EnvironmentVerifier();
		
		if(this.environmentVerifier.correctOS()) {
			if(!this.environmentVerifier.hasUserProfile()){
				this.environmentVerifier.setupEnvironment();
				this.environmentVerifier.generateInitialProfile();
			}
			initialize();
			this.frmJkeeperPasswordManager.setVisible(true);
		}
		else {
			this.frmJkeeperPasswordManager.dispose();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.loginBackend = new LoginBackend();
		frmJkeeperPasswordManager.setTitle("JKeeper Password Manager");
		frmJkeeperPasswordManager.setBounds(100, 100, 398, 247);
		frmJkeeperPasswordManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJkeeperPasswordManager.getContentPane().setLayout(null);
		
		JLabel lblJkeeperV = new JLabel("JKeeper v1.0");
		lblJkeeperV.setHorizontalAlignment(SwingConstants.CENTER);
		lblJkeeperV.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblJkeeperV.setBounds(104, 32, 173, 29);
		frmJkeeperPasswordManager.getContentPane().add(lblJkeeperV);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(89, 100, 63, 14);
		frmJkeeperPasswordManager.getContentPane().add(lblPassword);
		
		pwdPasswordField = new JPasswordField();
		pwdPasswordField.setBounds(162, 98, 127, 20);
		frmJkeeperPasswordManager.getContentPane().add(pwdPasswordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(142, 154, 97, 23);
		frmJkeeperPasswordManager.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pwdPasswordField.getPassword().length == 0){
					JOptionPane.showMessageDialog(null, "Please enter your password.");
				}
				else {
					loginBackend.login(pwdPasswordField.getPassword());
				}
			}
		});
	}
}
