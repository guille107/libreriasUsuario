package testers;

import localiProvi.modLocaliProvi;

public class testModLocaliProvi {

	public static void main(String[] args) {
		
		getTodas();
		getUna("14_1456");
		getPorProvincia("MENDOZA");
		getPorProvincia("cordoba"); 
		getPorCP( "8150");
		getPorPais("bolivia");
		getPorPaisProvinciaLocalidad("Argentina","cordoba","cach");
			
	}
 
	private static void getPorPaisProvinciaLocalidad(String string, String string2, String string3) {
		
		System.out.println("Buscando por pais " + string + ", provincia " + string2 + " y Localidad " + string3);
		System.out.println(new modLocaliProvi().devulveLocaliProviDesdeDatos(string,string2,string3));
		
	}

	private static void getPorPais(String string) {
		System.out.println("Buscando por pais " + string);
		String[] temp = new modLocaliProvi().getProvinciasPorPais(string);

		for(String lista:temp) {
			
			System.out.println(lista.toString());
		}		
		
	}

	private static void getPorCP(String string) {
		System.out.println("Buscando por CP " + string);
		System.out.println(new modLocaliProvi().buscaLocaliProviPorCodPostal(string));
		
	}


	private static void getPorProvincia(String string) {
		
		System.out.println("Buscando " + string);
		String[] temp = new modLocaliProvi().todasLasLocalidadesDeUnaProvincia(string);
		for(String lista:temp) {
			System.out.println(lista.toString());
		}
		
	}

	private static void getUna(String string) {
		
		System.out.println("Buscando " + string);
		System.out.println(new modLocaliProvi().buscaLocaliProviPorID(string));
		
	}

	private static void getTodas() {
		
		modLocaliProvi[] temp = new modLocaliProvi().getListaCompleta();

		for(modLocaliProvi lista:temp) {
			System.out.println(lista.toString());
		}
	}
}
