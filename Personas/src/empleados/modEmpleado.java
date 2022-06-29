package empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.modConexion;
import direccion.modDireccion;
import personas.ImpleIPersonas;
import varios.Constantes;

public class modEmpleado extends ImpleIPersonas{

	private String nombreBD = "";
	private String archivoDeConfiguracionBD = Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;
	
	private String Clave;
	private String Email;

	public modEmpleado() {
		
	}
	public modEmpleado(ResultSet rs) {
		deRsASetters(rs);
	}


	@Override
	public boolean verificaSiExisteID(int idEmpleado) {
		if(idEmpleado == 0)
			return false;
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM empleados WHERE id=?";

		try {
		
			ps = getConexion().prepareStatement(sql);
			ps.setInt(1, idEmpleado);
			rs = ps.executeQuery();

			if(rs.next()) {				
				creaObjetoConRS(rs);
				return true;
			
			}else {

				return false;
			
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return false;
	
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
	public modEmpleado buscaXIDYDevuelveElObjetoEncontrado(int ID) {
		
		modEmpleado empleadoEncontrado=null;
		setIdPersona(ID);
	
	
		if(!verificaSiExisteID(ID)) {
			return empleadoEncontrado;
		}
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM empleados WHERE id=?";

		try {

			ps=getConexion().prepareStatement(sql);
			ps.setInt(1, getIdPersona());
			rs=ps.executeQuery();
	
			if(rs.next()) {				
				empleadoEncontrado=creaObjetoConRS(rs);	
				
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
		
		return empleadoEncontrado;
	}
	private void deRsASetters(ResultSet rs) {
		
		try {
			setActivo(rs.getBoolean(1));
			setIdPersona(rs.getInt(2));
			setDNI(rs.getInt(3));
			setCUIL(rs.getInt(4));
			setNombre(rs.getString(5));
			setApellido(rs.getString(6));
			setClave(rs.getString(7));
			setEmail(rs.getString(8));
			//setEti
			//setacctsocont
			//setnombrecorto
			//settipo
			//setcantimpre

		} catch (SQLException e) {
			System.out.println("No pudo setear las variables desde el ResulSet");
			e.printStackTrace();
		}
		
	}
	@Override
	public modEmpleado creaObjetoConRS(ResultSet rs) {

		try {
			setActivo(rs.getBoolean(1));
			setIdPersona(rs.getInt(2));
			setDNI(rs.getInt(3));
			setCUIL(rs.getInt(4));
			setNombre(rs.getString(5));
			setApellido(rs.getString(6));		
			setClave(rs.getString(7));		
			setEmail(rs.getString(8));
			
			modDireccion direccion=new modDireccion(rs.getString(9),rs.getString(10),rs.getString(11));
	
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return this;
				
	}
	
	private modEmpleado[] generarTablaConTodosLosEmpleados(String TodosOActivos) {

		String todosOActivos=TodosOActivos;

		modEmpleado[] todosLosEmpleados=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql = null;

		
		modEmpleado[] temp=new modEmpleado[1];
		ArrayList<modEmpleado> listaEmpleados = new ArrayList<modEmpleado>(1);

		if(todosOActivos=="TODOS") 
			sql = "SELECT * FROM empleados";
		if(todosOActivos=="ACTIVOS") 
			sql = "SELECT * FROM empleados where activo=1";
		if(todosOActivos=="ETIQUETRAZA")
			sql = "SELECT * FROM empleados where accEtiqueTraza>0 and activo=1";
		
    	try {
    		
    		ps=getConexion().prepareStatement(sql);
        	rs = ps.executeQuery(sql);
        	
        	while (rs.next()) {
        		listaEmpleados.add(new modEmpleado(rs));

        	}
        
        	if (listaEmpleados.size() > 0) {
        	
        	todosLosEmpleados =  listaEmpleados.toArray(temp);
            
        	} else {
        	
        		todosLosEmpleados = null;
            
        }
        
    	} catch (SQLException e) {
    	
    		todosLosEmpleados = null;
        	e.toString();
        
    	}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
		return todosLosEmpleados;
	}
	public modEmpleado[] getTablaConTodosLosEmpleadosConAccesoAEtiqueTraza() {
		
		return generarTablaConTodosLosEmpleados("ETIQUETRAZA");
		
	}
	
	public modEmpleado[] getTablaConTodosLosEmpleadosActivos() {
		
		return generarTablaConTodosLosEmpleados("ACTIVOS");

	}
	
	public modEmpleado[] getTablaConTodosLosEmpleados() {
		
		return generarTablaConTodosLosEmpleados("TODOS");

	}
	
	public String getEmail() {
		
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	private Connection getConexion() {
		try {
			if(this.conexion == null||this.conexion.isClosed()) 
				setConexion();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conexion;
	}
	
	private void setConexion() {
		this.conexion = new modConexion(Constantes.NOMBRE_BD_TAFU,archivoDeConfiguracionBD).getConexion();
	}

	
}
