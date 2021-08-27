package personas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ctrlConexiones.CTRLConexiones;
import geo.modDireccion;
import modConexion.modConexion;
import varios.Constantes;


public class ImpleIPersonas implements IPersonas {

	private boolean activo;
	private String idPersona;
	private int DNI;
	private int CUIL;
	private String nombre;
	private String apellido;
	private modDireccion direccion;
	private String telPersonal;
	private String celular;
	private String mailPersonal;
	private String mailLaboral;
	
	private boolean activarConexion() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Connection conexion=new modConexion().conectar(new CTRLConexiones(Constantes.baseEmpleados).getModCon());

		
	}
	
	@Override
	public boolean buscaXID(String ID) {
		
		if(activarConexion()) {
			
		}
		return false;
	}
	@Override
	public boolean buscaXDescripcion(String texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean buscaXidProveedor(String texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] listaDeTodos(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean altaElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean bajaElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modiElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void deRSASetters(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ResultSet deObjetoABBDD(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}
		


}
