package testers;

import CUIT.entreLongYString;
import CUIT.validaCUIT;

public class testCUIT {

	public static void main(String[] args) {
		System.out.println("DE LONG A STRING");
		System.out.println("----------------");
		System.out.println("Probando CUIT de 11 caracteres: " + entreLongYString.getCUITStr(20257871933L));
		System.out.println("Probando CUIT de 10 caracteres: " + entreLongYString.getCUITStr(2025787193L));
		System.out.println("Probando CUIT de 12 caracteres: " + entreLongYString.getCUITStr(202578719993L));		

		System.out.println("");
		System.out.println("DE STRING A LONG");
		System.out.println("----------------");
		System.out.println("Probando CUIT de 11 caracteres: " + entreLongYString.getCUITLong("20-25787193-3"));
		System.out.println("Probando CUIT de 10 caracteres: " + entreLongYString.getCUITLong("20-2577193-3"));
		System.out.println("Probando CUIT de 12 caracteres: " + entreLongYString.getCUITLong("20-257847193-3"));	
		
		System.out.println("VALIDAR CUIT");

		System.out.println("Probando String CUIT 27-26652318-7: " +  validaCUIT.esValido("27-26652318-7"));
		System.out.println("Probando Long CUIT 27266523187" + validaCUIT.esValido(27266523187L));
		
	}

}
