package testers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import conexiones.modConexion;

public class testCUITLONG {

	private static Connection conexion;
	public static final String digits = "0123456789";

    
	public static void main(String[] args) {

		
	    Connection cone=new modConexion("test","U:\\LibreriasDeUsuarios\\Conexiones\\BDs.conf").getConexion();
		
		String sql="INSERT INTO cuitlong (CUIT) VALUES (?) ";

		
		PreparedStatement ps;
		try {
			ps = getConexion().prepareStatement(sql);
			
			Random r = new Random();
			
			int a=0;
			while(a<1000) {
				long CUIT=(long) (300000000+r.nextDouble()*999999999*100); 
				++a;
				ps.setLong(1, CUIT);
				ps.execute();
			
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql1="SELECT * FROM cuitlong";
		try {
			
			ResultSet rs=cone.prepareStatement(sql1).executeQuery();

			while(rs.next()) {
				System.out.println(rs.getLong(1));
			}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();


		
		}finally {
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
