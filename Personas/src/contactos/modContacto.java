package contactos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.modConexion;
import personas.ImpleIPersonas;
import tablas.modCargo;
import varios.Constantes;

public class modContacto extends ImpleIPersonas{
	private String mailLaboral;
	private modCargo cargo;
	private Connection conexion;
	private String nombreBD=Constantes.NOMBRE_BD_TAFU;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	
	
	@Override
	public modContacto buscaXIDYDevuelveElObjetoEncontrado(int idParametro) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM contactos WHERE  idcontactos=?";
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setInt(1, idParametro);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setIdPersona(idParametro);
				setActivo(rs.getBoolean(2));
				setNombre(rs.getString(3));
				setApellido(rs.getString(4));
				setDNI(rs.getInt(5));				
				setDireccion(rs.getString(6), rs.getString(7), rs.getString(8));
				return this;
			}
			return null;
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return null;
		
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	


	@Override
	public modContacto buscaXNombre(String texto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public modContacto buscaXidProveedor(String texto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public modContacto buscarXDNI(String texto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public modContacto buscarXCUIT(String texto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public modContacto[] listaDeTodos(String cadena) {
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
	@Override
	public boolean verificaSiExisteID(int texto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object creaObjetoConRS(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getMailLaboral() {
		return mailLaboral;
	}
	public void setMailLaboral(String mailLaboral) {
		this.mailLaboral = mailLaboral;
	}
	public modCargo getCargo() {
		return cargo;
	}
	public void setCargo(modCargo cargo) {
		this.cargo = cargo;
	}
private Connection getConexion() {
	if(this.conexion == null) {
		setConexion();
	}
	return conexion;
}
private void setConexion() {

	this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
}


}
