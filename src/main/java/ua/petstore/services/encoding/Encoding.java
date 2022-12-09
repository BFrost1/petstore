package ua.petstore.services.encoding;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoding {
	private static final String SALT = "qetuop";
	
	public static String md5Encryption(String text) {
		String result = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(StandardCharsets.UTF_8.encode(text));
			result = String.format("%032x", new BigInteger(messageDigest.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String md5EncryptionWithSalt(String text) {
		return md5Encryption(text + SALT);
	}
}
