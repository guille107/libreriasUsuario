package conexiones.iguSolicitaDatosDeConexion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TodasLasEtiquetas {
	
	public JLabel lblTitulo=new JLabel("<html><body><h1>Error en archivo de Datos.</h1> Ingreso Manual </body></html>");
	public JLabel lblServidor=new JLabel("SERVIDOR");
	public JLabel lblPuerto=new JLabel("PUERTO");
	public JLabel lblUsuario=new JLabel("USUARIO");
	public JLabel lblClave=new JLabel("CLAVE");
	public JLabel lblBaseDeDatos=new JLabel("BASE DE DATOS");
	
	public TodasLasEtiquetas(){
		
		lblTitulo.setFont(new Font("Tahoma",Font.PLAIN,25));
		lblTitulo.setForeground(new Color(52,83,108));
	        
		lblServidor.setFont(new Font("Tahoma",Font.BOLD,15));
		lblServidor.setForeground(new Color(61,147,239));
	        
		lblPuerto.setFont(new Font("Tahoma",Font.BOLD,15));
		lblPuerto.setForeground(new Color(61,147,239));
	        
		lblUsuario.setFont(new Font("Tahoma",Font.BOLD,15));
		lblUsuario.setForeground(new Color(61,147,239));
	        
		lblClave.setFont(new Font("Tahoma",Font.BOLD,15));
		lblClave.setForeground(new Color(61,147,239));
	        
		lblBaseDeDatos.setFont(new Font("Tahoma",Font.BOLD,15));
		lblBaseDeDatos.setForeground(new Color(61,147,239));
	}
}
