package testers;

import java.sql.Connection;

import conexiones.modConexion;

public class textConexionManual {

	public static void main(String[] args) {
		modConexion coneRemota=new modConexion();
		coneRemota.setBaseDatos("gcardill_tfonline");
		coneRemota.setClave("Tafupanl$$TW2021 ");
		coneRemota.setDriver("com.mysql.jdbc.Driver");
		coneRemota.setHostname("200.80.43.56");
		coneRemota.setUsuario("gcardill");
		coneRemota.setPuerto("3306");
		
		Connection cone =new modConexion().conectar(coneRemota);
		
		modConexion conePrueba = new modConexion();
		conePrueba.setBaseDatos("tafucomercial");
		conePrueba.setClave("tafuMySQL1965");
		conePrueba.setDriver("com.mysql.jdbc.Driver");
		conePrueba.setHostname("192.168.10.7");
		conePrueba.setUsuario("bdtafu");
		conePrueba.setPuerto("3306");
		
		//Connection cone = new modConexion().conectar(conePrueba);
		System.out.println(cone.toString());
	}

}
