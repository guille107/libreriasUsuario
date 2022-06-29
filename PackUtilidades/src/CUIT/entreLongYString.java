package CUIT;

public class entreLongYString {

	public static String getCUITStr(long nroCUIT) {
		
		if(String.valueOf(nroCUIT).length()!=11)
			return "";

		
		return String.valueOf(nroCUIT).substring(0, 2) + "-" + String.valueOf(nroCUIT).substring(2, 10) + "-" + String.valueOf(nroCUIT).substring(9, 10);
		
	}
	
	public static long getCUITLong(String CUIT) {

		if(CUIT.length()!=13)
			return -1;
		
		CUIT = CUIT.replace("-","");
		CUIT = CUIT.replace("/","");
		
		
		return Long.parseLong(CUIT);

		
	}
	
	
}
