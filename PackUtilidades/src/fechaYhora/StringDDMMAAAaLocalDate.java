package fechaYhora;

import java.time.LocalDate;

public class StringDDMMAAAaLocalDate {
	
	public static LocalDate StringDDMMAAAaLocalDate(String fechaSTR) {
		if(fechaSTR.length()<8)
			return LocalDate.parse("1900-01-01");
		String[] partes = fechaSTR.split("/");
		String dia = partes[0];
		String mes = partes[1];
		String anio = partes[2];
		
		String fechaSalida = 	anio.concat("-").concat(mes).concat("-").concat(dia);
	
		return LocalDate.parse(fechaSalida);
	}

}
