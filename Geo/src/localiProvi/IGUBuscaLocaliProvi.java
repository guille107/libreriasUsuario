package localiProvi;

import javax.swing.JPanel;

import java.awt.Color;


import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.UIManager;
import javax.swing.JButton;

public class IGUBuscaLocaliProvi extends JFrame {
	
	final  int ANCHO_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize().width;
	final  int ALTO_PANTALLA=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	final int ANCHO_CUADRO= (int) (ANCHO_PANTALLA*.3);
	final int ALTO_CUADRO=(int) (ALTO_PANTALLA*.5);
	final int X_INICIAL=(int) (ANCHO_PANTALLA/2-ANCHO_CUADRO/2);
	final int Y_INICIAL=(int) (ALTO_PANTALLA/2-ALTO_CUADRO/2);
	
	private modLocaliProvi[] todasLasLocaliProvi = new modLocaliProvi().getListaCompleta();
	private modLocaliProvi modeloLocaliProvi = null;
	
	protected JPanel panel = new JPanel();
	protected JComboBox<String> cmbPais = new JComboBox<String>();
	protected JComboBox<String> cmbProvincia = new JComboBox<String>();
	protected DefaultComboBoxModel<String> modeloProvincia = new DefaultComboBoxModel<String>();
	protected JComboBox<String> cmbLocalidad = new JComboBox<String>();
	protected DefaultComboBoxModel<String> modeloLocalidad = new DefaultComboBoxModel<String>();
	protected JLabel lblIDLocaliProvi = new JLabel("idLocaliProvi");
	
	protected boolean click = false;
	
	public IGUBuscaLocaliProvi() {
		this(new modLocaliProvi(""));

	}

	public IGUBuscaLocaliProvi(modLocaliProvi modelo) {
		this.modeloLocaliProvi = modelo;
		String[] paisesSinRepetir =new modLocaliProvi().getTodosLosPaises();

		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(10, 11, 417, 206);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblProvincia = new JLabel("PROVINCA");
		lblProvincia.setBounds(20, 117, 78, 17);
		panel.add(lblProvincia);
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProvincia.setForeground(UIManager.getColor("Button.focus"));
		
		JLabel lblPais = new JLabel("PAIS");
		lblPais.setBounds(20, 69, 35, 17);
		panel.add(lblPais);
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPais.setHorizontalAlignment(SwingConstants.LEFT);
		lblPais.setBackground(Color.GRAY);
		lblPais.setForeground(UIManager.getColor("Button.focus"));
		
		JLabel lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setBounds(20, 160, 86, 17);
		panel.add(lblCiudad);
		lblCiudad.setForeground(UIManager.getColor("Button.focus"));
		lblCiudad.setBackground(Color.GRAY);
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		cmbPais.setBounds(115, 66, 155, 23);
		panel.add(cmbPais);
		cmbPais.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbPais.setForeground(UIManager.getColor("Button.focus"));
		cmbPais.setBackground(Color.GRAY);
		
		DefaultComboBoxModel<String> modeloPais = new DefaultComboBoxModel<String>();
		
		for(String listaPaises:paisesSinRepetir) {
			modeloPais.addElement(listaPaises);
		}
		
		cmbPais.setModel(modeloPais);
		cmbPais.setSelectedIndex(0);
		cmbPais.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				pierdeFocoPais();
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cmbProvincia.setBounds(115, 114, 273, 23);
		panel.add(cmbProvincia);
		
		cmbProvincia.setModel(modeloProvincia);
		cmbProvincia.setForeground(Color.LIGHT_GRAY);
		cmbProvincia.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbProvincia.setBackground(Color.GRAY);
		//cmbProvincia.setSelectedIndex(0);
		cmbProvincia.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				pierdeFocoProvincia();
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cmbLocalidad.setBounds(115, 160, 273, 23);
		panel.add(cmbLocalidad);

		cmbLocalidad.setForeground(Color.LIGHT_GRAY);
		cmbLocalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbLocalidad.setBackground(Color.GRAY);
		cmbLocalidad.setModel(modeloLocalidad);
		//cmbLocalidad.setSelectedIndex(0);
		
		cmbLocalidad.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
		    	setModLocaliProvi(new modLocaliProvi().getLocaliProviPorPaisProvinciaLocalidad(cmbPais.getSelectedItem().toString(), cmbProvincia.getSelectedItem().toString(),cmbLocalidad.getSelectedItem().toString()));
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JLabel lblTitulo = new JLabel("Seleccionar los datos de ubicaci\u00F3n.");
		lblTitulo.setBounds(10, 11, 397, 47);
		panel.add(lblTitulo);
		lblTitulo.setBackground(UIManager.getColor("Button.background"));
		lblTitulo.setForeground(UIManager.getColor("Button.background"));
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 26));
		
		JButton btnOK = new JButton("CONFIRMA");
		btnOK.setBounds(10, 266, 171, 47);
		add(btnOK);
		btnOK.setBorderPainted(false);
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setBackground(new Color(102, 0, 204));
		btnOK.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	click=true;
		    	setModLocaliProvi(new modLocaliProvi().getLocaliProviPorPaisProvinciaLocalidad(cmbPais.getSelectedItem().toString(), cmbProvincia.getSelectedItem().toString(),cmbLocalidad.getSelectedItem().toString()));
				dispose();
		    
		    }
			});
				
		lblIDLocaliProvi.setFont(new Font("Tahoma", Font.BOLD, 14));			
		lblIDLocaliProvi.setForeground(new Color(0, 0, 0));
		lblIDLocaliProvi.setBackground(new Color(153, 153, 153));
		lblIDLocaliProvi.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDLocaliProvi.setBounds(10, 230, 417, 25);
		lblIDLocaliProvi.setText("");
		add(lblIDLocaliProvi);
		
		setBackground(SystemColor.textInactiveText);
		setLayout(null);
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(X_INICIAL, Y_INICIAL, ANCHO_CUADRO, ALTO_CUADRO);
		setResizable(false);

		setVisible(true);

	}
	private void pierdeFocoPais() {

		llenarCmbProvincia(cmbPais.getSelectedItem().toString());
		
	}
	private void pierdeFocoProvincia() {
		llenarCmbLocalidad(cmbProvincia.getSelectedItem().toString());
	}
	private void llenarCmbLocalidad(String provincia) {
		cmbLocalidad.removeAllItems();
		for(String listaLocalidad:new modLocaliProvi().todasLasLocalidadesDeUnaProvincia(provincia)) {

			modeloLocalidad.addElement(listaLocalidad);

		}	
		
	}
	private void llenarCmbProvincia(String pais) {
		
		cmbProvincia.removeAllItems();
		for(String listaProvincia:new modLocaliProvi().getProvinciasPorPais(pais)) {

			modeloProvincia.addElement(listaProvincia);

		}
	}
		
	public modLocaliProvi getModLocaliProvi() {
		return modeloLocaliProvi;
	}
	
	public void setModLocaliProvi(modLocaliProvi modLocaliProvi) {
		modLocaliProvi modLocaliProviTemp = new modLocaliProvi().getLocaliProviPorPaisProvinciaLocalidad(cmbPais.getSelectedItem().toString(), cmbProvincia.getSelectedItem().toString(),cmbLocalidad.getSelectedItem().toString());
		if(modLocaliProviTemp!=null) {			
			lblIDLocaliProvi.setText(modLocaliProviTemp.getIdLocalProvi());			
		}
		this.modeloLocaliProvi = modLocaliProvi;
	}
	public String clickBoton() {

		return modeloLocaliProvi.getIdLocalProvi();	
		
	}
	private void setlblIDLocaliProvi(String id) {
		lblIDLocaliProvi.setText(id);
	}
	public String getlblIDLocaliProvi() {

		return lblIDLocaliProvi.getText();
	}
	public boolean esClick() {

		return click;
	}
	public void cerrarme() {
		dispose();
	}

}

