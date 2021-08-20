package testers;

import elementos.articulos.modArticulos;

public abstract class testArticulos {

	public static void main(String[] args) {
		modArticulos arti=new modArticulos();
		//System.out.println(arti.verificaSiExisteID("C13102R3"));
		//System.out.println(arti.verificaSiExisteID("C13100R3"));
		System.out.println(arti.buscaXIDYDevuelveElObjetoEncontrado("C13102R3").toString());
		
	}

}
