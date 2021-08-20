package rubros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.modConexion;
import varios.Constantes;

public class modRubros {
	private String idRubro;
	private String Rubro;
	private String SubRubro;
	
	private String nombreBD=Constantes.NOMBRE_BD;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;
	
	public modRubros() {
		
	}

	
	public modRubros(String idRubro) {
		super();
		this.idRubro = idRubro;
	}

	public modRubros(String id, String rubro, String subrubro) {
		this.idRubro=id;
		this.Rubro=rubro;
		this.SubRubro=subrubro;
		
	}


	public modRubros[] todosLosRubros() {
		modRubros[] todosLosRubros=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		modRubros[] temp=new modRubros[1];
		ArrayList<modRubros> listaRubro = new ArrayList<modRubros>(1);
		
        try {
        	String sql = "SELECT * FROM rubros";
        	ps=getConexion().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
  	
            	listaRubro.add(new modRubros(rs.getString(1),rs.getString(2),rs.getString(3)));
            	
            }
            
            if (listaRubro.size() > 0) {
            	
            	todosLosRubros =  listaRubro.toArray(temp);
                
            } else {
            	
            	todosLosRubros = null;
                
            }
            
        } catch (SQLException e) {
        	
        	todosLosRubros = null;
            e.toString();
            
        }finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return todosLosRubros;
		
	}

	public modRubros buscaRubroXID(String texto) {

		PreparedStatement ps=null;
		ResultSet rs=null;
	
			String sql="SELECT * FROM rubros WHERE  idrubrosub=?";
			
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, texto.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setIdRubro(texto);
				setRubro(rs.getString(2));
				setSubRubro(rs.getString(3));
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
	public String getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(String idRubro) {
		this.idRubro = idRubro;
	}

	public String getRubro() {
		return Rubro;
	}

	public void setRubro(String rubro) {
		Rubro = rubro;
	}

	public String getSubRubro() {
		return SubRubro;
	}

	public void setSubRubro(String subRubro) {
		SubRubro = subRubro;
	}

	@Override
	public String toString() {
		return "modRubro [idRubro=" + idRubro + ", Rubro=" + Rubro + ", SubRubro=" + SubRubro + "]";
	}
	
}
