package testers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexiones.modConexion;

public class testCUITSTRLONG {
	
	private static Connection conexion;
	public static final String digits = "0123456789";

    
	public static void main(String[] args) {

		
	    Connection cone=new modConexion("test","U:\\LibreriasDeUsuarios\\Conexiones\\BDs.conf").getConexion();
		
		String sql="INSERT INTO cuitstring (CUIT) VALUES (?) ";
		
		PreparedStatement ps;
		try {
			ps = getConexion().prepareStatement(sql);
			
			int a=0;
			String CUIT;
			while(a<423) {
				int random = (int) Math.floor(Math.random()*(99-9+1)+9);
				int random2=(int) Math.floor(Math.random()*(100000000-10000000+1)+10000000);
				int random3 = (int) Math.floor(Math.random()*(9-0+1)+0);
				CUIT=String.valueOf(random) + "-" + String.valueOf(random2) + "-" + String.valueOf(random3) ;
				System.out.println(CUIT);

				ps.setString(1, CUIT);
				ps.execute();
				
		    	++a;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if(cone != null)
					cone.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


	private static Connection getConexion() {
		try {
			if(conexion==null||conexion.isClosed()) 
				setConexion();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conexion;
	}
	private static void setConexion() {

		conexion=new modConexion("test","U:\\LibreriasDeUsuarios\\Conexiones\\BDs.conf").getConexion();
}

	

}
