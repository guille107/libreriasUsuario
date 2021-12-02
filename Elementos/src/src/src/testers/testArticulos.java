package testers;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import elementos.articulos.modArticulos;
import rubros.modRubros;
import unidades.modUnidad;

public class testArticulos {

	public static void main(String[] args) {

		System.out.println("TESTEANDO MODELO ARTICULOS");
		System.out.println("--------------------------");
		
		System.out.print("Resultado de buscar C13100R3: ");
		new testArticulos().testSiExisteID("C13100R3");
		
		System.out.println("Resultado de buscar sssss: "+new testArticulos().testSiExisteID("sssss"));
		
		System.out.println("Resultado de dar de alta art 99999: "+new testArticulos().altaArticulo());
		
		System.out.println("Resultado de eliminar articulo cuyo ID es 99999: " + new testArticulos().eliminaArticulo("99999"));
		
		System.out.println("Resultado de eliminar articulo Que no existe: " + new testArticulos().eliminaArticulo("9swqsws9"));
		
		System.out.println("Resultado de eliminar articulo nullo: " + new testArticulos().eliminaArticulo(null));
		
		System.out.println("Resultado de buscar por código de Proveedor M06F: "+new testArticulos().testSiExisteIDProveedor("M06F"));
		
		System.out.println("Lista con todos los articulos");
		System.out.println("--------------------------");
		
		
		 Instant inicio = Instant.now();
		
		 
		new testArticulos().todosLosArticulos();
		 Instant fin = Instant.now();
		 Duration tiempoTranscurrido = Duration.between(inicio, fin);
		
		System.out.println("Tiempo demorado en generar la lista "+tiempoTranscurrido);

	}
	
	private  void todosLosArticulos() {

		for(modArticulos lista:new modArticulos().listaDeTodos()) {
			
			System.out.println(lista.toString());
			
		}
		
		System.out.println("Cantidad de articulos en la lista de todos: " + new modArticulos().listaDeTodos().length);

	}


	private boolean testSiExisteIDProveedor(String string) {
		
		if(new modArticulos().verificaSiExisteProveedor(string))
			return true;
		return false;
		
	}

	public boolean altaArticulo() {
		
		modArticulos articulo=new modArticulos();
		
		articulo.setActivo(true);
		articulo.setIdElemento("99999");
		articulo.setDescElemento("ELEMENTO DE PRUEBA");
		articulo.setCodBarra("123456899");
		articulo.setPeso(100.50);
		articulo.setUbicacion("UI");
		articulo.setUnidad(new modUnidad().buscaUnidadXID(1));
		articulo.setStockActual(1000);
		articulo.setStockMin(500);
		articulo.setMultVenta(100);
		articulo.setRubro("R03S04");
		articulo.setMarca(2);
		articulo.setTasaIVA(21);
		articulo.setComiVentaAbs(3);
		articulo.setComiVentasRel(3);
		articulo.setComiCobraAbs(3);
		articulo.setComiCobraRel(3);
		articulo.setFechaModiFicha(LocalDate.parse("2021-08-26"));
		articulo.setMultCompra(100);
		articulo.setAnalizainfoComercial(false);
		
		return new modArticulos().altaElemento(articulo);
	}
	public boolean eliminaArticulo (String ID) {
		
		if(new modArticulos().bajaElemento(new modArticulos().buscaXIDYDevuelveElObjetoEncontrado(ID)))
			return true;
		
		return false;
	}
	public boolean testSiExisteID(String ID) {
		
		if(new modArticulos().verificaSiExisteID(ID)) {
			System.out.println(new modArticulos().buscarElElementoPorVariosCampos(ID).toString());
			return true;
		}
		return false;
	}
	

}
