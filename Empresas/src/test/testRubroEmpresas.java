package test;

import java.time.Duration;
import java.time.Instant;

import rubros.modRubroEmpresa;


public class testRubroEmpresas {

	public static void main(String[] args) {
		modRubroEmpresa rubros=new modRubroEmpresa();
		rubros.buscaRubroXID("DIAL");
		System.out.println(rubros.toString());
		
		System.out.println("Imprimiendo todos los rubros: ");
		Instant inicio = Instant.now();
		for(modRubroEmpresa lista:new modRubroEmpresa().todosLosRubros()) {
			System.out.println(lista.toString());
			
		}
		 Instant fin = Instant.now();
		 Duration tiempoTranscurrido = Duration.between(inicio, fin);
		
		 System.out.println("Tiempo demorado "+tiempoTranscurrido);


	}

	

}
