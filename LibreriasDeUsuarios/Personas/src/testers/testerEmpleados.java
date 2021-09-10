package testers;

import java.time.LocalDate;

import empleados.modEmpleado;

public class testerEmpleados {

	public static void main(String[] args) {

		
		System.out.println("Resultado de buscar 0: "+new testerEmpleados().testSiExisteID(0));
		System.out.println("Resultado de buscar 1: "+new testerEmpleados().testSiExisteID(1));
		System.out.println("Listar todos los empleados: ");
		new testerEmpleados().testerTodos();
		
		//System.out.println("Resultado de dar de alta art 99999: "+new testerEmpleados().altaArticulo());
		//System.out.println("Resultado de eliminar articulo cuyo ID es 99999: " + new testerEmpleados().eliminaArticulo("99999"));
		//System.out.println("Resultado de eliminar articulo Que no existe: " + new testerEmpleados().eliminaArticulo("9swqsws9"));
		//System.out.println("Resultado de eliminar articulo nullo: " + new testerEmpleados().eliminaArticulo(null));
		
	}
	
	public void   testerTodos() {
		modEmpleado empleados[]=new modEmpleado().todosLosEmpleados();
		for(int a=0;a<empleados.length;a++) {
			System.out.println(empleados[a].toString());
		}
	}

/**	public boolean altaArticulo() {
		
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
	}**/
	public boolean testSiExisteID(int ID) {
		
		if(new modEmpleado().verificaSiExisteID(ID))
			return true;
		
		return false;
	}
	

}
