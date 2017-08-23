package entries;

/**
 * The Entry interface serves as a building block for the various types
 * of entries that are present in the jKeeper Password Manager application.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 */
interface Entry {
	public String getEntryName();
	
	public void setEntryName(String newEntryName);
	
	public String getEntryUsername();
	
	public void setEntryUsername(String newEntryUsername);
	
	public String getEntryPassword();
	
	public void setEntryPassword(String newEntryPassword);
	
	public String getEntryURL();
	
	public void setEntryURL(String newEntryURL);
	
	public String getEntryType();
	
	public String getEntryEmail();
	
	public void setEntryEmail(String newEntryEmail);
}
