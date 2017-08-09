package constants;

import java.io.File;

public class Constants {
	static {
		File APP_DATA_FOLDER = new File(System.getenv("APPDATA"));
		File JKEEPER_FOLDER = new File(System.getenv("APPDATA" + "/JKeeper"));
		File USER_PROFILE = new File(System.getenv("APPDATA") + "/JKeeper/userProfile.csv");
	}
}
