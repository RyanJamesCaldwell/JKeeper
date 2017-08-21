package backend;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entries.BasicEntry;
import entries.ComputerEntry;
import entries.CreditCardEntry;
import entries.LoginEntry;

/**
 * This class reads the userData.xml file and retrieves all of the entries.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 18-AUG-2017
 */
public class XMLEntryReader {

	// ArrayList of BasicEntry's from the userData.xml file
	private ArrayList<BasicEntry> allEntries;
	// The userData.xml file that will be parsed
	private File userDataFile;
	
	/**
	 * Upon creation, calls updateAllEntries() and retrieves all entries in the userData.xml file
	 * 
	 * @param newUserDataFile The userData.xml file that will be parsed for BasicEntry's
	 */
	public XMLEntryReader(File newUserDataFile) {
		this.allEntries = new ArrayList<BasicEntry>();
		this.userDataFile = newUserDataFile;
		this.updateAllEntries();
	}
	
	/**
	 * Fetches all the entries from the userData.xml file and updates the ArrayList of entries.
	 */
	public void updateAllEntries() {
		this.allEntries.clear();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(this.userDataFile);
			NodeList nl = doc.getElementsByTagName("entry");
			
			NamedNodeMap attributeNames;
			//NodeList entryInformation;
			for(int i = 0; i < nl.getLength(); i++) {
				attributeNames = nl.item(i).getAttributes();
				
				if(attributeNames.getNamedItem("type").getTextContent().equals("Credit Card")) {
					createCreditCardEntry(nl.item(i));
				}
				else if(attributeNames.getNamedItem("type").getTextContent().equals("Login")) {
					createLoginEntry(nl.item(i));
				}
				else if(attributeNames.getNamedItem("type").getTextContent().equals("Computer")) {
					createComputerEntry(nl.item(i));
				}
			}
		} catch (Exception e) {
			System.err.println("Error opening the userData.xml file for parsing.");
		}
	}
	
	/**
	 * Fetches all the entries from the userData.xml file and updates the ArrayList of entries.
	 */
	public void getEntriesByType(int type) {
		this.allEntries.clear();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(this.userDataFile);
			NodeList nl = doc.getElementsByTagName("entry");
			
			NamedNodeMap attributeNames;
			//NodeList entryInformation;
			for(int i = 0; i < nl.getLength(); i++) {
				attributeNames = nl.item(i).getAttributes();
				switch(type){
					case 0:
						if(attributeNames.getNamedItem("type").getTextContent().equals("Login")) {
							createLoginEntry(nl.item(i));
						}
						break;
					case 1:
						if(attributeNames.getNamedItem("type").getTextContent().equals("Computer")) {
							createComputerEntry(nl.item(i));
						}
						break;
					case 2:
						if(attributeNames.getNamedItem("type").getTextContent().equals("Credit Card")) {
							createCreditCardEntry(nl.item(i));
						}
						break;
					case 3:
						if(attributeNames.getNamedItem("type").getTextContent().equals("Login")) {
							createLoginEntry(nl.item(i));
						}
						else if(attributeNames.getNamedItem("type").getTextContent().equals("Computer")) {
							createComputerEntry(nl.item(i));
						}
						else if(attributeNames.getNamedItem("type").getTextContent().equals("Credit Card")) {
							createCreditCardEntry(nl.item(i));
						}
					default:
						break;
				}
			}
		} catch (Exception e) {
			System.err.println("Error opening the userData.xml file for parsing.");
		}
	}
	
	// Creates an instance of a ComputerEntry and adds it to the ArrayList "allEntries"
	//
	// @param creditCardNode A Credit Card found in the XML file
	private void createComputerEntry(Node computerNode) {
		ComputerEntry newComputerEntry;
		
		// Get the necessary attributes: name and type
		NamedNodeMap attributeNames = computerNode.getAttributes();
		// Get the information about the credit card
		NodeList entryData = computerNode.getChildNodes();

		newComputerEntry = new ComputerEntry(attributeNames.getNamedItem("name").getTextContent(),
				entryData.item(1).getTextContent(), entryData.item(3).getTextContent(),
				entryData.item(5).getTextContent(), entryData.item(7).getTextContent());
		
		this.allEntries.add(newComputerEntry);
	}

	// Creates an instance of a LoginEntry and adds it to the ArrayList "allEntries"
	//
	// @param creditCardNode A Credit Card found in the XML file
	private void createLoginEntry(Node loginNode) {
		LoginEntry newLoginEntry;
		
		// Get the necessary attributes: name and type
		NamedNodeMap attributeNames = loginNode.getAttributes();
		// Get the information about the credit card
		NodeList entryData = loginNode.getChildNodes();

		newLoginEntry = new LoginEntry(attributeNames.getNamedItem("name").getTextContent(),
				entryData.item(1).getTextContent(), entryData.item(3).getTextContent(),
				entryData.item(5).getTextContent(), entryData.item(7).getTextContent());
		
		this.allEntries.add(newLoginEntry);
	}

	// Creates an instance of a CreditCardEntry and adds it to the ArrayList "allEntries"
	//
	// @param creditCardNode A Credit Card found in the XML file
	private void createCreditCardEntry(Node ccNode) {
		CreditCardEntry cce;
		
		// Get the necessary attributes: name and type
		NamedNodeMap attributeNames = ccNode.getAttributes();
		// Get the information about the credit card
		NodeList entryData = ccNode.getChildNodes();

		cce = new CreditCardEntry(attributeNames.getNamedItem("name").getTextContent(),
				entryData.item(1).getTextContent(), entryData.item(3).getTextContent(),
				entryData.item(5).getTextContent(), entryData.item(7).getTextContent(),
				entryData.item(9).getTextContent(), entryData.item(11).getTextContent(),
				entryData.item(13).getTextContent());
		
		this.allEntries.add(cce);
	}

	/**
	 * Returns the ArrayList of entries in the userData.xml file. This ArrayList can be updated by
	 * calling updateAllEntries().
	 * 
	 * @return Returns the ArrayList of entries in the userData.xml file
	 */
	public ArrayList<BasicEntry> getCurrentEntries() {
		return this.allEntries;
	}
}
