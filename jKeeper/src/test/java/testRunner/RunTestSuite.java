package testRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testEntries.TestCCEntries;
import testEntries.TestComputerEntries;

@RunWith(Suite.class)
@SuiteClasses({ TestCCEntries.class, TestComputerEntries.class })
public class RunTestSuite {
	
}