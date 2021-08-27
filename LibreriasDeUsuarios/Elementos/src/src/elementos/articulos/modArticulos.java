package elementos.articulos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

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
		if(idElemento==null || idElemento.isEmpty())
			return false;
		
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
			setImprimeEtTraza(rs.getBoolean(21));
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
		
		modArticulos artic= (modArticulos)articulo;

		if(verificaSiExisteID(artic.getIdElemento())) {
			JOptionPane.showMessageDialog(null, "YA EXISTE ESE CÓDIGO DE ARTICULO");
			return false;	
		}

		try {

		PreparedStatement ps=getConexion().prepareStatement(stringSQLDeAlta());

		ps.setBoolean(1, artic.isActivo());
		ps.setString(2, artic.getIdElemento());
		ps.setString(3, artic.getDescElemento());
		ps.setString(4, artic.getCodBarra());
		ps.setDouble(5, artic.getPeso());
		ps.setString(6, artic.getUbicacion());
		ps.setInt(7, artic.getUnidad().getIdUnidad());
		ps.setInt(8, artic.getStockActual());
		ps.setInt(9, artic.getStockMin());
		ps.setInt(10, artic.getMultVenta());
		
		ps.setString(11, artic.getRubro().getIdRubro());
		ps.setInt(12, artic.getMarca().getIdMarca());
		ps.setDouble(13, artic.getTasaIVA());
		ps.setDouble(14, artic.getComiVentaAbs());
		ps.setDouble(15, artic.getComiCobraAbs());
		ps.setDouble(16, artic.getComiVentasRel());
		ps.setDouble(17, artic.getComiCobraRel());
		ps.setDate(18, java.sql.Date.valueOf(java.time.LocalDate.now()));
		ps.setString(19, artic.getIdUsuario());
		ps.setInt(20,artic.getMultCompra());
		
		ps.setBoolean(21,artic.getImprimeEtTraza());
		ps.setString(22, artic.getIdProveedor());
		ps.setInt(23,artic.nroEtiqueta);
		
		
		ps.execute();
		return true;
			
		}catch(SQLException e) {
			return false;
		}
		
	}
	
	private String stringSQLDeAlta() {
		

		return  "INSERT INTO articulos (activo,idarticulo,descripcion,codbarra,peso,ubicacion,unidad,stockAct,stockMin,multVenta,"
				+ "idRubComp,idMarca,tasaIVA,comiVentaAbs,comiCobraAbs,comiVentaRel,comiCobraRel,fechamodificha,usmodificha,multcompra,"
				+ "imprimeettraza,idproveedor,nroetiqueta)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
	}

	@Override
	public boolean modiElemento(Object elemento) {
		/*
		 * deArticulosABD((modArticulos) elemento,"MODIFICA");
		 */		return true;
	}
	
	@Override
	public boolean bajaElemento(Object elemento) {
	
		if(elemento==null)
			return false;
		
		modArticulos articulo=(modArticulos)elemento;

		if(!verificaSiExisteID(articulo.getIdElemento()))
				return false;
		
		int seleccion = JOptionPane.showConfirmDialog(null,
				   "¿Desea eliminar "+articulo.getDescElemento()+"?","Eliminando Articulo",JOptionPane.YES_NO_OPTION);

				if (seleccion ==0) {

					try {
						
						PreparedStatement ps=getConexion().prepareStatement(stringSQLDeEliminacion());
						ps.setString(1, articulo.getIdElemento());
						ps.execute();
						
						return true;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return false;
					}finally {
						try {
							if(conexion != null)
								conexion.close();
						
						}catch(SQLException e) {
							e.printStackTrace();
						}
						
					}
				}
				return false;

	}
	
	private String stringSQLDeEliminacion() {
		return "DELETE FROM articulos WHERE idarticulo=?";
		
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

	@Override
	public Object[] listaDeTodos(String cadena) {

		return null;
	}
	
	private Connection getConexion() {
		try {
			if(this.conexion==null||this.conexion.isClosed()) 
				setConexion();
		} catch (SQLException e) {

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
