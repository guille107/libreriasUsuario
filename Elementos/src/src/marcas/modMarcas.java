package marcas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.modConexion;
import varios.Constantes;

public class modMarcas {
	private int idMarca;
	private String Marca;
	private String nombreBD=Constantes.NOMBRE_BD_TAFU;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;
	
	public modMarcas() {
		
	}
	public modMarcas(int idMarca) {
		
		buscaMarcaXID(idMarca);
		
	}
	
	public modMarcas(int idMarca, String marca) {
		super();
		this.idMarca = idMarca;
		Marca = marca;

	}

	public modMarcas[] todasLasMarcas() {
		modMarcas[] todasLasMarcas=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		modMarcas[] temp=new modMarcas[1];
		ArrayList<modMarcas> listaMarca = new ArrayList<modMarcas>(1);
		
        try {
        	String sql = "SELECT * FROM marcas";
        	ps=getConexion().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {

            	listaMarca.add(new modMarcas(rs.getInt(1),rs.getString(2)));
            	
            }
            
            if (listaMarca.size() > 0) {
            	
            	todasLasMarcas =  listaMarca.toArray(temp);
                
            } else {
            	
            	todasLasMarcas = null;
                
            }
            
        } catch (SQLException e) {
        	
        	todasLasMarcas = null;
            e.toString();
            
        }finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return todasLasMarcas;
		
	}
	public modMarcas buscaMarcaXID(int texto) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM marcas WHERE  idmarca=?";
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setInt(1, texto);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setIdMarca(texto);
				setMarca(rs.getString(2));
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
	
	private Connection getConexion() {
		if(this.conexion==null) 
			setConexion();
		
		return conexion;
	}
	
	private void setConexion() {

			this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
	}
	
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}	
	
	public modMarcas buscaXMarca(String strMarca) {
		modMarcas marca=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM marcas WHERE marca=?";
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, strMarca.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				marca=new modMarcas(rs.getInt(1),rs.getString(2));
			
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
		
		return marca;
	}
	
	@Override
	public String toString() {
		return "modMarca [idMarca=" + idMarca + ", Marca=" + Marca + "]";
	}
	
	
}
