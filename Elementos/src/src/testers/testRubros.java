package testers;

import rubros.modRubros;
import unidades.modUnidad;

public class testRubros {

	public static void main(String[] args) {
		
		modRubros uni=new modRubros();
		uni.buscaRubroXID("R01S02");
		System.out.println(uni.toString());

	}

}
