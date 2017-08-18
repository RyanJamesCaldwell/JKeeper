package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	private XMLEntryReader xmlReader;
	
	/**
	 * Checks if the user's data file exists. If it doesn't, creates it
	 */
	public MainWindowBackend() {
		this.userDataFile = new File(System.getenv("APPDATA") + "/jKeeper/userData.xml");
		if(!userDataFileExists()) {
			createNewUserDataFile();
		}
		
		this.xmlReader = new XMLEntryReader(this.userDataFile);
	}
	
	/**
	 * Creates a new user data file with the root element
	 */
	private void createNewUserDataFile() {
		try {
			this.userDataFile.createNewFile();
			
			Document dom;
		    Element e = null;
		    
		    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        dom = db.newDocument();
		        FileOutputStream fos;
		        Element rootElement = dom.createElement("root");
		        Element entries = dom.createElement("entries");
		        dom.appendChild(rootElement);
		        rootElement.appendChild(entries);
		        
		        try {
		            Transformer tr = TransformerFactory.newInstance().newTransformer();
		            tr.setOutputProperty(OutputKeys.INDENT, "yes");
		            tr.setOutputProperty(OutputKeys.METHOD, "xml");
		            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		            fos = new FileOutputStream(this.userDataFile);
		            // send DOM to file
		            tr.transform(new DOMSource(dom), 
		                                 new StreamResult(fos));
		            fos.close();
		        } catch (TransformerException te) {
		            System.err.println(te.getMessage());
		        } catch (IOException ioe) {
		            System.err.println(ioe.getMessage());
		        }
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	 * Type 0: "Login". Type 1: "Computer". Type 2: "Credit Card".
	 * @return Returns an ArrayList of 
	 */
	public ArrayList<BasicEntry> getEntriesByType(int type) {
		// TODO read the file, get entries of a type, return arraylist of that type
		ArrayList<BasicEntry> listOfEntries;
		
		switch(type){
		case 0:
			this.xmlReader.getEntriesByType(0);
			break;
		case 1:
			this.xmlReader.getEntriesByType(1);
			break;
		case 2:
			this.xmlReader.getEntriesByType(2);
			break;
		case 3:
			
			break;
		default:
			break;
		}
		this.entriesCurrentlyDisplayed = this.xmlReader.getCurrentEntries();
		
		return this.xmlReader.getCurrentEntries();
	}
	
	public ArrayList<BasicEntry> getEntriesCurrentlyDisplayed() {
		return this.entriesCurrentlyDisplayed;
	}

}
