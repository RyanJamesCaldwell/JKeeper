package backend;

//import java.util.Arrays;
//import java.util.Scanner;
//
//import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * This class will eventually be used for hashing the entered passwords so 
 * it isn't store in plain text.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 10-AUG-2017
 */
public class Password {
	
	//private String password;
	//private String SALT = "random-salt-string";

	public Password() {
	
	}

	public void saltPassword() {
		// TODO Auto-generated method stub
		
	}

	public void hashPassword() {
		// TODO Auto-generated method stub
		
	}

	public void getHashedPassword() {
		
	}


}

//// Code for comparing hashed passwords
//byte[] storedPassword = DigestUtils.sha256(this.password + SALT);
//Scanner scanner = new Scanner(System.in);
//String attempt = scanner.nextLine();
//byte[] attemptBytes = DigestUtils.sha256(attempt + SALT);
//
//if(Arrays.equals(attemptBytes, storedPassword)) {
//	System.out.println("That's the correct password!");
//}
//else {
//	System.out.println("That's not correct");
//}
