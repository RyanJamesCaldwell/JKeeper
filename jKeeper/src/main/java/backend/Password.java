package backend;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
	
	private final String ALGORITHM = "PBKDF2WithHmacSHA1";
	private String password;
	private final int DERIVED_KEY_LENGTH = 160;
	private final int ITERATIONS = 20000;
	private final byte[] SALT;

	private Password(String newPassword) {
		this.password = newPassword;
		String tempSalt = "SALT2345";
		this.SALT = tempSalt.getBytes();
	}
	
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
	
	public boolean equals(byte[] otherEncryptedPassword) {
		return Arrays.equals(getEncryptedPassword(), otherEncryptedPassword);
	}
	
	public static void main(String[] args) {
		Password hi = new Password("hi");
		System.out.println(hi.equals(new Password("hi").getEncryptedPassword()));
	}
}
