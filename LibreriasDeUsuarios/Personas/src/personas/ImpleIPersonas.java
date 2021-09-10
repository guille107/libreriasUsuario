package personas;
import java.sql.ResultSet;

import direccion.modDireccion;
public class ImpleIPersonas implements IPersonas {

	private boolean activo;
	private int idPersona;
	private int DNI;
	private int CUIL;
	private String nombre;
	private String apellido;
	private modDireccion direccion;
	private String telPersonal;
	private String celular;
	private String mailPersonal;
	private String mailLaboral;
	
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public int getCUIL() {
		return CUIL;
	}
	public void setCUIL(int cUIL) {
		CUIL = cUIL;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public modDireccion getDireccion() {
		return direccion;
	}
	public void setDireccion(modDireccion direccion) {
		this.direccion = direccion;
	}
	public String getTelPersonal() {
		return telPersonal;
	}
	public void setTelPersonal(String telPersonal) {
		this.telPersonal = telPersonal;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getMailPersonal() {
		return mailPersonal;
	}
	public void setMailPersonal(String mailPersonal) {
		this.mailPersonal = mailPersonal;
	}
	public String getMailLaboral() {
		return mailLaboral;
	}
	public void setMailLaboral(String mailLaboral) {
		this.mailLaboral = mailLaboral;
	}
	@Override
	public Object buscaXIDYDevuelveElObjetoEncontrado(int texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean buscaXDescripcion(String texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean buscaXidProveedor(String texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean buscarXDNI(String texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean buscarXCUIT(String texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] listaDeTodos(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean altaElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean bajaElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modiElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void deRSASetters(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ResultSet deObjetoABBDD(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean verificaSiExisteID(int texto) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		return "ImpleIPersonas [activo=" + activo + ", idPersona=" + idPersona + ", DNI=" + DNI + ", CUIL=" + CUIL
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telPersonal="
				+ telPersonal + ", celular=" + celular + ", mailPersonal=" + mailPersonal + ", mailLaboral="
				+ mailLaboral + "]";
	}
	@Override
	public Object creaObjetoConRS(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}



}
