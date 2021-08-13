package conexiones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * RUTINA DE CONEXION (07-2021)
 * Connection conexion=new modConexion().conectar(new CTRLConexiones(Constantes.baseTaFu).getModCon());
 * Debe estar cargada la constante con el nombre de la base de datos en la clase Constantes.
 * Deben estar cargados los datos de la conexion en BDs.conf, sino se debe conectar manualmente.
 */

public class modConexion {
	
	private String driver= "com.mysql.jdbc.Driver";
  	private String servidor;
  	private String puerto;
  	private String usuario;
  	private String clave;
  	private String BaseDatos;
	private	Connection conn=null;
	
	public modConexion() {
		
	}
	public modConexion(String nombreBD,String nombreFilaConDatosDeConexion) {
		this.BaseDatos=nombreBD;
		
		conectar(new crearModConexionDesdeDatosEnTXT(nombreBD,nombreFilaConDatosDeConexion).getModCon());
	}

  	public  Connection conectar(modConexion datosConexion) {

  	   	String url= "jdbc:mysql://" + datosConexion.getHostname() + ":" + datosConexion.getPuerto() + "/" 
  	    	   	+ datosConexion.getBaseDatos() + "?useSSL=false";
  	
    	try {  		
    		conn = DriverManager.getConnection(url, datosConexion.getUsuario(), datosConexion.getClave());
        } catch (SQLException e) {
        	
			JOptionPane.showMessageDialog(null, "NO SE PUEDE CONECTAR A LA BASE DE DATOS "+ this.BaseDatos + " - SALIENDO DEL SISTEMA");
			System.exit(0);
        }
  		 		
  		return conn;
  	}

  		
  	
    public void setConexion(Connection conn2) {
		this.conn=conn2;
		
	}
    public Connection getConexion() {
    	return conn;
    }

	public void cerrar() throws SQLException {
    	if (conn != null) {
    		conn.close();
    	}
   }
      
	/// GETTERS Y SETTERS
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getHostname() {
		return servidor;
	}
	public void setHostname(String hostname) {
		this.servidor = hostname;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String port) {
		this.puerto = port;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String username) {
		this.usuario = username;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String password) {
		this.clave = password;
	}

	public String getBaseDatos() {
		return BaseDatos;
	}

	public void setBaseDatos(String baseDatos) {
		BaseDatos = baseDatos;
	}
	@Override
	public String toString() {
		return "modConexion [hostName=" + servidor + ", puerto=" + puerto + ", usuario=" + usuario + ", clave=" + clave
				+ ", BaseDatos=" + BaseDatos + "]";
	}
}
