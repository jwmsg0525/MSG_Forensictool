package codes;



import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeReturn {

	public String LtoT(long utctime, double timez) {
		String ou = "error";
		try {
			long tmzdd =(long)(timez*3600000);
		ou = new SimpleDateFormat("yyyy MM dd HH mm ss").format(utctime+(tmzdd));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ou;
		
	}
	
	
	public String TtoL(String timess) {
		String ou = "error";
		try {
			int [] times = new int [6];
			for (int i = 0 ; i < 6 ; i++) {
				times[i] = Integer.parseInt(timess.split(" ")[i]);
			}
			SimpleDateFormat f = new SimpleDateFormat("yyyy MM dd HH mm ss");
			Date dt = f.parse(timess);
			ou = ""+dt.getTime();
			
		}catch(Exception e) {
			System.out.println("error::"+e.getMessage());
		}
		
		return ou;
	}

}
