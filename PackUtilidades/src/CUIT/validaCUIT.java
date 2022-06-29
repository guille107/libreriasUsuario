package CUIT;

public class validaCUIT {
	private final static int largoCUIT = 11;
	
	
	public static boolean esValido(String sCUIT) {
		
		if(sCUIT.equals(null) )
			return false;
		
		String sCUITLimpio = sCUIT.replace("-", "");
		
		if(sCUITLimpio.length() != largoCUIT) 
			return false;
		
		return validar(sCUITLimpio.substring(0, 10), Integer.parseInt(sCUITLimpio.substring(10)));
		
	}
	
	public static boolean esValido(Long lCUIT) {
		
		return esValido(String.valueOf(lCUIT));
	}
	private static
	boolean validar(String encabezado, int verificador) {

		char[] cDigitos = encabezado.toCharArray();
		int[] num = new int[cDigitos.length];
		int[] multiplicador = {5,4,3,2,7,6,5,4,3,2};
		int suma=0;
		
		for(int a=0;a<cDigitos.length;a++) {
			
			num[a] = Integer.parseInt(String.valueOf(cDigitos[a]));
			suma = suma + num[a] * multiplicador[a];

		}
		
		int resultado = 11 - suma % 11;
		
		if(verificador == resultado) {
			return true;
		}
		return false;

	}

}
