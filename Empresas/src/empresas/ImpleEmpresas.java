package empresas;

import java.sql.ResultSet;
import java.time.LocalDate;

import CUIT.entreLongYString;
import localiProvi.modLocaliProvi;
import modelos.ImpleIDAOClientesMySQL;

public class ImpleEmpresas implements IEmpresas {

	private boolean activo;
	private boolean bloqueo;
	private String idEmpresa;
	private String razonSocial;
	private String direccionCalle;
	private modLocaliProvi LocalProvi;
	private String telefonos;
	private String celularEmpresa;
	private long lCUIT;
	private String mail1;
	private String mail2;
	private String mail3;
	private String mail4;
	private String mail5;
	private LocalDate fechaAlta;
	private LocalDate fechaUltOper;
	
	@Override
	public boolean verificaSiExisteID(String idEmpresa) {
		return new ImpleIDAOClientesMySQL().verificaSiExistePorID(idEmpresa);
	}
	
	@Override
	public boolean verificaSiExisteRazonSocial(String razonSocial) {
		 
		return new ImpleIDAOClientesMySQL().verificaSiExistePorRazonSocial(razonSocial);
	}
	
	@Override
	public Object buscaXIDYDevuelveElObjetoEncontrado(String idEmpresa) {
		
		return new ImpleIDAOClientesMySQL().getEmpresasPorID(idEmpresa);
	}
	@Override
	public Object buscaXCUITYDevuelveElObjetoEncontrado(long CUIT) {
		
		return new ImpleIDAOClientesMySQL().getEmpresasPorCUIT(CUIT);
	}


	@Override
	public Object buscarElElementoPorVariosCampos(String textoABuscar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] listaDeEmpresasPoridLocaliProvi(String provincia) {
		
		return new ImpleIDAOClientesMySQL().getEmpresasPorProvincia(provincia);
		
	}
	@Override
	public Object[] listaDeEmpresasPorProvincias(String provincia) {
		return new ImpleIDAOClientesMySQL().getEmpresasPorProvincia(provincia);
	}
	@Override
	public Object[] listaDeEmpresasActivasONoActivas(boolean activo) {
		// TODO Auto-generated method stub
		return new ImpleIDAOClientesMySQL().getTodasLasEmpresasActivas(activo);
	}
	@Override
	public Object[] listaDeEmpresasBloqueadosONoBloqueados(boolean bloqueo) {
		// TODO Auto-generated method stub
		return new ImpleIDAOClientesMySQL().getTodasLasEmpresasBloqueadas(bloqueo);
	}
	@Override
	public Object[] listaDeTodos() {
		
		return new ImpleIDAOClientesMySQL().getTodasLasEmpresas();
		
	}
	
	@Override
	public boolean altaEmpresa(Object elemento) {

		return new ImpleIDAOClientesMySQL().altaEmpresa(elemento);

	}
	@Override
	public boolean eliminaElemento(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean actualizaElemento(Object elemento) {
		return new ImpleIDAOClientesMySQL().actualizaEmpresa(elemento);
	}
	@Override
	public Object creaObjetoConRS(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultSet deObjetoABBDD(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public boolean isBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(boolean bloqueo) {
		this.bloqueo = bloqueo;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccionCalle() {
		return direccionCalle;
	}
	public void setDireccionCalle(String calle) {
		this.direccionCalle = calle;
	}
	public modLocaliProvi getLocalProvi() {
		return LocalProvi;
	}
	public void setLocalProvi(String idLocalProvi) {
	 	
		this.LocalProvi = new modLocaliProvi(idLocalProvi).getModelo();

	}
	public String getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}
	public String getCelularEmpresa() {
		return celularEmpresa;
	}
	public void setCelularEmpresa(String celularEmpresa) {
		this.celularEmpresa = celularEmpresa;
	}
	public long getCUIT() {
		
		return lCUIT;
	}
	public void setCUIT(long cUIT) {

		lCUIT = cUIT;

	}
	
	public void setCUIT(String cUIT) {
		
		lCUIT = entreLongYString.getCUITLong(cUIT);
		
	}
	
	public String getMail1() {
		return mail1;
	}
	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}
	public String getMail2() {
		return mail2;
	}
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}
	public String getMail3() {
		return mail3;
	}
	public void setMail3(String mail3) {
		this.mail3 = mail3;
	}
	public String getMail4() {
		return mail4;
	}
	public void setMail4(String mail4) {
		this.mail4 = mail4;
	}
	public String getMail5() {
		return mail5;
	}
	public void setMail5(String mail5) {
		this.mail5 = mail5;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public LocalDate getFechaUltOper() {
		return fechaUltOper;
	}
	public void setFechaUltOper(LocalDate fechaUltOper) {
		this.fechaUltOper = fechaUltOper;
	}

	@Override
	public Object[] listaDeTodosLosID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] listaDeTodasLasRazonesSociales() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
