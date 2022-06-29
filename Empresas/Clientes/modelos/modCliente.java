package modelos;

import java.time.LocalDate;

import empresas.ImpleEmpresas;

public class modCliente extends ImpleEmpresas {

	private String idVendedor;
	private String idRubroEmpresa;
	private LocalDate fechaModiRegistro;
	
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getIdRubroEmpresa() {
		return idRubroEmpresa;
	}
	public void setIdRubroEmpresa(String idRubroEmpresa) {
		this.idRubroEmpresa = idRubroEmpresa;
	}
	public LocalDate getFechaModiRegistro() {
		return fechaModiRegistro;
	}
	public void setFechaModiRegistro(LocalDate fechaModiRegistro) {
		this.fechaModiRegistro = fechaModiRegistro;
	}
	
	@Override
	public String toString() {
		return "modCliente [idVendedor=" + idVendedor + ", idRubroEmpresa=" + idRubroEmpresa + ", isActivo()="
				+ isActivo() + ", isBloqueo()=" + isBloqueo() + ", getIdEmpresa()=" + getIdEmpresa()
				+ ", getRazonSocial()=" + getRazonSocial() + ", getCalle()=" + getDireccionCalle() + ", getIdLocalProvi()="
				+ getLocalProvi() + ", getTelefonos()=" + getTelefonos() + ", getCelularEmpresa()="
				+ getCelularEmpresa() + ", getCUIT()=" + getCUIT() + ", getMail1()=" + getMail1() + ", getMail2()="
				+ getMail2() + ", getMail3()=" + getMail3() + ", getMail4()=" + getMail4() + ", getMail5()="
				+ getMail5() + ", Fecha Alta Cliente =" + getFechaAlta() + ", Fecha Ult Operación=" + getFechaUltOper() +
				", Fecha Modi Registro=" + getFechaModiRegistro() +"]";
	}

	
	

	
}
