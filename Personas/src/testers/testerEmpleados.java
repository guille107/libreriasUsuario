package testers;


import empleados.modEmpleado;

public class testerEmpleados {

	public static void main(String[] args) {

		
		System.out.println("Prueba: Resultado de buscar 0: "+new testerEmpleados().testSiExisteID(0));
		System.out.println("Prueba: Resultado de buscar 1: "+new testerEmpleados().testSiExisteID(1));
		System.out.println("Prueba: Listar todos los empleados, devuelve total");
		new testerEmpleados().testerTodos();
		System.out.println("Prueba: Listar todos los empleados activos, devuelve total");
		new testerEmpleados().testerTodosActivos();
		
	}
	
	private void testerTodosActivos() {

			modEmpleado empleados[]=new modEmpleado().getTablaConTodosLosEmpleadosActivos();
			System.out.println("Cantidad de empleados activos: "+empleados.length);
				
	}

	public void   testerTodos() {
		modEmpleado empleados[]=new modEmpleado().getTablaConTodosLosEmpleados();
		System.out.println("Cantidad de empleados: "+empleados.length);
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
