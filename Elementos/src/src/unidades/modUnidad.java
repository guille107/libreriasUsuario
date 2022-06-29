package unidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.modConexion;
import varios.Constantes;

public class modUnidad {
	private int idUnidad;
	private String Unidad;
	private String nombreBD=Constantes.NOMBRE_BD_TAFU;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;

	public modUnidad() {
	}
	
	public modUnidad(int idUnidad) {
		
		buscaUnidadXID(idUnidad);
		
	}
	
	public modUnidad(int idUni, String unidad) {
		
		this.idUnidad = idUni;
		this.Unidad = unidad;
		
	}

	public modUnidad[] todasLasUnidades() {

		modUnidad[] todasLasUnidades=null;
    	String sql = "SELECT * FROM unidades";
    	
    	modUnidad[] temp=new modUnidad[1];
		ArrayList<modUnidad> listaUnidad = new ArrayList<modUnidad>(1);
		
        try {
        	
    		ResultSet rs=getConexion().prepareStatement(sql).executeQuery();
            
            while (rs.next()) {

            	listaUnidad.add(new modUnidad(rs.getInt(1),rs.getString(2)));
            	
            }
            
            if (listaUnidad.size() > 0) {
            	
            	todasLasUnidades =  listaUnidad.toArray(temp);
                
            } else {
            	
            	todasLasUnidades = null;
                
            }
            
        } catch (SQLException e) {
        	
        	todasLasUnidades = null;
            e.toString();
            
        }finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return todasLasUnidades;
		
	}

	public modUnidad buscaUnidadXID(int IDRecibido) {

		PreparedStatement ps=null;

		ResultSet rs=null;
	
		String sql="SELECT * FROM unidades WHERE  idunidad=?";
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setInt(1, IDRecibido);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setIdUnidad(IDRecibido);
				setUnidad(rs.getString(2));
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
	
	public modUnidad buscaXUnidad(String strUnidad) {
		modUnidad unidad=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM unidades WHERE unidad=?";
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, strUnidad.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				unidad=new modUnidad(rs.getInt(1),rs.getString(2));
			
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return unidad;
	}
	
	private Connection getConexion() {
		if(this.conexion==null) 
			setConexion();
		
		return conexion;
	}
	
	private void setConexion() {

			this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
	}
	
	public int getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
		
	}
	public String getUnidad() {
		return Unidad;
	}
	public void setUnidad(String unidad) {
		Unidad = unidad;
	}	
	@Override
	public String toString() {
		return "modUnidad [idUnidad=" + getIdUnidad() + ", Unidad=" + getUnidad() + "]";
	}

	
	
}
