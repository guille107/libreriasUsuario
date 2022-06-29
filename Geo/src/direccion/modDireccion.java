package direccion;

import localiProvi.modLocaliProvi;

/**
 * Que tiene la dirección:
 * Calle y numeración
 * entre calles
 * modLocaliProvi
 * Observaciones
 * 
 * Constructores:  
 * Vacio para dar de alta una dirección
 * Con calle, numero e  id localiprovi
 * Con Calle e idLocaliprovi
 */

public class modDireccion extends modLocaliProvi{

	private String calle;
	private modLocaliProvi mLocaliProvi; //Ejemplo 054_01_0001 9 digitos
	private String Observaciones;
	
	public modDireccion(String calle, String idLocaliProvi) {

		this.calle = calle;
		this.mLocaliProvi = new modLocaliProvi(idLocaliProvi).getModelo();
		
		if(this.mLocaliProvi == null) {
			this.mLocaliProvi = new modLocaliProvi("000_00_0000").getModelo();
		}
		
		this.setLocalidad(mLocaliProvi.getLocalidad());
		this.setProvincia(mLocaliProvi.getProvincia());
		this.setCodPostal(mLocaliProvi.getCodPostal());
		this.setPais(mLocaliProvi.getPais());

	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
		
	public modLocaliProvi getLocaliProvi() {
		return mLocaliProvi;
	}
	public void setLocaliProvi(modLocaliProvi localiProvi) {
		mLocaliProvi = localiProvi;
	}
	
	public String getObservaciones() {
		return Observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	
	@Override
	public String toString() {
		return "modDireccion [calle=" + calle + ", Localidad="+getLocalidad() +"\r"+
				", Provincia="+ getProvincia()+ ", codPostal=" + getCodPostal() + ", Pais=" + getPais() +"\r"+
				", Observaciones=" + Observaciones + "]";
	}
}
