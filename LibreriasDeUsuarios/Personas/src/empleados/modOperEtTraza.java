package empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import articulos.marcas.modMarca;
import ctrlConexiones.CTRLConexiones;
import modConexion.modConexion;
import personas.ImpleIPersonas;
import varios.Constantes;

public class modOperEtTraza extends ImpleIPersonas{
	private int cantAccesos;
	
	public modOperEtTraza() {
		
	}
	
	public modOperEtTraza(String id) {
		this.setIdPersona(id);
		buscaXID(getIdPersona());		
	}
	
	public modOperEtTraza(boolean esActivo, String idPersona, String nombre, String apellido,  int cantAccesos) {
		setActivo(esActivo);
		setIdPersona(idPersona);
		setNombre(nombre);
		setApellido(apellido);
		setCantAccesos(cantAccesos);
	}

	@Override
	public modOperEtTraza buscaXID(String texto) {
		PreparedStatement ps=null;
		ResultSet rs=null;
	
			Connection conexion=new modConexion().conectar(new CTRLConexiones(Constantes.baseEtTraza).getModCon());
			String sql="SELECT * FROM operarios WHERE  id=?";
			
		try {
			ps=conexion.prepareStatement(sql);
			ps.setString(1, texto.trim());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				setActivo(rs.getBoolean(1));
				setIdPersona(texto.trim());
				setNombre(rs.getString(3));
				setApellido(rs.getString(4));
				setCantAccesos(rs.getInt(5));			
				return this;
			}
			return null;
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return null;
		
		}finally {
			try {
				if(conexion != null)
				conexion.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public modOperEtTraza[] obtenerListaDeTodosLosEmpleados() {
		
		modOperEtTraza[] todasLosOper=null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Connection conexion=new modConexion().conectar(new CTRLConexiones(Constantes.baseEtTraza).getModCon());
		
		modOperEtTraza[] temp=new modOperEtTraza[1];
		ArrayList<modOperEtTraza> listaOper = new ArrayList<modOperEtTraza>(1);

        try {
        	String sql = "SELECT * FROM operarios";
        	ps=conexion.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            while (rs.next()) {

            	listaOper.add(new modOperEtTraza(rs.getBoolean(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));

            }
            
            if (listaOper.size() > 0) {
            	
            	todasLosOper =  listaOper.toArray(temp);
                
            } else {
            	
            	todasLosOper = null;
                
            }
            
        } catch (SQLException e) {
        	
        	todasLosOper = null;
            e.toString();
            
        }finally {
			try {
				if(conexion != null)
					conexion.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
      
		return todasLosOper;
	}
	public int getCantAccesos() {
		return cantAccesos;
	}
	public void setCantAccesos(int cantAccesos) {
		this.cantAccesos = cantAccesos;
	}

	@Override
	public String toString() {
		return "modOperEtTraza [cantAccesos=" + cantAccesos + ", getIdPersona()=" + getIdPersona() + ", getNombre()="
				+ getNombre() + ", getApellido()=" + getApellido() + ", isActivo()=" + isActivo() + "]";
	}


	
}
