package testers;

import java.time.LocalDate;

import elementos.articulos.modArticulos;
import rubros.modRubros;
import unidades.modUnidad;

public class testArticulos {

	public static void main(String[] args) {

		
		System.out.println("Resultado de buscar C13100R3: "+new testArticulos().testSiExisteID("C13100R3"));
		System.out.println("Resultado de dar de alta art 99999: "+new testArticulos().altaArticulo());
		System.out.println("Resultado de eliminar articulo cuyo ID es 99999: " + new testArticulos().eliminaArticulo("99999"));
		System.out.println("Resultado de eliminar articulo Que no existe: " + new testArticulos().eliminaArticulo("9swqsws9"));
		System.out.println("Resultado de eliminar articulo nullo: " + new testArticulos().eliminaArticulo(null));
		
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
		
		return new modArticulos().altaElemento(articulo);
	}
	public boolean eliminaArticulo (String ID) {
		
		if(new modArticulos().bajaElemento(new modArticulos().buscaXIDYDevuelveElObjetoEncontrado(ID)))
			return true;
		
		return false;
	}
	public boolean testSiExisteID(String ID) {
		
		if(new modArticulos().verificaSiExisteID(ID))
			return true;
		return false;
	}
	

}
