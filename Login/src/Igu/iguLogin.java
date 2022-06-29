package Igu;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout.Constraints;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import control.Constantes;

public class iguLogin extends JDialog{
	
	/// SE FIJA AL 70% DEL TAMAï¿½O DE LA PANTALLA
	final int ANCHO_CUADRO= (int) (Constantes.ANCHO_PANTALLA*.3);
	final int ALTO_CUADRO=(int) (Constantes.ALTO_PANTALLA*.5);
	final int X_INICIAL=(int) (Constantes.ANCHO_PANTALLA/2-ANCHO_CUADRO/2);
	final int Y_INICIAL=(int) (Constantes.ALTO_PANTALLA/2-ALTO_CUADRO/2);
	private JLabel lblTitulo=new JLabel("BIENVENIDO !!!");
	private JLabel lblTextoAbajo=new JLabel();
	private Boolean usuarioValidado=false;
	private Boolean claveValidada=false;
	private String txtUsuatio;
	private String txtClave;
	private boolean IngresoOK=false;
	//ctrlLoginOperario ctrl=new ctrlLoginOperario();

	public iguLogin(String Titulo, String textoAbajo) {
	
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		lblTextoAbajo.setText(textoAbajo);
		lblTextoAbajo.setBorder(BorderFactory.createEmptyBorder(0, 0,10, 0));
		
		lblTextoAbajo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAbajo.setFont(new Font("Arial",Font.BOLD,20));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLocation(X_INICIAL,Y_INICIAL);
		
		ImageIcon ico = new ImageIcon(Constantes.IMG_USUARIO);
		setIconImage(ico.getImage());

		setModal(true);
		setResizable(false);
		setTitle(Titulo);
		setLayout(new BorderLayout(100,50));
	
		add(lblTitulo,BorderLayout.NORTH);
		add(new panelIzquierdo(),BorderLayout.WEST);
		add(new panelDerecho(),BorderLayout.CENTER);
		add(lblTextoAbajo,BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);

	}
	
	class panelIzquierdo extends JPanel {
		
		public panelIzquierdo(){

			javax.swing.ImageIcon Imagen = new javax.swing.ImageIcon(Constantes.IMG_Login_1_200x200);
			javax.swing.JLabel Img = new javax.swing.JLabel(Imagen);
			Img.setSize(10, 16);
			add(Img);
			
		}
		
	}

	class panelDerecho extends JPanel {
		
		private JTextField txtUsuario=new JTextField(20);
		private JPasswordField txtPass=new JPasswordField(20);
		
		private JLabel lblUsuario=new JLabel("Usuario");
		private JLabel lblPass=new JLabel("Contraseña");
		private JButton btnIngresar=new JButton("Ingresar");
		
		public panelDerecho() {
			lblTitulo.setFont(new Font("Arial",Font.BOLD,26));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			
			lblUsuario.setFont(new Font("Tahoma",Font.PLAIN,15));
			lblPass.setFont(new Font("Tahoma",Font.PLAIN,15));
			
			ImageIcon iconobtn = new ImageIcon(Constantes.IMG_USUARIO);
			btnIngresar.setIcon(iconobtn);
			
			txtUsuario.setFont(new Font("Tahoma",Font.PLAIN,15));
			
			txtPass.setFont(new Font("Tahoma",Font.PLAIN,15));
			
			setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 50));
			setLayout(new GridLayout(5,1,1,10));

			add(lblUsuario);
		
			add(txtUsuario);
			add(lblPass);
			add(txtPass);
			add(btnIngresar);
			registrarLosEventosDeListeners();
		}
		public void registrarLosEventosDeListeners() {

			btnIngresar.addActionListener(manejadorDeBoton);
		   
		 }
		
		  ActionListener manejadorDeBoton = new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
				    	  
			  		if(txtUsuario.getText().trim().isEmpty()) {
			  			txtUsuario.requestFocus();
			  		}else {
			  			if(txtPass.getPassword().length<1) {
			  				txtPass.requestFocus();
			  			}else {
			  				
			  			/*	if(new ctrlLoginOperario().clickEnIngreso(txtUsuario.getText().trim(),new String(txtPass.getPassword()))) {
			  					System.out.println("INGRESO");
			  					
			  				}*/
			  			}
			  			
			  		}
			  	}
		  	
		  };

		}
	public boolean IngresoOK() {
		return IngresoOK=true;
	}
}

