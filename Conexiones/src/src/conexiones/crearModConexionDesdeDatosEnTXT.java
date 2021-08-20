package conexiones;

public class crearModConexionDesdeDatosEnTXT {
	
	private modConexion modeloDeConexion=null;
	private String nombreBD;
	private String nombreFilaConDatosDeConexion;
	
	public crearModConexionDesdeDatosEnTXT (String BD,String nombreFila) {
		
		this.nombreBD=BD;
		this.nombreFilaConDatosDeConexion=nombreFila;
		
		setModCon(new buscarBaseEnTXT().obtenerDatosDeConexion(nombreBD,nombreFilaConDatosDeConexion));
			
			while(modeloDeConexion==null) {
				//this.modeloDeConexion=new iguSolicitaDatosDeConexion(modeloDeConexion).getModelo();
			}

	}

	public modConexion getModCon() {
		return modeloDeConexion;
	}
	
	public void setModCon(modConexion modelo) {
		this.modeloDeConexion=modelo;
		System.out.println(this.modeloDeConexion);
	}

}
