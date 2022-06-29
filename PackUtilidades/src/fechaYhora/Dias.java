package fechaYhora;

import java.time.LocalDate;

public class Dias {

private static String[] diaEspanol = {"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO","DOMINGO"};

	public static String Dias (int dia) {
		
		if(dia>7 || dia<1)
			return "";
		return diaEspanol[dia-1];
		
	
	}
	public static String Meses(LocalDate fecha) {
		
		return Dias(fecha.getDayOfWeek().getValue());
		
	}

	
}