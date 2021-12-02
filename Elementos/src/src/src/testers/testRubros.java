package testers;

import java.time.Duration;
import java.time.Instant;

import rubros.modRubros;
import unidades.modUnidad;

public class testRubros {

	public static void main(String[] args) {
		
		modRubros rubros=new modRubros();
		rubros.buscaRubroXID("R01S02");
		System.out.println(rubros.toString());
		
		System.out.println("Imprimiendo todos los rubros: ");
		Instant inicio = Instant.now();
		for(modRubros lista:rubros.todosLosRubros()) {
			System.out.println(lista.toString());
			
		}
		 Instant fin = Instant.now();
		 Duration tiempoTranscurrido = Duration.between(inicio, fin);
		
		 System.out.println("Tiempo demorado "+tiempoTranscurrido);


	}

}
