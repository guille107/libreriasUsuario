package conexiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import crTransfo.CRTransfo;

public class buscarBaseEnTXT {
	
	private String servidor;
	private String puerto;
	private String usuari;
	private String passwo;
	private String base;
	private String nombreFila;
	private FileReader fr;
	private BufferedReader bf;
	
	public modConexion obtenerDatosDeConexion(String BD, String archivo) {
		
		modConexion modeloConexion=new modConexion();	
		this.nombreFila=archivo;
		this.base=BD;
		
		if(new File(nombreFila).canRead()) {

			if(importarDatosDeConexionDelArchivoDeConfiguracion(base,nombreFila)) {
				
				setDatosDeConexion(modeloConexion);
				
			}else {
				noExisteLaBase(base,archivo);				
			}
		}else {
			noExisteElArchivo(archivo);
		}
		
		return modeloConexion;
	}
	
	private void setDatosDeConexion(modConexion modeloConexion) {
		
		modeloConexion.setHostname(this.servidor);
		modeloConexion.setPuerto(this.puerto);
		modeloConexion.setUsuario(this.usuari);
		modeloConexion.setClave(this.passwo);
		modeloConexion.setBaseDatos(this.base);
		
	}

	private void noExisteElArchivo(String nombre) {
		
		JOptionPane.showInternalMessageDialog(null, "NO EXISTE EL ARCHIVO "+ nombre);
		
	}

	private void noExisteLaBase(String base, String nombre) {
		
		JOptionPane.showInternalMessageDialog(null, "NO EXISTE LA BASE DE DATOS EN EL ARCHIVO "+ nombre);
		
	}
	
	private void problemasParaAbrirElArchivo(String nombre) {
		
		JOptionPane.showInternalMessageDialog(null, "PROBLEMAS AL ABRIR EL ARCHIVO "+ nombre);
		
	}
	
	public boolean importarDatosDeConexionDelArchivoDeConfiguracion(String BD, String nombreFila) {
		
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
									this.passwo=CRTransfo.DesEncriptaElParametro(sCadena.substring(8, sCadena.length()));
								
									return true;
								}
							
					}//FIN IF  
					
					
				}
			} catch (IOException e) {
				problemasParaAbrirElArchivo(nombreFila);
				return false;
			
			}	/// FIN WHILE
		} catch (FileNotFoundException e) {
			problemasParaAbrirElArchivo(nombreFila);
			return false;
		}
		return false;

	}
}
