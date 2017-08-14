package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entries.BasicEntry;

/**
 * Class is used for writing new entries to the userData.xml file
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 14-AUG-2017
 */
public class EntryXMLWriter {
	private BasicEntry entryToAppend;
	private PrintWriter pw;
	private File userFile;
	
	/**
	 * Takes a BasicEntry as a parameter to write to the userData.xml file
	 * 
	 * @param newEntry Any BasicEntry to write to the userData.xml file
	 */
	public EntryXMLWriter(BasicEntry newEntry) {
		userFile = new File(System.getenv("APPDATA") + "/jKeeper/userData.xml");
		try {
			pw = new PrintWriter(userFile);
		} catch (FileNotFoundException e) {
			System.err.println("Error: Error opening userData.xml file with PrintWriter.");
		}
		this.entryToAppend = newEntry;
	}
	
	/**
	 * Will write the credit card entry to the userData.xml file
	 */
	public void writeCreditCardEntryToFile() {
		//  		HOW THE XML WILL BE STRUCTURED
		//<entry type="Credit Card">
		//		<name>Example Entry Name</name>
		//		<username>ExampleUsername</username>
		//		<password>ExamplePa$$w0rd</password>
		//		<URL>http://example-url.com</URL>
		//		<email>exampleEmail@example.com</email>
		//		<ccNumber>1234-1234-1234-1234</ccNumber>
		//		<expiration>9/99</expiration>
		//		<securityCode>123</securityCode>
		//</entry>
	}
	
	
}
