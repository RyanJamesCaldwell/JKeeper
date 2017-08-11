package testEntries;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import entries.*;

/**
 * This JUnit test class ensures that the attributes of the ComputerEntry 
 * class can be set and retrieved properly
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 11-AUG-2017
 *
 */
public class TestComputerEntries {
	
	private static ComputerEntry testComputerEntry;
	
	@BeforeClass
	/**
	 * Creates a CreditCardEntry with the argumented constructor.
	 */
	public static void createCreditCardEntry() {
		System.out.println("ComputerEntry tests starting...");
		testComputerEntry = new ComputerEntry("Test CC Entry", "Test Username", "testPassword$!4", 
				"http://www.google.com/", "test@test.com");
	}
	
	@Test
	/**
	 * Tests that the entryName has been set properly.
	 */
	public void validateEntryName() {
		Assert.assertTrue(testComputerEntry.getEntryName() != null);
	}
	
	@Test
	/**
	 * Tests that the entryUsername has been set properly.
	 */
	public void validateEntryUsername() {
		Assert.assertTrue(testComputerEntry.getEntryUsername() != null);
	}
	
	@Test
	/**
	 * Tests that the entryPassword has been set properly.
	 */
	public void validateEntryPassword() {
		Assert.assertTrue(testComputerEntry.getEntryPassword() != null);
	}
	
	@Test
	/**
	 * Tests that the entryURL has been set properly.
	 */
	public void validateEntryURL() {
		Assert.assertTrue(testComputerEntry.getEntryURL() != null);
	}
	
	@Test
	/**
	 * Tests that the entryEmail has been set properly.
	 */
	public void validateEntryEmail() {
		Assert.assertTrue(testComputerEntry.getEntryEmail() != null);
	}
	
	@AfterClass
	/**
	 * Notifies the user that the tests have concluded being run.
	 */
	public static void afterTestsResults() {
		System.out.println("ComputerEntry tests have finished.");
	}
}
