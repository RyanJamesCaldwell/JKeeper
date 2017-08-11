package testEntries;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import entries.*;

/**
 * This JUnit test class ensures that the attributes of the CreditCardEntry 
 * class can be set and retrieved properly
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 *
 */
public class TestCCEntries {
	
	private static CreditCardEntry testCCEntry;
	
	@BeforeClass
	/**
	 * Creates a CreditCardEntry with the argumented constructor.
	 */
	public static void createCreditCardEntry() {
		System.out.println("CreditCardEntry tests starting...");
		testCCEntry = new CreditCardEntry("Test CC Entry", "Test Username", "testPassword$!4", 
				"http://www.google.com/", "test@test.com", "1111-1111-1111-1111", "5/20", "123");
	}
	
	@Test
	/**
	 * Tests that the entryName has been set properly.
	 */
	public void validateEntryName() {
		Assert.assertTrue(testCCEntry.getEntryName() != null);
	}
	
	@Test
	/**
	 * Tests that the entryUsername has been set properly.
	 */
	public void validateEntryUsername() {
		Assert.assertTrue(testCCEntry.getEntryUsername() != null);
	}
	
	@Test
	/**
	 * Tests that the entryPassword has been set properly.
	 */
	public void validateEntryPassword() {
		Assert.assertTrue(testCCEntry.getEntryPassword() != null);
	}
	
	@Test
	/**
	 * Tests that the entryURL has been set properly.
	 */
	public void validateEntryURL() {
		Assert.assertTrue(testCCEntry.getEntryURL() != null);
	}
	
	@Test
	/**
	 * Tests that the entryEmail has been set properly.
	 */
	public void validateEntryEmail() {
		Assert.assertTrue(testCCEntry.getEntryEmail() != null);
	}
	
	@Test
	/**
	 * Tests that the credit card number has been set properly.
	 */
	public void validateEntryCCNumber() {
		Assert.assertTrue(testCCEntry.getCreditCardNumber()!= null);
	}
	
	@Test
	/**
	 * Tests that the credit card's expiration has been set properly.
	 */
	public void validateEntryExpiration() {
		Assert.assertTrue(testCCEntry.getExpiration() != null);
	}
	
	@Test
	/**
	 * Tests that the credit card's security code has been set properly.
	 */
	public void validateEntrySecurityCode() {
		Assert.assertTrue(testCCEntry.getSecurityCode() != null);
	}
	
	@AfterClass
	/**
	 * Notifies the user that the tests have concluded being run.
	 */
	public static void afterTestsResults() {
		System.out.println("CreditCardEntry tests have finished.");
	}
}
