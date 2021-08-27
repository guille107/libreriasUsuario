package testers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.modConexion;

public class testModConexion {

	public static void main(String[] args) {
		Connection cone=new modConexion("tafubd","U:\\LibreriasDeUsuarios\\Conexiones\\BDs.conf").getConexion();
		
		String sql="SELECT * FROM articulos";
		try {
			
			ResultSet rs=cone.prepareStatement(sql).executeQuery();

			while(rs.next()) {
				System.out.println(rs.getString(2));
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

}
