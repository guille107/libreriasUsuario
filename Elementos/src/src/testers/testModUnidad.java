package testers;

import java.util.ArrayList;

import unidades.modUnidad;

public abstract class testModUnidad {

	public static void main(String[] args) {
		
		modUnidad[] listaUni=new modUnidad().todasLasUnidades();
		
		for(int a=0;a<listaUni.length;a++) {
			System.out.println("1-"+listaUni[a].toString());
		}

	}

}
