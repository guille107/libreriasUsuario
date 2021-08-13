package conexiones.iguSolicitaDatosDeConexion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import conexiones.modConexion;

public class iguSolicitaDatosDeConexion extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final  int ANCHO_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize().width;
	final  int ALTO_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	final int ANCHO_CUADRO= (int) (ANCHO_PANTALLA*.3);
	final int ALTO_CUADRO=(int) (ALTO_PANTALLA*.5);
	final int X_INICIAL=(int) (ANCHO_PANTALLA/2-ANCHO_CUADRO/2);
	final int Y_INICIAL=(int) (ALTO_PANTALLA/2-ALTO_CUADRO/2);
	
	private JButton btnConectar=new JButton();
	private JSeparator primerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
	

	public iguSolicitaDatosDeConexion(modConexion modelo) {
		
		TodasLasEtiquetas etiquetas=new TodasLasEtiquetas();
		TodosLosTextFields textFields=new TodosLosTextFields();
		
		ImageIcon ico = new ImageIcon("U:\\LibreriasDeUsuarios\\Cripto\\warning.png");
		setIconImage(ico.getImage());
        
        primerSeparador.setBackground(new Color(0,0,102));
        
		ImageIcon iconobtnConectar = new ImageIcon("U:\\LibreriasDeUsuarios\\Cripto\\conDB2.png");
		btnConectar.setIcon(iconobtnConectar);
		btnConectar.setPreferredSize(new Dimension(80,80));
		btnConectar.setToolTipText("Conectar");
		btnConectar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(verificaTxtFieldsDistintosDeVacio()) {
					setDatosDelModelo();
					dispose();
				}
				
			}

		private boolean verificaTxtFieldsDistintosDeVacio() {
			if(textFields.txtServidor.getText().trim().length()>0) {
				if(textFields.txtPuerto.getText().trim().length()>0) {
					if(textFields.txtUsuario.getText().trim().length()>0) {
						if(textFields.txtClave.getText().trim().length()>0) {
							if(textFields.txtBaseDeDatos.getText().trim().length()>0) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}
		private void setDatosDelModelo() {
			modelo.setHostname(textFields.txtServidor.getText().trim());
			modelo.setPuerto(textFields.txtPuerto.getText().trim());
			modelo.setUsuario(textFields.txtUsuario.getText().trim());
			modelo.setClave(textFields.txtClave.getText().trim());
			modelo.setBaseDatos(textFields.txtBaseDeDatos.getText().trim());
			//modelo.conectar(modelo);
			System.out.println(modelo.toString());
		}

		});


		setTitle("No se puedo acceder al archivo de datos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		setLocation(X_INICIAL,Y_INICIAL);
		setResizable(false);

		GridBagConstraints limites=new GridBagConstraints();

		limites.gridx=0;
		limites.gridy=0;
		limites.gridwidth=2;
		limites.insets=new Insets(0,10,10,10);		
		add(etiquetas.lblTitulo,limites);

		limites.gridx=0;
		limites.gridy=1;
		limites.insets=new Insets(10,10,0,0);
		limites.anchor=GridBagConstraints.WEST;
		add(etiquetas.lblServidor,limites);
		
		
		limites.gridx=0;
		limites.gridy=2;
		add(etiquetas.lblPuerto,limites);
		
		limites.gridx=0;
		limites.gridy=3;
		add(etiquetas.lblUsuario,limites);
		
		limites.gridx=0;
		limites.gridy=4;
		add(etiquetas.lblClave,limites);
		
		limites.gridx=0;
		limites.gridy=6;
		add(etiquetas.lblBaseDeDatos,limites);
		
		limites.gridx=2;
		limites.gridy=1;
		limites.insets=new Insets(10,10,0,10);
		add(textFields.txtServidor,limites);
		
		limites.gridx=2;
		limites.gridy=2;
		add(textFields.txtPuerto,limites);

		
		limites.gridx=2;
		limites.gridy=3;
		add(textFields.txtUsuario,limites);

		limites.gridx=2;
		limites.gridy=4;
		limites.insets=new Insets(10,10,0,10);
		add(textFields.txtClave,limites);
				
		limites.gridx=2;
		limites.gridy=6;
		limites.insets=new Insets(10,10,0,10);
		add(textFields.txtBaseDeDatos,limites);	
		
		limites.gridx=3;
		limites.gridy=7;
		limites.insets=new Insets(10,10,10,30);
		limites.anchor=GridBagConstraints.EAST;
		add(btnConectar,limites);
		
		limites.gridx=1;
		limites.gridy=5;
		limites.gridwidth=3;
		limites.fill=GridBagConstraints.HORIZONTAL;;
		limites.insets=new Insets(10,10,10,10);
		add(primerSeparador,limites);	
		
		pack();
		setVisible(true);

	}
}
