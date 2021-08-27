package direccion;

import java.io.IOException;

import conexiones.modConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class modLocaliProvi {
	private String idLocalProvi;
	private String provincia;
	private String Localidad;
	private Connection conexion;
	
	private String nombreBD=Constantes.NOMBRE_BD;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	
	public modLocaliProvi(String ID) {
		
		if(extisteID(ID)) {
			setIdLocalProvi(ID);
		}else {
			sinDatos(ID);
			
		}
	}

	public boolean LocalProvi(String ID) {
		
		if(extisteID(ID)) {
			setIdLocalProvi(ID);
			return true;
		}
		return false;		
	}
	private boolean extisteID(String iD) {
		if(iD==null) 
			return false;

		ResultSet rs=null;
		
		try {
			PreparedStatement ps=getConexion().prepareStatement("SELECT * FROM localprovi WHERE  id=?");
			
			ps.setString(1, iD.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {			
				setProvincia(rs.getString(2));
				setLocalidad(rs.getString(3));
				return true;
			}
			return false;
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(conexion != null)
					conexion.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
		
	private Connection getConexion() {
		try {
			if(this.conexion==null||this.conexion.isClosed()) 
				setConexion();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conexion;
	}
	
	private void setConexion() {

			this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
	}
	public  void sinDatos(String ID) {
		System.out.println("NO EXISTE EL ID "+ID+" EN LA TABLA DE LOCALIDADES Y PROVINCIAS");
		setIdLocalProvi("00_0000");
		extisteID("00_0000");	
	}
	

	public String getIdLocalProvi() {
		return idLocalProvi;
	}
	public void setIdLocalProvi(String idLocalProvi) {
		this.idLocalProvi = idLocalProvi;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	

}
