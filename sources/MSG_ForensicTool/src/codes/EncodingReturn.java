package codes;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;







public class EncodingReturn {

	public EncodingReturn() {
		// TODO Auto-generated constructor stub
	}
	
	public String EncodURL(String stream) {
		String ou = "error";
		
		try {
			ou = URLEncoder.encode(stream,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ou;
	}
	
	
	public String DecodURL(String stream) {
		String ou = "error";
		
		try {
			ou = URLDecoder.decode(stream,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ou;
	}
	
	public String EncodBase64(String stream) {
		String ou = "error";	
		
		ou = Base64.getEncoder().encodeToString(stream.getBytes());
		return ou;
	}
	
	public String DecodBase64(String stream) {
		String ou = "error";
		String dt = "";
		byte[] by = Base64.getDecoder().decode(stream);
		for(byte bt : by) {
			dt += (char)bt;
			ou = dt;
		}
		
		return ou;
	}
	
	
	public String sToh(String stream) {
		String ou = "error";
		
		String map = "0123456789ABCDEF";
		byte[] by = stream.getBytes();
		String tap = "";
		for (byte bt : by) {
			int upper = bt>>4;
			int downner = (bt&0x0F);
			String tmp = (map.charAt(upper%16)+"") + (map.charAt(downner%16)+"");
			tap += tmp;
			ou = tap;
		}
		return ou;
	}
	
	
	public String hTos(String stream) {
		String ou = "error";
		
		if((stream.length()%2)!=0) {
			return ou + ": Format error!";
		}
		
		String map = "0123456789ABCDEF";
		String tap = "";
		for (int i = 0 ; i < stream.length();i++) {
			int upper = map.indexOf(stream.charAt(i)+"")<<4;
			int downner = map.indexOf(stream.charAt(++i)+"");
			char tmp =  (char) (upper+ downner);
			tap+=(tmp+"");
			ou = tap;
		} 
		
		
		
		
		return ou;
	}
	

}
