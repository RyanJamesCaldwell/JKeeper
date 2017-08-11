package entries;

/**
 * This class extends the BasicEntry class and serves as a container for
 * all entries that are of the "Login" type.
 *
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 */
public class LoginEntry extends BasicEntry {
	
	/**
	 * Sets the values of the attributes to an empty string
	 */
	public LoginEntry() {
		this.setDefaults();
	}
	
	/**
	 * Sets the values of the LoginEntry's attributes
	 * 
	 * @param entryName The name of the entry
	 * @param entryUsername The username of the entry
	 * @param entryPassword The password of the entry
	 * @param entryURL The URL of the entry
	 * @param entryEmail The email address of the entry
	 */
	public LoginEntry(String entryName, String entryUsername, String entryPassword, String entryURL, String entryEmail) {
		this.setEntryName(entryName);
		this.setEntryUsername(entryUsername);
		this.setEntryPassword(entryPassword);
		this.setEntryURL(entryURL);
		this.setEntryEmail(entryEmail);
	}

	/**
	 * @return Returns "Login"
	 */
	public String getEntryType() {
		return "Login";
	}
}
