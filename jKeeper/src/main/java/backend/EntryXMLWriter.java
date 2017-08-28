package backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import entries.BasicEntry;
import entries.ComputerEntry;
import entries.CreditCardEntry;
import entries.LoginEntry;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

/**
 * Class is used for writing new entries to the userData.xml file
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 28-AUG-2017
 */
public class EntryXMLWriter {

	// File containing the user's entry data
	private File userFile;
	// DocumentBuilder used for writing to XML file
	private DocumentBuilder db;
	// Generates new DocumentBuilder instance
	private DocumentBuilderFactory dbf;
	// The index of the root element; this has new child nodes (entries) appended to it
	private final int ROOT_ELEMENT_INDEX = 0;
	
	/**
	 * Takes a BasicEntry as a parameter to write to the userData.xml file
	 */
	public EntryXMLWriter() {
		userFile = new File(System.getenv("APPDATA") + "/jKeeper/userData.xml");
	}
	
	/**
	 * Writes a LoginEntry to the user's userData.xml file
	 * 
	 * @param newEntry A LoginEntry to be written to the userData.xml file
	 */
	public void writeLoginEntryToFile(LoginEntry newEntry) {
		if(newEntry.getClass() != LoginEntry.class){
			System.err.println("Error: Not a LoginEntry.");
		}
		else {
			writeDefaults(newEntry);
		}
	}
	
	/**
	 * Removes an entry from the userData.xml file by searching by entry name
	 * 
	 * @param entryName The name of the entry that will be removed
	 * @return Returns true if the entry was successfully found and removed, false otherwise.
	 */
	public boolean removeEntryFromXML(String entryName) {
		Document dom;
	    boolean foundNode = false;
	    this.dbf = DocumentBuilderFactory.newInstance();
	    
	    // Open the existing userData.xml document to write to it
		try {
	        this.db = dbf.newDocumentBuilder();
	        dom = this.db.parse(this.userFile);
	        
	        NodeList entries = dom.getElementsByTagName("entry");
	        
	        NamedNodeMap attributes;
	        for(int i = 0; i < entries.getLength(); i++) {
	        	attributes = entries.item(i).getAttributes();
	        	if(attributes.getNamedItem("name").getTextContent().equals(entryName)) {
	        		foundNode = true;
	        		Node itemToRemove = entries.item(i);
	        		itemToRemove.getParentNode().removeChild(itemToRemove);
	        	}
	        }
	        
	        if(foundNode) {
	        	this.writeToFile(dom);
	        }
	        
		} catch (Exception e1) {
			System.err.println("Exception encountered when removing node from userData.xml file.");
		}
		
		return foundNode;
	}
	
	/**
	 * Writes a ComputerEntry to the user's userData.xml file
	 * 
	 * @param newEntry A ComputerEntry to be written to the userData.xml file
	 */
	public void writeComputerEntryToFile(ComputerEntry newEntry) {
		if(newEntry.getClass() != ComputerEntry.class){
			System.err.println("Error: Not a ComputerEntry.");
		}
		else {
			writeDefaults(newEntry);
		}
	}
	
	// Writes the type, name, username, password, URL, and email to the file
	private void writeDefaults(BasicEntry newEntry) {
		Document dom;
	    
	    this.dbf = DocumentBuilderFactory.newInstance();
	    
	    // Open the existing userData.xml document to write to it
		try {
	        this.db = this.dbf.newDocumentBuilder();
	        dom = this.db.parse(this.userFile);
	        
	        NodeList rootElement = dom.getElementsByTagName("entries");
	        Element newElement;
	        // Write all information to the new entry
	        Element newEntryItem = dom.createElement("entry");
	        
	        // Add "type" and "name" attributes to the new entry
	        newEntryItem.setAttribute("type", newEntry.getEntryType());
	        newEntryItem.setAttribute("name", newEntry.getEntryName());
	        
	        // Add the sub-elements describing the entry
	        newElement = dom.createElement("username");
	        newElement.setTextContent(newEntry.getEntryUsername());
	        newEntryItem.appendChild(newElement);
	        newElement = dom.createElement("password");
	        newElement.setTextContent(newEntry.getEntryPassword());
	        newEntryItem.appendChild(newElement);
	        newElement = dom.createElement("URL");
	        newElement.setTextContent(newEntry.getEntryURL());
	        newEntryItem.appendChild(newElement);
	        newElement = dom.createElement("email");
	        newElement.setTextContent(newEntry.getEntryEmail());
	        newEntryItem.appendChild(newElement);
	        
	        rootElement.item(ROOT_ELEMENT_INDEX).appendChild(newEntryItem);
	        
	        this.writeToFile(dom);
	        
		} catch (Exception e1) {
			System.err.println("Exception encountered when writing to userData.xml file.");
		}
	}

	/**
	 * Writes a CreditCardEntry to the user's userData.xml file
	 * 
	 * @param newEntry A CreditCardEntry to be written to the userData.xml file
	 */
	public void writeCreditCardEntryToFile(CreditCardEntry newEntry) {
		if(newEntry.getClass() != CreditCardEntry.class){
			System.err.println("Error: Not a CreditCardEntry.");
		}
		else {
			Document dom;
		    
		    this.dbf = DocumentBuilderFactory.newInstance();
		    
		    // Open the existing userData.xml document to write to it
			try {
		       this.db = this.dbf.newDocumentBuilder();
		        dom = this.db.parse(this.userFile);
		        
		        NodeList rootElement = dom.getElementsByTagName("entries");
		        Element newElement;
		        // Write all information to the new entry
		        Element newEntryItem = dom.createElement("entry");
		        
		        // Add "type" and "name" attributes to the new entry
		        newEntryItem.setAttribute("type", "Credit Card");
		        newEntryItem.setAttribute("name", newEntry.getEntryName());
		        
		        // Add the sub-elements describing the entry
		        newElement = dom.createElement("username");
		        newElement.setTextContent(newEntry.getEntryUsername());
		        newEntryItem.appendChild(newElement);
		        newElement = dom.createElement("password");
		        newElement.setTextContent(newEntry.getEntryPassword());
		        newEntryItem.appendChild(newElement);
		        newElement = dom.createElement("URL");
		        newElement.setTextContent(newEntry.getEntryURL());
		        newEntryItem.appendChild(newElement);
		        newElement = dom.createElement("email");
		        newElement.setTextContent(newEntry.getEntryEmail());
		        newEntryItem.appendChild(newElement);
		        newElement = dom.createElement("ccNumber");
		        newElement.setTextContent(newEntry.getCreditCardNumber());
		        newEntryItem.appendChild(newElement);
		        newElement = dom.createElement("expirationDate");
		        newElement.setTextContent(newEntry.getExpiration());
		        newEntryItem.appendChild(newElement);
		        newElement = dom.createElement("securityCode");
		        newElement.setTextContent(newEntry.getSecurityCode());
		        newEntryItem.appendChild(newElement);
		        
		        rootElement.item(ROOT_ELEMENT_INDEX).appendChild(newEntryItem);
		        
		        this.writeToFile(dom);
		        
			} catch (Exception e1) {
				System.err.println("Exception encountered when writing to userData.xml file.");
			}
		}
	}
	
	// Writes the Document to the user's userData.xml file
	// 
	// @param dom The document that will be written back to the userData.xml file
	private void writeToFile(Document dom) {
		try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            FileOutputStream fos = new FileOutputStream(this.userFile);
            // send DOM to file
            tr.transform(new DOMSource(dom), 
                                 new StreamResult(fos));
            fos.close();
        } catch (TransformerException te) {
            System.err.println(te.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
	}
}