package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * 
 * Verifies the environment's information, such as finding if dependencies exist already
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 9-OCT-2017
 */
public class EnvironmentVerifier {
	
	// User's account profile
	private File userProfile;
	private File appDataFolder;
	private PrintWriter fileWriter;
	
	public EnvironmentVerifier() {
		this.appDataFolder = new File(System.getenv("APPDATA"));
		this.userProfile = new File(System.getenv("APPDATA") + "/JKeeper/UserProfile.csv");
	}
	
	public boolean hasUserProfile() {
		return this.userProfile.exists();
	}

	public boolean correctOS() {
		return this.appDataFolder.exists();
	}

	/**
	 * Creates the JKeeper folder in the APPDATA folder and creates the user's profile.
	 */
	public void setupEnvironment() {
		File JKeeperFolder;
		JKeeperFolder = new File(System.getenv("APPDATA") + "/JKeeper");
		JKeeperFolder.mkdir();
		
		try {
			this.userProfile.createNewFile();
		} catch (IOException e) {
			System.err.println("Error creating user profile.");
		}
	}

	/**
	 * Writes user's password to the user profile.
	 */
	public void generateInitialProfile() {
		try {
			this.fileWriter = new PrintWriter(this.userProfile);
			String desiredAccountName = JOptionPane.showInputDialog(null, "Please enter your desired account name: ");
			String desiredAccountPassword = JOptionPane.showInputDialog(null, "Please enter your desired account password: ");
			System.out.println(desiredAccountName + " " + desiredAccountPassword);
			this.fileWriter.append(desiredAccountName + "," + desiredAccountPassword);
			this.fileWriter.close();
		} 
		catch (FileNotFoundException e) {
			System.err.println("Error opening user profile.");
		}
	}

}
