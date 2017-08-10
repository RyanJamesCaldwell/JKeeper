package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 10-AUG-2017
 */
public class CSVReader {
	
	// The user profile that is to be passed in 
	private File userProfile;
	// BufferedReader for retrieving information from the user account file
	private BufferedReader br;
	// CSV delimiter
	private static final String CSV_SPLIT = ",";
	
	/**
	 * Receives a CSV file and opens it to be read.
	 * 
	 * @param fileToRead - The CSV file to be read
	 */
	public CSVReader(File fileToRead) {
		//TODO Error checking - need to check if the file is indeed a CSV file
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
	
	// Opens the user profile to be read by a BufferedReader
	// @return Returns true if the file was opened without error, false otherwise
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
