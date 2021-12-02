package cadenas;

/// Clase para rellenar con ceros  una cadena de caracteres. 
/// Recibe un string con la cadena a rellenar y un Int con la cantidad de caracteres que deberá tener al final
/// Finalmente un string "I" o "D" que carga los datos a la izq. o a la der.
/// La clase calcula la cant de ceros que le falta y devuelve el string completo
/// 19/11/2020 GUILLE

public final class RellenarCeros {
	static Integer cuantosFaltan;
	static String respuesta="";
	
	public RellenarCeros() {
		
	}
	
	public static String llenar(String dato, Integer cantCeros, String Lado) {
		
		if(dato.length()<cantCeros) {
			if(Lado=="I") {
				cuantosFaltan=cantCeros-dato.length();
				for(int i=0;i<cuantosFaltan;++i) {
					dato="0"+dato;
				}
			}else {
				cuantosFaltan=cantCeros-dato.length();
				for(int i=0;i<cuantosFaltan;++i) {
					dato=dato+"0";
				}
			}
			
		}
		
		respuesta=dato;
		return respuesta;
	}


	
}
