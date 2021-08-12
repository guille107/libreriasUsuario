package elementos;

import java.sql.ResultSet;
import java.time.LocalDate;

import unidades.modUnidad;

public class ImpleIElementos implements IElementos{
	
	private boolean activo;
	private String idElemento;
	private String descElemento;
	private String codBarra;
	private double peso;
	private String ubicacion;
	private modUnidad Unidad;
	private int stockActual;
	private int stockMin;
	private double tasaIVA;
	private LocalDate fechaModiFicha;
	private int multCompra;
	private String idProveedor;

		
	@Override
	public boolean verificaSiExisteID(String idElemento) {
		modConexion conexion=new modConexion();
		return false;
	}
	@Override
	public boolean verificaSiExisteDescripcion(String descripElemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean buscaXidProveedor(String texto) {
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

	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(String idElemento) {
		this.idElemento = idElemento;
	}
	public String getDescElemento() {
		return descElemento;
	}
	public void setDescElemento(String descElemento) {
		this.descElemento = descElemento;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public modUnidad getUnidad() {
		return Unidad;
	}
	public void setUnidad(modUnidad unidad) {
		Unidad = unidad;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public int getStockMin() {
		return stockMin;
	}
	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}
	public double getTasaIVA() {
		return tasaIVA;
	}
	public void setTasaIVA(double tasaIVA) {
		this.tasaIVA = tasaIVA;
	}
	public LocalDate getFechaModiFicha() {
		return fechaModiFicha;
	}
	public void setFechaModiFicha(LocalDate fechaModiFicha) {
		this.fechaModiFicha = fechaModiFicha;
	}
	public int getMultCompra() {
		return multCompra;
	}
	public void setMultCompra(int multCompra) {
		this.multCompra = multCompra;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}


}
