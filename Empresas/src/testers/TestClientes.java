package testers;


import java.util.Scanner;

import modelos.modCliente;

public class TestClientes {
	static modCliente clienteNuevo;

	public static void main(String[] args) {
		 try (Scanner teclado = new Scanner(System.in)) {
			int op1 = 0;

			    System.out.println("Elija una opción de testeo: ");

				System.out.println("1 - Verifica si existe por ID");
				System.out.println("2 - Verifica si existe por Razon Social");
				System.out.println("3 - Devuelve objeto modCliente instanciado por idEmpresa");
				System.out.println("4 - Devuelve lista de todos los modClientes en la BBDD");
				System.out.println("5 - Lista de empresas activas o no activas");
				System.out.println("6 - Lista de empresas bloqueadas o no bloqueadas");
				System.out.println("7 - Devuelve objeto modCliente instanciado por CUIT");
				System.out.println("8 - Devuelve lista de todos los modClientes por provincia");
				System.out.println("9 - Fin de la compra y total");


			    while( op1 < 9) {
			    	op1 = Integer.parseInt(teclado.next());
			    
			    	switch (op1){
			    		case 1:
			    			veriSiExistePorID();
			    			break;
			    		case 2:
			    			veriSiExistePorRazonSocial();
			    			break;
			    		case 3:
			    			devuelveObjetoDesdeIDEmpresa();
			    			break;
			    		case 4:
			    			devuelveListaDeTodosLosmodClientes();
			    			break;
			    		case 5:
			    			devuelveListaDeTodosLosmodClientesActivosEInactivos();
			    			break;	
			    		case 6:
			    			devuelveListaDeTodosLosmodClientesBloqueadosYNoBloqueados();
			    			break;	
			    		case 7:
			    			devuelveObjetoDesdeCUIT();
			    			break;	
			    		case 8:
			    			devuelveListaDeTodosLosmodClientesPorProvincia();
			    			break;	

			    		default:
			    			break;
			    	}	
			    }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private static void devuelveListaDeTodosLosmodClientesPorProvincia() {
		
		String provi = "SALTA";
		modCliente[] listaCliente = (modCliente[]) new modCliente().listaDeEmpresasPorProvincias(provi);
		if(listaCliente != null)
			for(modCliente lista:listaCliente)
			 System.out.println("Cliente de la provincia " + provi + ": " + lista.getRazonSocial());
		System.out.println("********************************");
		System.out.println();	
		
	}

	private static void devuelveObjetoDesdeCUIT() {
		
		System.out.println("TESTER: Devuelve objeto modCliente instanciado por CUIT");
		System.out.println("============================================================");
		System.out.println("Busca por ID y devuelve Objeto 20041557053 (Valor verdadero):  ");
		modCliente cliente = (modCliente) new modCliente().buscaXCUITYDevuelveElObjetoEncontrado(20041557053L);
		System.out.println("Cliente: " + cliente.getRazonSocial());
		System.out.println("--------------------------------");
		
		System.out.println("Busca por ID y devuelve Objeto 6654585 (Valor falso):  ");
		cliente = (modCliente) new modCliente().buscaXCUITYDevuelveElObjetoEncontrado(6654585L);
		if(cliente != null)
			System.out.println("Cliente: " + cliente.getRazonSocial());
		else
			System.out.println("No se encontró el cliente ddee");
		System.out.println("--------------------------------");
		System.out.println("Busca por ID mayor a 11 caracteres (Valor falso):  ");
		cliente = (modCliente) new modCliente().buscaXCUITYDevuelveElObjetoEncontrado(30663022343245649L);
		if(cliente != null)
			System.out.println("Cliente: " + cliente.getRazonSocial());
		else
			System.out.println("No se encontró el cliente 30663022343245649");

		System.out.println("********************************");
		System.out.println();
				
	}

	private static void devuelveListaDeTodosLosmodClientesBloqueadosYNoBloqueados() {
		modCliente[] listaCliente = (modCliente[]) new modCliente().listaDeEmpresasBloqueadosONoBloqueados(true);
		if(listaCliente != null)
			 System.out.println("Cantidad de clientes Bloqueados: " + listaCliente.length);
		System.out.println("********************************");
		System.out.println();		
		
		listaCliente = (modCliente[]) new modCliente().listaDeEmpresasBloqueadosONoBloqueados(false);
		if(listaCliente != null)
			 System.out.println("Cantidad de clientes NO Bloqueados: " + listaCliente.length);
		System.out.println("********************************");
		System.out.println();			
	}

	private static void devuelveListaDeTodosLosmodClientesActivosEInactivos() {
		
		modCliente[] listaCliente = (modCliente[]) new modCliente().listaDeEmpresasActivasONoActivas(true);
		if(listaCliente != null)
			 System.out.println("Cantidad de clientes Activos: " + listaCliente.length);
		System.out.println("********************************");
		System.out.println();		
		
		listaCliente = (modCliente[]) new modCliente().listaDeEmpresasActivasONoActivas(false);
		if(listaCliente != null)
			 System.out.println("Cantidad de clientes NO Activos: " + listaCliente.length);
		System.out.println("********************************");
		System.out.println();	
		
	}

	private static void devuelveListaDeTodosLosmodClientes() {
		
		modCliente[] listaCliente = (modCliente[]) new modCliente().listaDeTodos();
		if(listaCliente != null)
			 System.out.println("Cantidad de clientes en la lista: " + listaCliente.length);
		System.out.println("********************************");
		System.out.println();		
	}

	private static void devuelveObjetoDesdeIDEmpresa() {
		
		System.out.println("TESTER: Devuelve objeto modCliente instanciado por idEmpresa");
		System.out.println("============================================================");
		System.out.println("Busca por ID y devuelve Objeto 0001 (Valor verdadero):  ");
		modCliente cliente = (modCliente) new modCliente().buscaXIDYDevuelveElObjetoEncontrado("0001");
		System.out.println("Cliente: " + cliente.getRazonSocial());
		System.out.println("--------------------------------");
		
		System.out.println("Busca por ID y devuelve Objeto ddee (Valor falso):  ");
		cliente = (modCliente) new modCliente().buscaXIDYDevuelveElObjetoEncontrado("ddee");
		if(cliente != null)
			System.out.println("Cliente: " + cliente.getRazonSocial());
		else
			System.out.println("No se encontró el cliente ddee");
		System.out.println("--------------------------------");
		System.out.println("Busca por ID mayor a 4 caracteres (Valor falso):  ");
		cliente = (modCliente) new modCliente().buscaXIDYDevuelveElObjetoEncontrado("00001");
		if(cliente != null)
			System.out.println("Cliente: " + cliente.getRazonSocial());
		else
			System.out.println("No se encontró el cliente 00001");

		System.out.println("********************************");
		System.out.println();
		
	}

	private static void veriSiExistePorID() {
		
		System.out.println("TESTER: Verifica si existe por ID");
		System.out.println("==================================");
		modCliente cliente = new modCliente();	
		System.out.println("Verifica si existe 0001 (Valor verdadero):  " + cliente.verificaSiExisteID("0001"));
		System.out.println("Verifica si existe ddee (Valor falso):  " + cliente.verificaSiExisteID("ddee"));
		System.out.println("Verifica si existe nulo:  " + cliente.verificaSiExisteID(null));
		System.out.println("********************************");
		System.out.println();
	}
	private static void veriSiExistePorRazonSocial() {
		
		System.out.println("TESTER: Verifica si existe por RAZON SOCIAL");
		System.out.println("==================================");
		modCliente cliente = new modCliente();	
		System.out.println("Verifica si existe por razon social LAMARINA S.A. (Valor verdadero):  " + cliente.verificaSiExisteRazonSocial("LAMARINA S.A."));
		System.out.println("Verifica si existe por razon social ddee (Valor falso):  " + cliente.verificaSiExisteRazonSocial("ddee"));
		System.out.println("Verifica si existe nulo:  " + cliente.verificaSiExisteRazonSocial(null));
		System.out.println("********************************");
		System.out.println();
	}

}
