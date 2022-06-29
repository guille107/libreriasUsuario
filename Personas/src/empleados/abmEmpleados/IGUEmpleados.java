package empleados.abmEmpleados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import empleados.modEmpleado;
import varios.Constantes;
//import varios.ManejoDeCUIT;
//import varios.verificaEMail;

public class IGUEmpleados extends JFrame{
	
		private ctrlIGUEmpleados ctrl=new ctrlIGUEmpleados();
	  /**  final int ANCHO_CUADRO= (int) (Constantes.ANCHO_PANTALLA*.8);
		final int ALTO_CUADRO=(int) (Constantes.ALTO_PANTALLA*.3);
		final int X_INICIAL=(int) (Constantes.ANCHO_PANTALLA/2-ANCHO_CUADRO/2);
		final int Y_INICIAL=(int) (Constantes.ALTO_PANTALLA/2-ALTO_CUADRO/2);
		**/
	    panelFormulario panel;
	    panelBotonesInferiores panel2;
	    panelTabla panel3;

	    
	    public IGUEmpleados(String usua) {
	    	String usuario=usua;
	    	panel=new panelFormulario(usuario);
	    	panel2=new panelBotonesInferiores();
	    	panel3=new panelTabla();
	    	
	        setLayout(new BorderLayout());
			add(panel,BorderLayout.CENTER);
			add(panel2,BorderLayout.SOUTH);
			add(panel3,BorderLayout.EAST);
			setTitle("EMPLEADOS");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			//setLocation(X_INICIAL,Y_INICIAL);
			setVisible(true);
			pack();
			setLocationRelativeTo(null);

	    }
	    public void refrescarPanel() {
	    	
	    }

	    class panelFormulario extends JPanel{
	    	
	        private JLabel lblTitulo;
	        private JLabel lblActivo;
	        private JLabel lblNombre;
	        private JLabel lblApellido;
	        private JLabel lblDNI;
	        private JLabel lblCUIL;
	        private JLabel lblmailPersonal;
	        private JLabel lblcelular;
	        private JLabel lbltelefono;
	        private JLabel lblcalle;
	        private JLabel lblnumero;
	        private JLabel lbllocalidad;
	        private JLabel lblprovincia;
	        private JLabel lblUsuario;
	        	
	        private JTextField txtNombre;
	        private JTextField txtApellido;
	        private JTextField txtDNI;
	        private JTextField txtCUIL;
	        private JTextField txtmailPersonal;
	        private JTextField txtcelular;
	        private JTextField txttelefono;
	        private JTextField txtcalle;
	        private JTextField txtnumero;
	        private JTextField txtlocalidad;
	        private JTextField txtprovincia;

	        private JCheckBox chkActivo;
	                       
	        private JSeparator primerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
	        private JSeparator segundoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
	        private JSeparator tercerSeparador = new JSeparator(SwingConstants.HORIZONTAL);
	        private JSeparator cuartoSeparador = new JSeparator(SwingConstants.HORIZONTAL);
						
	        public panelFormulario(String usuario){
	       	 			
	            lblTitulo=new JLabel("EMPLEADOS");
	            lblTitulo.setFont(new Font("Tahoma",Font.ITALIC,34));
	            lblTitulo.setForeground(new Color(183,218,247));
	            lblTitulo.setPreferredSize(new Dimension(200,40));

	            lblUsuario=new JLabel(usuario);
	            lblUsuario .setFont(new Font("Tahoma",Font.PLAIN,12));
	            lblUsuario.setForeground(new Color(183,218,247));
	            
	            lblActivo=new JLabel("Activo");
	            lblActivo.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblActivo.setForeground(new Color(183,218,247));
	     
	            lblApellido=new JLabel("Apellido");
	            lblApellido.setFont(new Font("Tahoma",Font.BOLD,20));
	            lblApellido.setForeground(new Color(183,218,247));
	            
	            lblNombre=new JLabel("Nombre");
	            lblNombre.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblNombre.setForeground(new Color(183,218,247));
 
	            lblDNI=new JLabel("DNI");
	            lblDNI.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblDNI.setForeground(new Color(183,218,247));
	            
	            lblCUIL=new JLabel("CUIL");
	            lblCUIL.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblCUIL.setForeground(new Color(183,218,247));
	            
	            lblmailPersonal=new JLabel("Mail Personal");
	            lblmailPersonal.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblmailPersonal.setForeground(new Color(183,218,247));
	            
	            lblcelular=new JLabel("Celular");
	            lblcelular.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblcelular.setForeground(new Color(183,218,247));
	            
	            lbltelefono=new JLabel("Telefono");
	            lbltelefono.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lbltelefono.setForeground(new Color(183,218,247));
	            
	            lblcalle=new JLabel("Calle");
	            lblcalle.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblcalle.setForeground(new Color(183,218,247));
	            
	            lblnumero=new JLabel("Nro.");
	            lblnumero.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblnumero.setForeground(new Color(183,218,247));
	            
	            lbllocalidad=new JLabel("Localidad");
	            lbllocalidad.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lbllocalidad.setForeground(new Color(183,218,247));
	            
	            lblprovincia=new JLabel("Prov.");
	            lblprovincia.setFont(new Font("Tahoma",Font.PLAIN,20));
	            lblprovincia.setForeground(new Color(183,218,247));	   
	            
	            chkActivo=new JCheckBox();
	            chkActivo.setFont(new Font("Tahoma",Font.PLAIN,20));
	            chkActivo.setForeground(new Color(183,218,247));
	            chkActivo.setBackground(new Color(29,120,196));
	                      
		        txtNombre=new JTextField();
		        txtNombre.setPreferredSize(new Dimension(200,25));
		        txtNombre.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtNombre.addKeyListener(new KeyAdapter(){ 
					   
					public void keyReleased(KeyEvent e){		 /// PASA A MAYUSC		   
						
						txtNombre.setText(txtNombre.getText().toUpperCase());
						
						if(txtNombre.getText().trim().length()>29) {
							txtNombre.setText(txtNombre.getText().substring(0, 29)); //30 CARACTERES MAXIMO
						
						}
						
					   }
					});
		        
		        txtApellido=new JTextField();
		        txtApellido.setPreferredSize(new Dimension(200,25));
		        txtApellido.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtApellido.addKeyListener(new KeyAdapter(){ 
					   
					public void keyReleased(KeyEvent e){		 /// PASA A MAYUSC		   
						
						txtApellido.setText(txtApellido.getText().toUpperCase());
						
						if(txtApellido.getText().trim().length()>29) {
							txtApellido.setText(txtApellido.getText().substring(0, 29)); //30 CARACTERES MAXIMO
						
						}
					   
					}
					});
		        
		        txtDNI=new JTextField();
		        txtDNI.setPreferredSize(new Dimension(80,25));
		        txtDNI.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtDNI.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
					
						char caracter = e.getKeyChar();
						if(txtDNI.getText().length()<8) {
							if(((caracter < '0') ||(caracter > '9')) &&(caracter != '\b')){//SOLO NUMERO
								e.consume();
							}
						}else {
							txtDNI.setText(txtDNI.getText().substring(0, 7)); //8 CARACTERES MAXIMO
						}
					   }
					});
		        
		        txtCUIL=new JTextField();
		        txtCUIL.setPreferredSize(new Dimension(110,25));
		        txtCUIL.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtCUIL.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
						String texto;
						char caracter = e.getKeyChar();
						if(txtCUIL.getText().length()<13) {
							if(((caracter < '0') ||(caracter > '9')) &&(caracter != '\b')){ //SOLO NUMERO
								e.consume();
							}
							if(txtCUIL.getText().length()>2&&txtCUIL.getText().length()<11) { //AGREGA EL PRIMER GUION
								texto=txtCUIL.getText().replaceAll("-", "");
								txtCUIL.setText(texto.substring(0, 2)+"-"+texto.substring(2));
							}else {
								if(txtCUIL.getText().length()>10) { //AGREGA EL SEGUNDO GUION
									texto=txtCUIL.getText().replaceAll("-", "");
									txtCUIL.setText(texto.substring(0, 2)+"-"+texto.substring(2,10)+"-"+texto.substring(10));
								}
							}
						}else {
							txtCUIL.setText(txtCUIL.getText().substring(0, 12)); //13 CARACTERES MAXIMO
						}
						
					   }
					});
		        txtCUIL.addFocusListener(new FocusListener() {
					   public void focusLost(FocusEvent e) {
						   if(!txtCUIL.getText().isEmpty()) {
						//	   if(!ManejoDeCUIT.verificaCUIT(txtCUIL.getText())) {
							//	
								//   JOptionPane.showMessageDialog(null, "EL CUIT ES INCORRECTO");
								  // txtCUIL.requestFocus();
							   //}
						   }
					   }

					@Override
					public void focusGained(FocusEvent e) {
								

					}
					});		        
		        
		        txtmailPersonal=new JTextField();
		        txtmailPersonal.setPreferredSize(new Dimension(300,25));
		        txtmailPersonal.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtmailPersonal.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
						if(txtmailPersonal.getText().length()>50) {
						
							txtmailPersonal.setText(txtmailPersonal.getText().substring(0, 49)); //50 CARACTERES MAXIMO
						}
						
						}
					});
		        txtmailPersonal.addFocusListener(new FocusListener() {
					   public void focusLost(FocusEvent e) {
						   if(!txtmailPersonal.getText().isEmpty()) {
						/**	   if(verificaEMail.verificaMail(txtmailPersonal.getText()).equals("INVALIDO")) {
								   JOptionPane.showMessageDialog(null, "EL CORREO ES INVALIDO");
								   txtmailPersonal.requestFocus();
							   }**/
						   }
					   }

					@Override
					public void focusGained(FocusEvent e) {
								

					}
					});		        
		        txtcelular=new JTextField();
		        txtcelular.setPreferredSize(new Dimension(300,25));
		        txtcelular.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtcelular.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
						char caracter = e.getKeyChar();
						if(txtcelular.getText().length()<15) {
							if(((caracter < '0') ||(caracter > '9')) &&(caracter != '\b')){ //SOLO NUMERO
								e.consume();
							}
							
						}else {
							txtcelular.setText(txtcelular.getText().substring(0, 14)); //15 CARACTERES MAXIMO
						}
						
					   }
					});
		        
		           
		        txttelefono=new JTextField();
		        txttelefono.setPreferredSize(new Dimension(300,25));
		        txttelefono.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txttelefono.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
						char caracter = e.getKeyChar();
						if(txttelefono.getText().length()<15) {
							//if(((caracter < '0') ||(caracter > '9')) &&(caracter != '\b')){ //SOLO NUMERO
								//e.consume();
							//}
							
						}else {
							txttelefono.setText(txttelefono.getText().substring(0, 14)); //15 CARACTERES MAXIMO
						}
						
					   }
					});
		        
		        txtcalle=new JTextField();
		        txtcalle.setPreferredSize(new Dimension(300,25));
		        txtcalle.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtcalle.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
						char caracter = e.getKeyChar();
						if(txtcalle.getText().length()<50) {
							//if(((caracter < '0') ||(caracter > '9')) &&(caracter != '\b')){ //SOLO NUMERO
								//e.consume();
							//}
							
						}else {
							txtcalle.setText(txtcalle.getText().substring(0, 49)); //50 CARACTERES MAXIMO
						}
						
					   }
					});
		        
		        txtnumero=new JTextField();
		        txtnumero.setPreferredSize(new Dimension(40,25));
		        txtnumero.setFont(new Font("Tahoma",Font.PLAIN,15));
		        txtnumero.addKeyListener(new KeyAdapter(){
					   
					public void keyTyped(KeyEvent e){				   
						char caracter = e.getKeyChar();
						if(txtnumero.getText().length()<6) {
							if(((caracter < '0') ||(caracter > '9')) &&(caracter != '\b')){ //SOLO NUMERO
								e.consume();
							}
							
						}else {
							txtnumero.setText(txtnumero.getText().substring(0, 5)); //6 CARACTERES MAXIMO
						}
						
					   }
					});
		        
		        txtlocalidad=new JTextField();
		        txtlocalidad.setPreferredSize(new Dimension(100,25));
		        txtlocalidad.setFont(new Font("Tahoma",Font.PLAIN,15));
		        
		        txtprovincia=new JTextField();
		        txtprovincia.setPreferredSize(new Dimension(100,25));
		        txtprovincia.setFont(new Font("Tahoma",Font.PLAIN,15));

	            setLayout(new GridBagLayout());

	            setBackground(new Color(29,120,196));
	            
	            GridBagConstraints limites=new GridBagConstraints();

	            limites.gridx=0;
				limites.gridy=0;
				limites.gridwidth=6;
				limites.gridheight=2;
				limites.anchor=GridBagConstraints.WEST;
				limites.insets=new Insets(15,15,5,0);	
				add(lblTitulo,limites);

	            limites.gridx=7;
				limites.gridy=0;
				limites.gridwidth=1;
				limites.gridheight=1;
				limites.anchor=GridBagConstraints.WEST;
				limites.insets=new Insets(5,5,5,10);	
				add(lblUsuario,limites);

	            limites.gridx=0;
				limites.gridy=2;
				limites.gridheight=1;
				limites.gridwidth=7;
				limites.insets=new Insets(3,5,5,3);
				limites.fill=GridBagConstraints.HORIZONTAL;
				add(primerSeparador,limites);
				
	            limites.gridx=0;
				limites.gridy=3;
				limites.gridwidth=2;
				limites.insets=new Insets(10,10,15,5);	
				add(lblActivo,limites);
				
	            limites.gridx=1;
				limites.gridy=3;
				limites.gridwidth=1;
				limites.insets=new Insets(10,10,15,5);	
				add(chkActivo,limites);
				
	            limites.gridx=0;
	            limites.gridy=4;
	            limites.gridwidth=1;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblApellido,limites);
	            
	            limites.gridx=1;
	            limites.gridy=4;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtApellido,limites);
				
	            limites.gridx=3;
	            limites.gridy=4;
	            limites.gridwidth=1;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblNombre,limites);
	            
	            limites.gridx=4;
	            limites.gridy=4;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtNombre,limites);

	            limites.gridx=0;
	            limites.gridy=5;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblDNI,limites);
	            
	            limites.gridx=1;
	            limites.gridy=5;
	            limites.gridwidth=1;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtDNI,limites);
				
	            limites.gridx=3;
	            limites.gridy=5;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblCUIL,limites);
	            
	            limites.gridx=4;
	            limites.gridy=5;
	            limites.gridwidth=1;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtCUIL,limites);
				
	            limites.gridx=0;
				limites.gridy=6;
				limites.gridheight=1;
				limites.gridwidth=6;
				limites.insets=new Insets(3,5,5,3);
				limites.fill=GridBagConstraints.HORIZONTAL;
				add(segundoSeparador,limites);
				
	            limites.gridx=0;
	            limites.gridy=7;
				limites.gridheight=1;
	            limites.gridwidth=1;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblmailPersonal,limites);
	            
	            limites.gridx=1;
	            limites.gridy=7;
				limites.gridheight=1;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtmailPersonal,limites);
				
	            limites.gridx=0;
	            limites.gridy=8;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblcelular,limites);
	            
	            limites.gridx=1;
	            limites.gridy=8;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtcelular,limites);
	            
	            limites.gridx=0;
	            limites.gridy=9;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lbltelefono,limites);
	            
	            limites.gridx=1;
	            limites.gridy=9;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txttelefono,limites);
	            			
	            limites.gridx=0;
				limites.gridy=10;
				limites.gridheight=1;
				limites.gridwidth=7;
				limites.insets=new Insets(3,5,5,3);
				limites.fill=GridBagConstraints.HORIZONTAL;
				add(tercerSeparador,limites);

	            limites.gridx=0;
	            limites.gridy=11;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblcalle,limites);
	            
	            limites.gridx=1;
	            limites.gridy=11;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtcalle,limites);
				
	            limites.gridx=3;
	            limites.gridy=11;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblnumero,limites);
	            
	            limites.gridx=4;
	            limites.gridy=11;
	            limites.gridwidth=1;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtnumero,limites);
	            
	            limites.gridx=0;
	            limites.gridy=12;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lbllocalidad,limites);
	            
	            limites.gridx=1;
	            limites.gridy=12;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtlocalidad,limites);
				
	            limites.gridx=3;
	            limites.gridy=12;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(lblprovincia,limites);
	            
	            limites.gridx=4;
	            limites.gridy=12;
	            limites.gridwidth=2;
	            limites.insets=new Insets(1,10,15,5);	
	            add(txtprovincia,limites);
	            
	            limites.gridx=0;
				limites.gridy=13;
				limites.gridheight=1;
				limites.gridwidth=7;
				limites.insets=new Insets(3,5,5,3);
				limites.fill=GridBagConstraints.HORIZONTAL;
				add(cuartoSeparador,limites);
	            
	        } //FIN CONSTRUCTOR panel
	        	        
	    }// FIN CLASE panel

	    class panelBotonesInferiores extends JPanel{
	    		        
	        private JButton btnAgregar;
	        private JButton btnModificar;
	        private JButton btnEliminar;
	        private JButton btnVerFichadas;
	        private JButton btnSalir;	        
	        
	    	public panelBotonesInferiores() {
	    		
	            setLayout(new GridBagLayout());

	            setBackground(new Color(29,120,196));
	            
	            GridBagConstraints limites=new GridBagConstraints();
	    		
	            btnAgregar=new JButton("AGREGAR");        
	            btnAgregar.setIcon(new ImageIcon("Contenido\\32x32\\addUsuario.png"));
	            btnAgregar.setHorizontalTextPosition( SwingConstants.CENTER );
	            btnAgregar.setVerticalTextPosition( SwingConstants.BOTTOM );
	            btnAgregar.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    				    	
				    }
				});
	            
	            btnModificar=new JButton("MODIFICAR");          
	            btnModificar.setIcon(new ImageIcon("Contenido\\32x32\\editUsuario.png"));
	            btnModificar.setHorizontalTextPosition( SwingConstants.CENTER );
	            btnModificar.setVerticalTextPosition( SwingConstants.BOTTOM );
	            btnModificar.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    				    	
				    }
				});
	            
	            btnEliminar=new JButton("ELIMINAR");            
	            btnEliminar.setIcon(new ImageIcon("Contenido\\32x32\\delUsuario.png"));
	            btnEliminar.setHorizontalTextPosition( SwingConstants.CENTER );
	            btnEliminar.setVerticalTextPosition( SwingConstants.BOTTOM );
	            btnEliminar.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    				    	
				    }
				});
	            btnVerFichadas=new JButton("FICHADAS");	            
	            btnVerFichadas.setIcon(new ImageIcon("Contenido\\32x32\\tabla.png"));
	            btnVerFichadas.setHorizontalTextPosition( SwingConstants.CENTER );
	            btnVerFichadas.setVerticalTextPosition( SwingConstants.BOTTOM );
	            btnVerFichadas.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    				    	
				    }
				});
	            
	            btnSalir=new JButton("SALIR");	            
	            btnSalir.setIcon(new ImageIcon("Contenido\\32x32\\exit_1.png"));
	            btnSalir.setHorizontalTextPosition( SwingConstants.CENTER );
	            btnSalir.setVerticalTextPosition( SwingConstants.BOTTOM );
	            btnSalir.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	CerrarVentana();	
				    }
				});
	            
	            limites.gridx=0;
				limites.gridy=0;
				limites.gridwidth=1;
				limites.gridheight=1;
				
				limites.insets=new Insets(10,5,10,0);	
				add(btnAgregar,limites);
				
	            limites.gridx=2;
				limites.gridy=0;
				limites.gridwidth=1;
				limites.gridheight=1;
	
				add(btnModificar,limites);
	           
	            limites.gridx=4;
				limites.gridy=0;
				limites.gridwidth=1;
				limites.gridheight=1;
				add(btnEliminar,limites);
				
	            limites.gridx=6;
				limites.gridy=0;
				limites.gridwidth=1;
				limites.gridheight=1;
				limites.insets=new Insets(10,25,10,0);	
				add(btnVerFichadas,limites);
				
	            limites.gridx=7;
				limites.gridy=0;
				limites.gridwidth=1;
				limites.gridheight=1;
				limites.insets=new Insets(10,125,10,0);
				add(btnSalir,limites);
	    	}
	    	
	    }//Fin Clase panelBotonesInferiores
	    
	    class panelTabla extends JPanel{
	    	

	    	private DefaultTableModel mdlTodosLosEmpleados=new DefaultTableModel();
	    	private JTable tblTodosLosEmpleados=new JTable(mdlTodosLosEmpleados);
	    	private JScrollPane scrPane=new JScrollPane(tblTodosLosEmpleados);

	    	
	    	public panelTabla() {
	    		
		    	mdlTodosLosEmpleados.addColumn("Empleado");
		    	scrPane.setPreferredSize(new Dimension(200,400));

		    	mdlTodosLosEmpleados.addRow(new ctrlIGUEmpleados().listarTodos());
		   // 	System.out.println(new modEmpleado().obtenerTodasLasPersonas()[0].getApellido());
		    	
		    	add(scrPane);
		    	
	    	}
	   
	    	

	    	
	    	
	    }
        public void CerrarVentana(){
		       
   	 		System.exit(0);
       	}
	}// FIN CLASE


