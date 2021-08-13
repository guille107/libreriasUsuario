package unidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.modConexion;

public class modUnidad {
	private int idUnidad;
	private String Unidad;

	public modUnidad() {
		// TODO Auto-generated constructor stub
	}
	
	public modUnidad(int idUnidad) {
		
		buscaUnidadXID(idUnidad);
		
	}
	
	public modUnidad(int idUnidad, String unidad) {
		
		this.idUnidad = idUnidad;
		Unidad = unidad;
		
	}

	public modUnidad[] todasLasUnidades() {
		modUnidad[] todasLasUnidades=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		modConexion conexion=new modConexion("tafubd","U:\\LibreriasDeUsuarios\\Conexiones\\BDs.conf");
		
		
		modUnidad[] temp=new modUnidad[1];
		ArrayList<modUnidad> listaUnidad = new ArrayList<modUnidad>(1);
		
        try {
        	String sql = "SELECT * FROM unidades";
        	ps=((Connection) conexion).prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
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
				if(conexion != null)
					((Connection) conexion).close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return todasLasUnidades;
		
	}

	public modUnidad buscaUnidadXID(int texto) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		modConexion conexion=new modConexion("tafubd","BDs.conf");

		
		String sql="SELECT * FROM unidades WHERE  idunidad=?";
		try {
			ps=((Connection) conexion).prepareStatement(sql);
			ps.setInt(1, texto);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setIdUnidad(texto);
				setUnidad(rs.getString(2));
				return this;
			}
			return null;
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return null;
		
		}finally {
			try {
				if(conexion != null)
					conexion.cerrar();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public modUnidad buscaXUnidad(String strUnidad) {
		modUnidad unidad=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		modConexion conexion=new modConexion("tafubd","BDs.conf");

		
		String sql="SELECT * FROM unidades WHERE unidad=?";
		try {
			ps=((Connection) conexion).prepareStatement(sql);
			ps.setString(1, strUnidad.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				unidad=new modUnidad(rs.getInt(1),rs.getString(2));
			
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
				if(conexion != null)
					conexion.cerrar();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return unidad;
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
