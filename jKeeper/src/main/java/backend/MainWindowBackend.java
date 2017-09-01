package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

/**
 * The back end logic that is attached to MainWindow
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 1-SEPT-2017
 */
public class MainWindowBackend {
	
	// The file where the user's entry data is kept
	private File userDataFile;
	// The entries that are displayed on the main window
	private ArrayList<BasicEntry> entriesCurrentlyDisplayed;
	// The XMLEntryReader that allows users to view their entries in the userData.xml file
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
	private final void createNewUserDataFile() {
		try {
			this.userDataFile.createNewFile();
			
			Document dom;
		    
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
				System.err.println(e1.getMessage());
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
	public final boolean userDataFileExists() {
		return this.userDataFile.exists();
	}
	
	
	/**
	 * Removes an entry identified by a its "EntryName"
	 * 
	 * @param entryName The name of an entry
	 */
	public final void removeEntry(String entryName) {
		EntryXMLWriter.getInstance().removeEntryFromXML(entryName);
	}
	

	/**
	 * Returns an ArrayList of user entries of a given type
	 * 
	 * @param type Different types that the user can retrieve from the user data file. 
	 * Type 0: "Login". Type 1: "Computer". Type 2: "Credit Card". Type 3: All entries.
	 * @return Returns an ArrayList of BasicEntrys
	 */
	public final ArrayList<BasicEntry> getEntriesByType(int type) {
		
		this.xmlReader.getEntriesByType(type);
		
		this.entriesCurrentlyDisplayed = this.xmlReader.getCurrentEntries();
		
		return this.xmlReader.getCurrentEntries();
	}
	
	/**
	 * Returns an ArrayList of all user entries in the userData.xml file
	 * 
	 * @return Returns an ArrayList of all current entries
	 */
	public final ArrayList<BasicEntry> getAllEntries() {
		
		this.xmlReader.updateAllEntries();
		
		this.entriesCurrentlyDisplayed = this.xmlReader.getCurrentEntries();
		
		return this.xmlReader.getCurrentEntries();
	}
	
	/**
	 * Get the entries that are currently being displayed in the UI
	 * 
	 * @return Returns the entries that are currently being displayed in the UI
	 */
	public final ArrayList<BasicEntry> getEntriesCurrentlyDisplayed() {
		return this.entriesCurrentlyDisplayed;
	}

}
