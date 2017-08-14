package backend;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import entries.BasicEntry;
import entries.ComputerEntry;
import entries.CreditCardEntry;
import entries.LoginEntry;

/**
 * The back end logic that is attached to MainWindow
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 14-AUG-2017
 */
public class MainWindowBackend {
	
	// The file where the user's entry data is kept
	private File userDataFile;
	// The entries that are displayed on the main window
	private ArrayList<BasicEntry> entriesCurrentlyDisplayed;
	
	/**
	 * Checks if the user's data file exists. If it doesn't, creates it
	 */
	public MainWindowBackend() {
		this.userDataFile = new File(System.getenv("APPDATA") + "/jKeeper/userData.xml");
		
		if(!userDataFileExists()) {
			createNewUserDataFile();
		}
	}
	
	/**
	 * Creates a new user data file
	 */
	private void createNewUserDataFile() {
		try {
			this.userDataFile.createNewFile();
			PrintWriter pw = new PrintWriter(new File(this.userDataFile.toString()));
			pw.append("<entries>");
			pw.append("</entries>");
			pw.close();
		} catch (IOException e) {
			System.err.println("Error: Could not create user data file.");
		}
	}

	/**
	 * Returns if the users data file already exists
	 * 
	 * @return Returns true if file exists, false if it does not
	 */
	public boolean userDataFileExists() {
		return this.userDataFile.exists();
	}

	/**
	 * Returns an ArrayList of user entries of a given type
	 * 
	 * @param type Different types that the user can retrieve from the user data file. 
	 * Type 1: "Login". Type 2: "Computer". Type 3: "Credit Card".
	 * @return Returns an ArrayList of 
	 */
	public ArrayList<BasicEntry> getEntriesByType(int type) {
		// TODO read the file, get entries of a type, return arraylist of that type
		ArrayList<BasicEntry> hi = new ArrayList<BasicEntry>();
		switch(type){
		case 0:
			hi.add(new LoginEntry("Facebook Login", "myUsername", "Pa$$w0rd", "http://facebook.com", "myEmail@facebook.com"));
			hi.add(new LoginEntry("Twitter Login", "@twitter_user", "Pa$$w0rd", "http://twitter.com", "myEmail@twitter.com"));
			hi.add(new LoginEntry("Gmail Login", "myUsername", "Pa$$w0rd", "http://gmail.com", "myEmail@gmail.com"));
			this.entriesCurrentlyDisplayed = hi;
			System.out.println(this.entriesCurrentlyDisplayed.size() + " items being displayed");
			break;
		case 1:
			hi.add(new ComputerEntry("Work computer login", "workUsername", "workPa$$w0rd", "", "workEmail@work.com"));
			this.entriesCurrentlyDisplayed = hi;
			System.out.println(this.entriesCurrentlyDisplayed.size() + " items being displayed");
			break;
		case 2:
			hi.add(new CreditCardEntry("Discover credit card", "loginUsername", "login password", "URL", "login email", "1234-1234-1234-1234", "1/19", "123"));
			this.entriesCurrentlyDisplayed = hi;
			System.out.println(this.entriesCurrentlyDisplayed.size() + " items being displayed");
			break;
		case 3:
			this.entriesCurrentlyDisplayed = hi;
			System.out.println(this.entriesCurrentlyDisplayed.size() + " items being displayed");
			break;
		default:
			break;
		}
		
		return hi;
	}
	
	public ArrayList<BasicEntry> getEntriesCurrentlyDisplayed() {
		return this.entriesCurrentlyDisplayed;
	}

}
