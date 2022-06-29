package crTransfo;

public class CRTransfo {
	private static int coeficiente=3;
	
	public static String EncriptaElParametro(String textoSinEncriptar) {
		
		char caracter;
		String textoEncriptado="";
		
		for(int a=0;a<textoSinEncriptar.length();a++) {
			caracter = textoSinEncriptar.charAt(a);
			
			//textoEncriptado=textoEncriptado+Character.toString((int)caracter+coeficiente);
			textoEncriptado = textoEncriptado + Character.valueOf((char) ((int)caracter+coeficiente));

		}
		
		return textoEncriptado;
	
	}
	
	public static String DesEncriptaElParametro(String textoEncriptado) {
						
		char caracter;

		String textoSinEncriptar="";
			
		for(int a=0;a<textoEncriptado.length();a++) {
				
			caracter=textoEncriptado.charAt(a);

			//textoSinEncriptar=textoSinEncriptar+Character.toString((int)caracter-coeficiente);
			textoSinEncriptar=textoSinEncriptar+(char)((int)caracter-coeficiente);
		}
			
			
		return textoSinEncriptar;
	}

	public static int getCoeficiente() {
		return coeficiente;
	}

	public static void setCoeficiente(int coeficiente) {
		CRTransfo.coeficiente = coeficiente;
	}

}
