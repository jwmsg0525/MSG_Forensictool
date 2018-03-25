package codes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class GenHash {
	byte [] byt = null;
	String filepath  = null;
	public GenHash(String filepath) {
		// TODO Auto-generated constructor stub
		this.filepath = filepath;
	}
	
	private String b2Hex(final byte[] hash) {
		@SuppressWarnings("resource")
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		return formatter.toString();
	}

	public boolean fileopen() {
		if(filepath==null) {
			return false;
		}
		try {
            InputStream inputStream = new FileInputStream(filepath);
            long fileSize = new File(filepath).length();
            byte[] allBytes = new byte[(int) fileSize];
            inputStream.read(allBytes);
            byt = allBytes;
            inputStream.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
	}
	
public String md5hash() {
		String ou = "error";
		if(byt==null) {
			return ou;
		}
		MessageDigest md ;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return ou;
		}
		return b2Hex(md.digest(byt));
	}
	public String sha1hash() {
		String ou = "error";
		if(byt==null) {
			return ou;
		}
		MessageDigest md ;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return ou;
		}
		return b2Hex(md.digest(byt));
	}
	public String sha256hash() {
		String ou = "error";
		if(byt==null) {
			return ou;
		}
		MessageDigest md ;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return ou;
		}
		return b2Hex(md.digest(byt));
	}
}
