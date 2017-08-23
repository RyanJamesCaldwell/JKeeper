package entries;

/**
 * This class acts as the base class for all entries
 * in the jKeeper program, whether it be "Computer",
 * "Credit Card", "Login", or otherwise.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 */
public abstract class BasicEntry implements Entry {

	// Name given to the entry by the user
	private String entryName;
	// User's login username
	private String entryUsername;
	// User's login password
	private String entryPassword;
	// Link to the site
	private String entryURL;
	// User's email
	private String entryEmail;
	
	
	// Sets all of the attributes' values to empty strings
	public void setDefaults() {
		this.entryName = "";
		this.entryUsername = "";
		this.entryPassword = "";
		this.entryURL = "";
		this.entryEmail = "";
	}
	
	/**
	 * @return Returns the name of the entry
	 */
	public String getEntryName() {
		return this.entryName;
	}
	
	/**
	 * User needs to implement this abstract method, returning the type of entry
	 */
	public abstract String getEntryType();
	
	/**
	 * Sets the value of the entry's name
	 * 
	 * @param newEntryName The new name of the entry
	 */
	public void setEntryName(String newEntryName) {
		this.entryName = newEntryName;
	}
	
	/**
	 * @return Returns the entry's name
	 */
	public String getEntryUsername() {
		return this.entryUsername;
	}
	
	/**
	 * Sets the value of the entry's username
	 * 
	 * @param newEntryUsername The new username of the entry
	 */
	public void setEntryUsername(String newEntryUsername) {
		this.entryUsername = newEntryUsername;
	}
	
	/**
	 * @return Returns the entry's password
	 */
	public String getEntryPassword() {
		return this.entryPassword;
	}
	
	/**
	 * Sets the value of the entry's password
	 * 
	 * @param newEntryPassword The new password of the entry
	 */
	public void setEntryPassword(String newEntryPassword) {
		this.entryPassword = newEntryPassword;
	}
	
	/**
	 * @return Returns the entry's URL
	 */
	public String getEntryURL() {
		return this.entryURL;
	}
	
	/**
	 * Sets the value of the entry's URL
	 * 
	 * @param newEntryURL The new URL of the entry
	 */
	public void setEntryURL(String newEntryURL) {
		this.entryURL = newEntryURL;
	}

	/**
	 * @return Returns the entry's email address
	 */
	public String getEntryEmail() {
		return entryEmail;
	}

	/**
	 * Sets the value of the entry's email address
	 * 
	 * @param entryEmail The new email address of the entry
	 */
	public void setEntryEmail(String entryEmail) {
		this.entryEmail = entryEmail;
	}
}
