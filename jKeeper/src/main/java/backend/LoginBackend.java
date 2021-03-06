package backend;

import java.io.File;

/**
 * The back end logic that is attached to LoginWindow.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 10-AUG-2017
 */
public class LoginBackend {
	
	// The user's profile that is to be read
	private File userProfile;
	
	/**
	 * Instantiates the user profile File.
	 */
	public LoginBackend() {
		this.userProfile = new File(System.getenv("APPDATA") + "/jKeeper/userProfile.csv");
	}
	
	/**
	 * Verifies if the login password was correct
	 * 
	 * @param attemptedPassword - The password entered by the user in the login window.
	 * @return Returns true if the password entered equals the user's account password, false otherwise.
	 */
	public final boolean login(char[] attemptedPassword) {
		String attemptedPasswordString = new String(attemptedPassword);
		return attemptedPasswordString.equals(readLoginPassword());
	}

	// Returns the user's password from their user profile.
	//
	// @return Returns null if there was an error reading from the user profile, returns
	// the user's password otherwise.
	private final String readLoginPassword() {
		String password = null;
		
		CSVReader readUserProfile = new CSVReader(this.userProfile);
		password = readUserProfile.getAccountPassword();
		readUserProfile.closeUserProfile();
		
		return password;
	}
}
