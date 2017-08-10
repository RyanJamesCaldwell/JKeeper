package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	private File userProfile;
	private BufferedReader br;
	private static final String CSV_SPLIT = ",";
	
	public CSVReader(File fileToRead) {
		this.userProfile = fileToRead;
		openUserProfile();
	}

	/**
	 * Returns the user's password from their user profile.
	 * 
	 * @return Returns null if there was an error reading from the user profile, returns
	 * the user's password otherwise.
	 */
	public String getAccountPassword() {
		String line = null;
		String[] splitAccountLine;
		String password = null;
		
		try {
			line = br.readLine();
			splitAccountLine = line.split(CSV_SPLIT);
			password = splitAccountLine[1];
		} catch (IOException e) {
			System.err.println("Error reading from user profile.");
		}
		
		return password;
	}
	
	/**
	 * Opens the user profile to be read by a BufferedReader.
	 * 
	 * @return Returns true if the file was opened without error, false otherwise.
	 */
	private boolean openUserProfile() {
		boolean successfullyOpened = false;
		
		try {
			br = new BufferedReader(new FileReader(userProfile));
			successfullyOpened = true;
		} catch (FileNotFoundException e) {
			successfullyOpened = false;
			System.err.println("Error opening user profile.");
		}
		
		return successfullyOpened;
	}
	
	/**
	 * Close the user profile that was previously opened by a BufferedReader.
	 * 
	 * @return Returns true if successfully closed, false otherwise.
	 */
	public boolean closeUserProfile() {
		boolean successfullyClosed = false;
		
		try {
			br.close();
			successfullyClosed = true;
		} catch (IOException e) {
			System.err.println("Error closing user profile.");
			successfullyClosed = false;
		}
		
		return successfullyClosed;
	}
}
