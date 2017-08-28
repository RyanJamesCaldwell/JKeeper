package entries;

/**
 * This class extends the BasicEntry class and serves as a container for
 * all entries that are of the "Computer" type.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 */
public class ComputerEntry extends BasicEntry {
	
	/**
	 * Sets the values of the attributes of a ComputerEntry to an empty string
	 */
	public ComputerEntry() {
		this.setDefaults();
	}
	
	/**
	 * Sets the values of the attributes of a ComputerEntry
	 * 
	 * @param entryName The name of the new ComputerEntry
	 * @param entryUsername The username of the ComputerEntry
	 * @param entryPassword The password of the ComputerEntry 
	 * @param entryURL The URL of the ComputerEntry
	 * @param entryEmail The email of the ComputerEntry
	 */
	public ComputerEntry(String entryName, String entryUsername, String entryPassword, String entryURL, String entryEmail) {
		this.setEntryName(entryName);
		this.setEntryUsername(entryUsername);
		this.setEntryPassword(entryPassword);
		this.setEntryURL(entryURL);
		this.setEntryEmail(entryEmail);
	}
	
	/**
	 * @return Returns "Computer"
	 */
	public String getEntryType() {
		return "Computer";
	}
}
