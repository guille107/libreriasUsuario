package monedas;

import java.time.LocalDate;

public class modMoneda {
	
	private String simboloMoneda;
	private String nombreMoneda;
	private double precioVendedor;
	private double precioComprador;
	private LocalDate fechaCotizacion;
	
	modMoneda (String nombreMoneda){
		
		this.nombreMoneda = nombreMoneda;
		
	}
	
	public String getSimboloMoneda() {
		return simboloMoneda;
	}
	public void setSimboloMoneda(String simboloMoneda) {
		this.simboloMoneda = simboloMoneda;
	}
	public String getNombreMoneda() {
		return nombreMoneda;
	}
	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}
	public double getPrecioVendedor() {
		return precioVendedor;
	}
	public void setPrecioVendedor(double precioVendedor) {
		this.precioVendedor = precioVendedor;
	}
	public double getPrecioComprador() {
		return precioComprador;
	}
	public void setPrecioComprador(double precioComprador) {
		this.precioComprador = precioComprador;
	}
	public LocalDate getFechaCotizacion() {
		return fechaCotizacion;
	}
	public void setFechaCotizacion(LocalDate fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}
}
