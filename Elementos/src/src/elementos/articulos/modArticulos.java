package elementos.articulos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


import conexiones.modConexion;
import elementos.ImpleIElementos;
import marcas.modMarcas;
import rubros.modRubros;
import unidades.modUnidad;
import varios.Constantes;

public class modArticulos extends ImpleIElementos{
	
	private modRubros rubros;
	private modMarcas marcas;

	private double comiVentaAbs;
	private double comiVentasRel;
	private double comiCobraAbs;
	private double comiCobraRel;
	private String IdUsuario;
	private boolean imprimeEtTraza;
	private int nroEtiqueta;
	private int multVenta;

	private String nombreBD=Constantes.NOMBRE_BD;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;
	
	@Override
	public boolean verificaSiExisteID(String idElemento) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM articulos WHERE idarticulo=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, idElemento.trim());
			rs=ps.executeQuery();

			if(rs.next()) {				
				
				return true;
			
			}else {
			
				return false;
			
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return false;
	
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public modArticulos buscaXIDYDevuelveElObjetoEncontrado(String ID) {
		modArticulos articuloEncontrado=null;
		this.setIdElemento(ID);
		
		if(!verificaSiExisteID(ID)) {
			return articuloEncontrado;
		}
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM articulos WHERE idarticulo=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, getIdElemento().trim());
			rs=ps.executeQuery();

			if(rs.next()) {				
					articuloEncontrado=creaObjetoConRS(rs);		
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
		return articuloEncontrado;
	}
	
	@Override
	public modArticulos creaObjetoConRS(ResultSet rs) {

		try {
			setActivo(rs.getBoolean(1));
			setIdElemento(rs.getString(2));
			setDescElemento(rs.getString(3));
			setCodBarra(rs.getString(4));
			setPeso(rs.getDouble(5));
			setUbicacion(rs.getString(6));		
			setUnidad(new modUnidad(rs.getInt(7)));		
			setStockActual(rs.getInt(8));
			setStockMin(rs.getInt(9));
			setMultVenta(rs.getInt(10));
			setRubro(rs.getString(11)); 
			setMarca(rs.getInt(12)); 
			setTasaIVA(rs.getDouble(13));
			setComiVentaAbs(rs.getDouble(14));
			setComiCobraAbs(rs.getDouble(15));
			setComiVentasRel(rs.getDouble(16));
			setComiCobraRel(rs.getDouble(17));
			setFechaModiFicha((LocalDate)rs.getDate(18).toLocalDate());
			setIdUsuario(rs.getString(19)); //buscar usuario/empleado
			setMultCompra(rs.getInt(20));
			setimprimeEtTraza(rs.getBoolean(21));
			setIdProveedor(rs.getString(22)); // buscar proveedor??
			setNroEtiqueta(rs.getInt(23));
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return this;
		
		
	}
	@Override
	public ResultSet deObjetoABBDD(Object elemento) {
		
		return null;
	}

	@Override
	public boolean altaElemento(Object articulo) {
		
		modArticulos arti= (modArticulos)articulo;
		stringSQLDeAlta();
		
		try {
			
		PreparedStatement ps=getConexion().prepareStatement(stringSQLDeAlta());
			
		ps.setBoolean(1, arti.isActivo());
		ps.setString(2, arti.getIdElemento());
		ps.setString(3, arti.getDescElemento());
		ps.setString(4, arti.getCodBarra());
		ps.setDouble(5, arti.getPeso());
		ps.setString(6, arti.getUbicacion());
		ps.setInt(7, arti.getUnidad().getIdUnidad());
		ps.setInt(8, arti.getStockActual());
		ps.setInt(9, arti.getStockMin());
		ps.setInt(10, arti.getMultVenta());
		ps.setString(11, arti.getRubro().getIdRubro());
		ps.setInt(12, arti.getMarca().getIdMarca());
		ps.setDouble(13, arti.getTasaIVA());
		ps.setDouble(14, arti.getComiVentaAbs());
		ps.setDouble(15, arti.getComiVentasRel());
		ps.setDouble(16, arti.getComiCobraAbs());
		ps.setDouble(17, arti.getComiCobraRel());
		ps.setDate(18, Date.valueOf(getFechaModiFicha()));
		ps.setString(19, arti.getIdUsuario());
		ps.setInt(20,arti.getMultCompra());
		ps.setBoolean(21,arti.getImprimeEtTraza());

		ps.execute();
		return true;
			
		}catch(SQLException e) {
			
			return false;
		}
		
	}
	

	private String stringSQLDeAlta() {
		
		String ConsultaDeAltasql;
		return  ConsultaDeAltasql="INSERT INTO articulos (activo,idarticulo,descripcion,codbarra,peso,ubicacion,unidad,stockAct,stockMin,multVenta,"
				+ "idRubComp,idMarca,tasaIVA,comiVentaAbs,comiCobraAbs,comiVentaRel,comiCobraRel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
	}

	@Override
	public boolean modiElemento(Object elemento) {
		/*
		 * deArticulosABD((modArticulos) elemento,"MODIFICA");
		 */		return true;
	}
	
	@Override
	public boolean bajaElemento(Object elemento) {
		return imprimeEtTraza;
	}
	
	public int getMultVenta() {
		return multVenta;
	}

	public void setMultVenta(int multVenta2) {
		this.multVenta = multVenta2;
	}

	public double getComiVentaAbs() {
		return comiVentaAbs;
	}

	public void setComiVentaAbs(double comiVentaAbs) {
		this.comiVentaAbs = comiVentaAbs;
	}

	public double getComiVentasRel() {
		return comiVentasRel;
	}

	public void setComiVentasRel(double comiVentasRel) {
		this.comiVentasRel = comiVentasRel;
	}

	public double getComiCobraAbs() {
		return comiCobraAbs;
	}

	public void setComiCobraAbs(double comiCobraAbs) {
		this.comiCobraAbs = comiCobraAbs;
	}

	public double getComiCobraRel() {
		return comiCobraRel;
	}

	public void setComiCobraRel(double comuCobraRel) {
		this.comiCobraRel = comuCobraRel;
	}

	public boolean getImprimeEtTraza() {
		return imprimeEtTraza;
	}

	public void setImprimeEtTraza(boolean imprimeEtTraza) {
		this.imprimeEtTraza = imprimeEtTraza;
	}

	public int getNroEtiqueta() {
		return nroEtiqueta;
	}
	public void setNroEtiqueta(int nroEtiqueta) {
		this.nroEtiqueta = nroEtiqueta;
	}


	/*

	 * @Override public boolean buscaXDescripcion(String texto) { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public boolean buscaXidProveedor(String texto) { PreparedStatement
	 * ps=null; ResultSet rs=null;
	 * 
	 * String sql="SELECT * FROM "+nombreBD+" WHERE idProveedor=?"; Connection
	 * conexion=new modConexion().conectar(new
	 * CTRLConexiones(Constantes.baseTaFu).getModCon());
	 * 
	 * try {
	 * 
	 * ps=conexion.prepareStatement(sql); ps.setString(1, texto.trim()); //
	 * ps.setString(1, "%"+texto.trim()+"%"); //PARA PARECIDOS rs=ps.executeQuery();
	 * if(rs.next()) { deRSASetters(rs); return true;
	 * 
	 * }else {
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * return false;
	 * 
	 * }finally { try { if(conexion != null) conexion.close();
	 * 
	 * }catch(SQLException e) { e.printStackTrace(); } } }
	 */

	@Override
	public Object[] listaDeTodos(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Connection getConexion() {
		try {
			if(this.conexion==null||this.conexion.isClosed()) 
				setConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	private void setConexion() {

			this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
	}
	
	public void setMarca(int idMarca) {

		marcas=new modMarcas(idMarca);
		
	}
	
	public modMarcas getMarca() {
		return marcas;
	}
	
	  public void setRubro(String idRubro) {
	  
		  rubros=new modRubros(idRubro);
	  
	  }
	 
	public modRubros getRubro() {
		return rubros;
	}
	public String getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		IdUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "modArticulos [rubros=" + rubros + ", marcas=" + marcas + ", comiVentaAbs=" + comiVentaAbs
				+ ", comiVentasRel=" + comiVentasRel + ", comiCobraAbs=" + comiCobraAbs + ", comiCobraRel="
				+ comiCobraRel + ", IdUsuario=" + IdUsuario + ", imprimeEtTraza=" + imprimeEtTraza + ", nroEtiqueta="
				+ nroEtiqueta + ", multVenta=" + multVenta + ", isActivo()=" + isActivo() + ", getIdElemento()="
				+ getIdElemento() + ", getDescElemento()=" + getDescElemento() + ", getCodBarra()=" + getCodBarra()
				+ ", getPeso()=" + getPeso() + ", getUbicacion()=" + getUbicacion() + ", getUnidad()=" + getUnidad()
				+ ", getStockActual()=" + getStockActual() + ", getStockMin()=" + getStockMin() + ", getTasaIVA()="
				+ getTasaIVA() + ", getFechaModiFicha()=" + getFechaModiFicha() + ", getMultCompra()=" + getMultCompra()
				+ ", getIdProveedor()=" + getIdProveedor() + "]";
	}

	
}
