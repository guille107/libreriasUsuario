package conexiones.iguSolicitaDatosDeConexion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class TodosLosTextFields {
	public JTextField txtServidor=new JTextField();
	public JTextField txtPuerto=new JTextField();
	public JTextField txtUsuario=new JTextField();
	public JTextField txtClave=new JTextField();
	public JTextField txtBaseDeDatos=new JTextField();
	
	public TodosLosTextFields() {
		
	       txtServidor.setPreferredSize(new Dimension(140,35));
	       txtServidor.setFont(new Font("Tahoma",Font.PLAIN,20));
	       txtServidor.setForeground(new Color(0,0,102));
	        
	       txtPuerto.setPreferredSize(new Dimension(140,35));
	       txtPuerto.setFont(new Font("Tahoma",Font.PLAIN,20));
	       txtPuerto.setForeground(new Color(0,0,102));
	        
	       txtUsuario.setPreferredSize(new Dimension(140,35));
	       txtUsuario.setFont(new Font("Tahoma",Font.PLAIN,20));
	       txtUsuario.setForeground(new Color(0,0,102));
	        
	       txtClave.setPreferredSize(new Dimension(140,35));
	       txtClave.setFont(new Font("Tahoma",Font.PLAIN,20));
	       txtClave.setForeground(new Color(0,0,102));
	        
	       txtBaseDeDatos.setPreferredSize(new Dimension(140,35));
	       txtBaseDeDatos.setFont(new Font("Tahoma",Font.PLAIN,20));
	       txtBaseDeDatos.setForeground(new Color(0,0,102));
	}
	
}
