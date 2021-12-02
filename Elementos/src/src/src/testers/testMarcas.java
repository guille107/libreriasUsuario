package testers;

import marcas.modMarcas;

public class testMarcas {

	public static void main(String[] args) {
		
		modMarcas marcas=new modMarcas();
		modMarcas[] listas=marcas.todasLasMarcas();
		 
		for(modMarcas listUni:listas) {
			
			System.out.println(listUni.toString());
			
		}

	}

}
