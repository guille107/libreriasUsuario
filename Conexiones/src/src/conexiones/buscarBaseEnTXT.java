package conexiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class buscarBaseEnTXT {
	
	private String servidor;
	private String puerto;
	private String usuari;
	private String passwo;
	private String base;
	
	private String nombreFila;
	
	private FileReader fr;
	private BufferedReader bf;
	
	public modConexion obtenerDatosDeConexion(String BD, String nombre) {
		
		modConexion modeloConexion=null;	
		this.nombreFila=nombre;
		this.base=BD;
		
		if(buscarFila(nombreFila)) {

			
			if(buscarTXT(base,nombreFila)) {
				
				modeloConexion.setHostname(this.servidor);
				modeloConexion.setPuerto(this.puerto);
				modeloConexion.setUsuario(this.usuari);
				modeloConexion.setClave(this.passwo);
				modeloConexion.setBaseDatos(this.base);
				
				
			}else {
				noExisteLaBase(base,nombre);				
			}
		}else {
			noExisteElArchivo(nombre);
		}
		
		return modeloConexion;
	}
	
	private void noExisteElArchivo(String nombre) {
		
		JOptionPane.showInternalMessageDialog(null, "NO EXISTE EL ARCHIVO "+ nombre);
		
	}

	private void noExisteLaBase(String base, String nombre) {
		
		JOptionPane.showInternalMessageDialog(null, "NO EXISTE LA BASE "+base+" EN EL ARCHIVO "+ nombre);
		
	}

	public boolean buscarFila(String nombre){
		File archivo= new File(nombre);
		
			if(archivo != null)
				return true;
			
			return false;
	}
	
	public boolean buscarTXT(String BD, String nombreFila) {
		
		try {
			fr=new FileReader(nombreFila);
			bf=new BufferedReader(fr);
		
			String sCadena;

			try {
				while((sCadena=bf.readLine())!=null){
					if(sCadena.length()>6) {

								this.base=sCadena.substring(8, sCadena.length());
								
								if(this.base.equals(BD)) {
									sCadena=bf.readLine();
									this.servidor=sCadena.substring(8, sCadena.length());
									sCadena=bf.readLine();
									this.puerto=sCadena.substring(8, sCadena.length());
									sCadena=bf.readLine();
									this.usuari=sCadena.substring(8, sCadena.length());
									sCadena=bf.readLine();
									this.passwo=transfo.devuelve(sCadena.substring(8, sCadena.length()));
									
									
									return true;
								}
							
					}//FIN IF  
					
					
				}
			} catch (IOException e) {
				return false;
			
			}	/// FIN WHILE
		} catch (FileNotFoundException e) {
			return false;
		}

	}
}
