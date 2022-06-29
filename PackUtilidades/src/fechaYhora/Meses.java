package fechaYhora;

import java.time.LocalDate;

public class Meses {
			
	private static String[] mesEspanol = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO",
			
			"SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};

	public static String Meses (int mes) {
		if(mes>12 || mes<1)
			return "";
		return mesEspanol[mes-1];
	
	}
	public static String Meses(LocalDate fecha) {
		return Meses(fecha.getMonthValue());
	}

	
}