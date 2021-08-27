package direccion;
/**
 * Que tiene la dirección:
 * Calle y numeración
 * entre calles
 * localidad y provincias (modLocaliProv) Si es Argentina
 * O localidad provincia y país si es del exterior.
 * Codigo Postal
 * Observaciones
 * 
 * Constructores:
 * Vacio para dar de alta una dirección
 * Con calle, numero, id localiprovi y cp
 *Con calle, numero, locali, provincia y pais para direcciones del exterior 
 *
 */
public class modDireccion {

	private String calle;
	private int numeracion;
	private modLocaliProvi LocaliProvi; //Ejemplo 01_0001 7 digitos
	private String codPostal;
	private String Pais;
	private String Observaciones;
	
	public modDireccion(String calle, int numeracion, modLocaliProvi localiProvi, String codPostal, String pais) {

		this.calle = calle;
		this.numeracion = numeracion;
		LocaliProvi = localiProvi;
		this.codPostal = codPostal;
		Pais = pais;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getNumeracion() {
		return numeracion;
	}
	
	public void setNumeracion(int numeracion) {
		this.numeracion = numeracion;
	}
	
	public modLocaliProvi getLocaliProvi() {
		return LocaliProvi;
	}
	public void setLocaliProvi(modLocaliProvi localiProvi) {
		LocaliProvi = localiProvi;
	}
	
	public String getCodPostal() {
		return codPostal;
	}
	
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	
	public String getPais() {
		return Pais;
	}
	
	public void setPais(String pais) {
		Pais = pais;
	}
	
	public String getObservaciones() {
		return Observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	
	@Override
	public String toString() {
		return "modDireccion [calle=" + calle + ", numeración=" + numeracion + ", Localidad="+LocaliProvi.getLocalidad() +"\r"+
				", Provincia="+ LocaliProvi.getProvincia()+ ", codPostal=" + codPostal + ", Pais=" + Pais +"\r"+
				", Observaciones=" + Observaciones + "]";
	}
	
	
	
	
}
