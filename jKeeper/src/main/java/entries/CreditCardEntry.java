package entries;

/**
 * This class extends the BasicEntry class and serves as a container for
 * all entries that are of the "Credit Card" type.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 */
public class CreditCardEntry extends BasicEntry {
	
	// User's credit card number
	private String creditCardNumber;
	// Expiration date of the user's credit card
	private String expiration;
	// Security code of the user's credit card
	private String securityCode;
	
	/**
	 * Sets the values of the attributes of a CreditCardEntry to an empty string
	 */
	public CreditCardEntry() {
		this.setDefaults();
		this.creditCardNumber = "";
		this.expiration = "";
		this.securityCode = "";
	}
	
	/**
	 * Sets the values of the attributes of a CreditCardEntry
	 * 
	 * @param entryName The name of the new CreditCardEntry
	 * @param entryUsername The username of the CreditCardEntry
	 * @param entryPassword The password of the CreditCardEntry 
	 * @param entryURL The URL of the CreditCardEntry
	 * @param entryEmail The email of the CreditCardEntry
	 * @param ccNumber The credit card number of the CreditCardEntry
	 * @param expiration The expiration date of the CreditCardEntry
	 * @param securityCode The security code of the CreditCardEntry
	 */
	public CreditCardEntry(String entryName, String entryUsername, String entryPassword, String entryURL, String entryEmail, String ccNumber, String expiration, String securityCode) {
		this.setEntryName(entryName);
		this.setEntryUsername(entryUsername);
		this.setEntryPassword(entryPassword);
		this.setEntryURL(entryURL);
		this.setEntryEmail(entryEmail);
		this.setCreditCardNumber(ccNumber);
		this.setExpiration(expiration);
		this.setSecurityCode(securityCode);
	}
	
	/**
	 * @return Returns "Credit Card"
	 */
	public String getEntryType() {
		return "Credit Card";
	}

	/**
	 * @return Returns the entry's credit card number
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	
	/**
	 * Sets the value of the entry's credit card number
	 * 
	 * @param creditCardNumber The new credit card number of the entry
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * @return Returns the expiration of the entry's credit card
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * Sets the value of the entry's credit card expiration
	 * 
	 * @param expiration The new expiration of the entry
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
	/**
	 * @return Returns the security code of the entry's credit card
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * Sets the value of the entry's credit card security code
	 * 
	 * @param securityCode The new security code of the entry
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
}