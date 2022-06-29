package rubros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.modConexion;
import varios.Constantes;


public class modRubroEmpresa {
	private String idRubro;
	private String Rubro;
	
	private String nombreBD=Constantes.NOMBRE_BD_TAFU;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;
	
	public modRubroEmpresa() {
		
	}
	public modRubroEmpresa(String id, String rubro) {
		this.idRubro=id;
		this.Rubro=rubro;
		
	}
	
	public modRubroEmpresa[] todosLosRubros() {
		
		modRubroEmpresa[] todosLosRubros = null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		modRubroEmpresa[] temp=new modRubroEmpresa[1];
		ArrayList<modRubroEmpresa> listaRubro = new ArrayList<modRubroEmpresa>(1);


    	
        try {
        	
        	String sql = "SELECT * FROM rubrosEmp";
        	ps=getConexion().prepareStatement(sql);
            rs = ps.executeQuery(sql);

            while (rs.next()) {
  	
            	listaRubro.add(new modRubroEmpresa(rs.getString(1),rs.getString(2)));
            	
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

	public modRubroEmpresa buscaRubroXID(String texto) {

		PreparedStatement ps=null;
		ResultSet rs=null;
	
			String sql="SELECT * FROM rubrosEmp WHERE idrubro=?";
			
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, texto.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setIdRubro(texto);
				setRubro(rs.getString(2));
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

	@Override
	public String toString() {
		return "modRubro [idRubro=" + idRubro + ", Rubro=" + Rubro + ", SubRubro=" + "]";
	}
}
