package backend;

import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 
 * This class will eventually be used for hashing the entered passwords so 
 * it isn't store in plain text.
 * 
 * @author Ryan Caldwell
 * @version Version 1.0, 28-AUG-2017
 */
public final class Password {
	
	// The encryption algorithm that is going to be used
	private final String ALGORITHM = "PBKDF2WithHmacSHA1";
	// The String version of the password that the user wants to encrypt
	private String password;
	private final int DERIVED_KEY_LENGTH = 160;
	private final int ITERATIONS = 20000;
	private final byte[] SALT;

	/**
	 * Creates a new password to be encrypted
	 * 
	 * @param newPassword A String that the user wants to encrypt
	 */
	public Password(String newPassword) {
		this.password = newPassword;
		String tempSalt = "SALT2345";
		this.SALT = tempSalt.getBytes();
	}
	
	/**
	 * Salts and encrypts the user's password sent into the constructor
	 * 
	 * @return Returns the user's password after salting and encryption
	 */
	public byte[] getEncryptedPassword() {
		KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, ITERATIONS, DERIVED_KEY_LENGTH);
		SecretKeyFactory f;
		byte[] encryptedPass = null;
		
		try {
			f = SecretKeyFactory.getInstance(ALGORITHM);
			encryptedPass = f.generateSecret(spec).getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return encryptedPass;
	}
	
	/**
	 * Checks if one password is equal to another
	 * 
	 * @param otherEncryptedPassword A password to be compared
	 * @return Returns true if they are equal, false otherwise
	 */
	public boolean equals(byte[] otherEncryptedPassword) {
		return Arrays.equals(getEncryptedPassword(), otherEncryptedPassword);
	}
	
	public static void main(String[] args) {
		Password hi = new Password("hi");
		System.out.println(hi.equals(new Password("hi").getEncryptedPassword()));
	}
}
