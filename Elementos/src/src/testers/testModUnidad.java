package testers;

import unidades.modUnidad;

public abstract class testModUnidad {
	private modUnidad[] listas;

	public static void main(String[] args) {
		
		modUnidad uni=new modUnidad();
		modUnidad[] listas=uni.todasLasUnidades();
		 
		for(modUnidad listUni:listas) {
			
			System.out.println(listUni.toString());
			
		}
		
		

	}

}
