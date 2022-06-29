package testers;

import java.time.Duration;
import java.time.Instant;

import rubros.modRubros;
import unidades.modUnidad;

public abstract class testModUnidad {
	private modUnidad[] listas;

	public static void main(String[] args) {
		
		modUnidad uni=new modUnidad();
		modUnidad[] listas=uni.todasLasUnidades();
		
		System.out.println("Imprimiendo todas las Unidades: ");
		Instant inicio = Instant.now();
		 
		for(modUnidad listUni:listas) {
			
			System.out.println(listUni.toString());
			
		}
		 Instant fin = Instant.now();
		
		 System.out.println("Tiempo demorado "+Duration.between(inicio, fin));

		
		

	}

}
