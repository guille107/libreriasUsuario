package monedas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import conexiones.modConexion;
import varios.Constantes;

public class modTipoDeCambio {
	
	private modMoneda moneda;
	private Date fechaSQL;
	private final int FIN_DE_MES = 31;
	private String nombreBD=Constantes.NOMBRE_BD_TAFU;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	private Connection conexion;
	
	public modTipoDeCambio(LocalDate fechaCot) {
		
		moneda = new modMoneda("PESOS");
		moneda.setFechaCotizacion(fechaCot);
		
		fechaSQL = java.sql.Date.valueOf(moneda.getFechaCotizacion());

		setPrecioOficial(fechaSQL);
		
	}
	public modTipoDeCambio() {
		
	}
	
	public double getTipoCambioOficialCompradorUltimaCotizacionDelMes(LocalDate fecha) {
		
		return getTipoCambioOficialCompradorUltimaCotizacionDelMes(fecha.getMonthValue(), fecha.getYear());
		
	}
	
	public double getTipoCambioOficialCompradorUltimaCotizacionDelMes(int nroMes, int anio) {
		
		LocalDate primerDia = LocalDate.of(anio, nroMes, 1);		
		LocalDate ultDiaDelMesConCotizacion = primerDia.with(TemporalAdjusters.lastDayOfMonth());		
		
		double todasLasCotizacionesDelMes[] = getTablaConCotizacionesCompradorDelMes(ultDiaDelMesConCotizacion);
		
		return getUltimoConDatos(todasLasCotizacionesDelMes);
		
	}

	public double getTipoCambioOficialVendedorUltimaCotizacionDelMes(LocalDate fecha) {
		
		return getTipoCambioOficialVendedorUltimaCotizacionDelMes(fecha.getMonthValue(), fecha.getYear());
		
	}
	
	public double getTipoCambioOficialVendedorUltimaCotizacionDelMes(int nroMes, int anio) {
		LocalDate primerDia = LocalDate.of(anio, nroMes, 1);		
		LocalDate ultDiaDelMesConCotizacion = primerDia.with(TemporalAdjusters.lastDayOfMonth());		
		
		double todasLasCotizacionesDelMes[] = getTablaConCotizacionesVendedorDelMes(ultDiaDelMesConCotizacion);
		
		return getUltimoConDatos(todasLasCotizacionesDelMes);
		
	}
	
	private double getUltimoConDatos(double[] todasLasCotizacionesDelMes) {
		
		for (int a=0; a<FIN_DE_MES;a++) {
			if(todasLasCotizacionesDelMes[a] == 0.0)
				return todasLasCotizacionesDelMes[a-1];
		}
		return 0.0;
	}
	private double[] getTablaConCotizacionesVendedorDelMes(LocalDate ultDiaDelMesConCotizacion) {
		
		double[] tablaTipoCambioVendedorDelMes = new double[FIN_DE_MES];
		int indice = 0;
		int mes = ultDiaDelMesConCotizacion.getMonthValue();
		int anio = ultDiaDelMesConCotizacion.getYear();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM valordolar WHERE MONTH(fecha) = ? AND YEAR(fecha) = ?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setInt(1, mes);
			ps.setInt(2, anio);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				tablaTipoCambioVendedorDelMes[indice] = rs.getDouble(3);
				indice++;

			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return tablaTipoCambioVendedorDelMes;
	}

private double[] getTablaConCotizacionesCompradorDelMes(LocalDate ultDiaDelMesConCotizacion) {
		
		double[] tablaTipoCambioCompradorDelMes = new double[FIN_DE_MES];
		int indice = 0;
		int mes = ultDiaDelMesConCotizacion.getMonthValue();
		int anio = ultDiaDelMesConCotizacion.getYear();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM valordolar WHERE MONTH(fecha) = ? AND YEAR(fecha) = ?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setInt(1, mes);
			ps.setInt(2, anio);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				tablaTipoCambioCompradorDelMes[indice] = rs.getDouble(2);
				indice++;

			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return tablaTipoCambioCompradorDelMes;
	}

	public double getPrecioOficialComprador() {
		
		return moneda.getPrecioComprador();
	}
	
	public void setPrecioOficial(Date fecha) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM valordolar WHERE  fecha = ?";
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setDate(1, fechaSQL);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				moneda.setPrecioComprador(rs.getDouble(2));
				moneda.setPrecioVendedor(rs.getDouble(3));

			}else {
				
				sql="SELECT * FROM tafubd.valordolar where fecha=(SELECT MAX(fecha) from tafubd.valordolar)";
				ps=getConexion().prepareStatement(sql);
				rs=ps.executeQuery();
				
				if(rs.next()) {
					
					moneda.setPrecioComprador(rs.getDouble(2));
					moneda.setPrecioVendedor(rs.getDouble(3));

				}
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
		
	}
	
	public double getPrecioOficialVendedor() {
		return moneda.getPrecioVendedor();
	}

	public LocalDate getFecha() {
		return moneda.getFechaCotizacion();
	}
	public void setFecha(LocalDate fecha) {
		moneda.setFechaCotizacion(fecha);
	}
	
	private Connection getConexion() {
		
		if(this.conexion == null) 
			setConexion();
		
		return conexion;
	}
	
	private void setConexion() {
		
			this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
	}
	
}
