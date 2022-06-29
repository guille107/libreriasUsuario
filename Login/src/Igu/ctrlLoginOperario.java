package Igu;

import empleados.modEmpleado;

public class ctrlLoginOperario {
	private String usuario;
	private String password;
	private String Titulo;
	private String txtPie;

	modEmpleado empleado=new modEmpleado();

	
	public ctrlLoginOperario() {
		this("Talleres Fumaca","Ingrese Usuario y Contraseña");
	}
	public ctrlLoginOperario(String titulo) {
		this(titulo,"Ingrese Usuario y Contraseña");
		
	}
	public ctrlLoginOperario(String titulo, String pie) {
		this.Titulo=titulo;
		this.txtPie=pie;
		iguLogin igu=new iguLogin("Talleres Fumaca","Ingrese Usuario y Contraseña");
	}

	public modEmpleado verificaUsuario(String usuario) {
		
		if(empleado.buscarXDNI(usuario)) {

			return empleado;
		}else {
			if(empleado.buscaXDescripcion(usuario)) {

				return empleado;
			}
		}
		System.out.println("EMPLEADO NO ENCONTRADO");
		return empleado;
	}

	public void empleadoAprobado() {
		
	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	/*public boolean clickEnIngreso(String usuario, String password2) {
		
		if(verificaUsuario(usuario) != null){

			if(empleado.isActivo()) {
				
				if(verificaClave(password2)) {

					return true;
				}
			}
		}
		return false;
	}

	private boolean verificaClave(String password2) {

		if(modEmpleado.equals(password2)) {
			
			return true;
		}

		return false;
	}*/
		
}
