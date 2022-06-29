package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.modConexion;
import empresas.IDAOEmpresas;
import varios.Constantes;

public class ImpleIDAOClientesOnLine implements IDAOEmpresas {
	
	private String nombreBD=Constantes.NOMBRE_BD_ONLINE;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	
	private Connection conexion;
	
	@Override
	public boolean verificaSiExistePorID(String ID) {
		
		if(ID==null || ID.isEmpty())
			return false;
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM clientes WHERE idsole=?";

		try {
			
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, ID.trim());
			rs=ps.executeQuery();

			if(rs.next()) {				

				return true;
			
			}else {

				return false;
			
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return false;
	
		}finally {
			
			try {
				
				if(getConexion() != null) {
					getConexion().close();
					conexion=null;
				}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public Object[] getTodasLasEmpresas() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Object getEmpresasPorID(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getEmpresasPorCUIT(long CUIT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEmpresasPorCodPostal(String codPostal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getEmpresasPorProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getEmpresasPorPais(String pais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altaEmpresa(Object empresa) {
		// TODO Auto-generated method stub
		return false;
	}


	private Connection getConexion() {
		if(this.conexion==null) 
			setConexion();
		
		return conexion;
	}
	
	private void setConexion() {

		this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
			
	}

	@Override
	public boolean actualizaEmpresa(Object empresa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificaSiExistePorRazonSocial(String razonSocial) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getEmpresasPorRazonSocial(String razonSocial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getTodasLasEmpresasActivas(boolean activa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getTodasLasEmpresasBloqueadas(boolean bloqueo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bajaEmpresa(Object empresa) {
		// TODO Auto-generated method stub
		return false;
	}

}
