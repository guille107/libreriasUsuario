package modelos;

import empresas.IDAOEmpresas;
import localiProvi.modLocaliProvi;
import varios.Constantes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import conexiones.modConexion;

public class ImpleIDAOClientesMySQL implements IDAOEmpresas {
	
	private ArrayList<modCliente> lista = new ArrayList<modCliente>();
	private Connection conexion;
	
	private String nombreBD=Constantes.NOMBRE_BD_TAFU;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	
	public modCliente[] getTodasLasEmpresasPorIDZona(String IDZona) {

		return null;

	}
	
	public modCliente[] getEmpresasPoridRubroEmpresa(String idRubroEmpresa) {

		return null;
	
	}
	
	@Override
	public modCliente[] getTodasLasEmpresas() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="SELECT * FROM clientes";
		
		try {

			ps=getConexion().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				agregarALista(setRS(rs));
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
		return genArray(lista);
	}
	private void agregarALista(modCliente modCliente) {

		lista.add(modCliente);
	
	}
	private modCliente[] genArray(ArrayList<modCliente> lista2) {
		
		modCliente[] temp=new modCliente[lista2.size()];
	
		if (lista2.size() > 0) {
        	
        	lista2.toArray(temp);
        	          
        } else {
            
        }
		
	return temp;

}
	@Override
	public modCliente[] getTodasLasEmpresasActivas(boolean activa) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean vActiva = activa;
		
		String sql="SELECT * FROM clientes where activo=?";
		
		try {

			ps=getConexion().prepareStatement(sql);
			ps.setBoolean(1, vActiva);
			rs=ps.executeQuery();
			while(rs.next()) {
				agregarALista(setRS(rs));
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
		return genArray(lista);
	}


	@Override
	public modCliente[] getTodasLasEmpresasBloqueadas(boolean bloqueo) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean vBloqueo = bloqueo;
		
		String sql="SELECT * FROM clientes where bloqueo=?";
		
		try {

			ps=getConexion().prepareStatement(sql);
			ps.setBoolean(1, vBloqueo);
			rs=ps.executeQuery();
			while(rs.next()) {
				agregarALista(setRS(rs));
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
		return genArray(lista);
	}

	@Override
	public modCliente getEmpresasPorID(String id) {
		
		if(id == null || id.isEmpty())
			return null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM clientes WHERE idcliente=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, id.trim());
			rs=ps.executeQuery();

			if(rs.next()) {				

				return setRS(rs);
			
			}else {

				return null;
			
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return null;
	
		}finally {
			try {
				if(getConexion() != null) {
					getConexion().close();
					conexion = null;
				}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public modCliente getEmpresasPorRazonSocial(String razonSocial) {
		return null;
	}

	@Override
	public modCliente getEmpresasPorCUIT(long CUIT) {
		
		if(CUIT == 0 )
			return null;
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM clientes WHERE cuit=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setLong(1, CUIT);
			rs=ps.executeQuery();

			if(rs.next()) {				

				return setRS(rs);
			
			}else {

				return null;
			
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();

			return null;
	
		}finally {
			try {
				if(getConexion() != null) {
					getConexion().close();
					conexion = null;
				}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public modCliente getEmpresasPorCodPostal(String codPostal) {
		return null;
	}

	@Override
	public modCliente[] getEmpresasPorProvincia(String provincia) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		String idProvincia = new modLocaliProvi().extraerCodDeProvinciaDesdeNombreDeProvincia(provincia);
		
		String sql="SELECT * FROM clientes where provincia=?";
		
		try {

			ps=getConexion().prepareStatement(sql);
			ps.setString(1, provincia.trim());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				agregarALista(setRS(rs));
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
		return genArray(lista);
	}

	@Override
	public modCliente[] getEmpresasPorPais(String pais) {
		return null;
	}
	
	@Override
	public boolean altaEmpresa(Object cli) {
		
		modCliente modClie = (modCliente) cli;

		if(verificaSiExistePorID(modClie.getIdEmpresa())) {
			
			System.out.println("Intenta dar de alta un código ID existente");
			return false;
				
		}
		try {
			//if(!verificaIDLocalProvi(modClie.getIdLocalProvi())){
				//modClie.setIdLocalProvi("000_00_0000");
			//}
			
		PreparedStatement ps=getConexion().prepareStatement(stringSQLDeAlta());
		
		genModeloConPS(ps,modClie);
	
		ps.execute();
		return true;
			
		}catch(SQLException e) {
			System.out.println("ERROR " + e);
			return false;
		}finally {
			try {
				if(getConexion() != null) {
					getConexion().close();
					conexion = null;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void genModeloConPS(PreparedStatement ps, modCliente modClieRecibido) {
		
		try {
			ps.setBoolean(1, modClieRecibido.isActivo());
			ps.setBoolean(2, modClieRecibido.isBloqueo());
			ps.setString(3, modClieRecibido.getIdEmpresa());
			ps.setString(4, modClieRecibido.getRazonSocial());
			ps.setString(5, modClieRecibido.getDireccionCalle());
			if(modClieRecibido.getLocalProvi()==null) {
				modClieRecibido.setLocalProvi(new modLocaliProvi().IGUBuscaLocaliProvi());
			}
			ps.setString(6, modClieRecibido.getLocalProvi().getIdLocalProvi());
			ps.setString(7, modClieRecibido.getTelefonos());
			ps.setString(8, modClieRecibido.getCelularEmpresa());
			ps.setLong(9, modClieRecibido.getCUIT());
			ps.setString(10, modClieRecibido.getIdVendedor());
			ps.setString(11, modClieRecibido.getIdRubroEmpresa());
			ps.setString(12, modClieRecibido.getMail1());
			ps.setString(13, modClieRecibido.getMail2());
			ps.setString(14, modClieRecibido.getMail3());
			ps.setString(15, modClieRecibido.getMail4());
			ps.setString(16, modClieRecibido.getMail5());
			
			if(modClieRecibido.getFechaUltOper()!=null)
				ps.setDate(17,java.sql.Date.valueOf(modClieRecibido.getFechaUltOper()));
			else
				ps.setDate(17,java.sql.Date.valueOf("1900-01-01"));
			
			if(modClieRecibido.getFechaAlta()!=null)
				ps.setDate(18,java.sql.Date.valueOf(modClieRecibido.getFechaAlta()));
			else
				ps.setDate(18,java.sql.Date.valueOf("1900-01-01"));
			ps.setDate(18,java.sql.Date.valueOf(LocalDate.now()));
		
						
		} catch (SQLException e) {
			System.out.println("Error al leer la Base de Datos en altaEmpresa");
			e.printStackTrace();
		}
	}

	@Override
	public boolean bajaEmpresa(Object empresa) {
		return false;
	}

	@Override
	public boolean actualizaEmpresa(Object empresa) {

		modCliente cliente = (modCliente)empresa;
		
		PreparedStatement ps=null;

		String sql="UPDATE clientes set activo = ?, bloqueo = ?, razonsocial = ?,"
				+ "direlegalcalle = ?, direlegalidlocalprovi =?, telefonos = ?,"
				+ "celular=?, CUIT = ?, idvendedor = ?,idrubroempresa = ?,"
				+ " mail1 = ? , mail2 = ?,mail3 = ?, mail4 = ?, mail5 = ?,"
				+ " fechaultventa = ?, fechaalta = ?,fechamodiregistro = ? WHERE idcliente=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setBoolean(1, cliente.isActivo());
			ps.setBoolean(2, cliente.isBloqueo());
			ps.setString(3, cliente.getRazonSocial());
			ps.setString(4, cliente.getDireccionCalle());
			ps.setString(5, cliente.getLocalProvi().getIdLocalProvi()); 	
			ps.setString(6, cliente.getTelefonos());
			ps.setString(7, cliente.getCelularEmpresa());
			ps.setLong(8, cliente.getCUIT());
			ps.setString(9, cliente.getIdVendedor());
			ps.setString(10,cliente.getIdRubroEmpresa());
			ps.setString(11,cliente.getMail1());
			ps.setString(12,cliente.getMail2());
			ps.setString(13,cliente.getMail3());
			ps.setString(14,cliente.getMail4());
			ps.setString(15,cliente.getMail5());
			ps.setDate(16,Date.valueOf(cliente.getFechaUltOper()));
			ps.setDate(17,Date.valueOf(cliente.getFechaAlta()));
			
			
			java.util.Date utilDate;
			String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(dateFormat);
			SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
			try {
			    utilDate = sdf1.parse(LocalDateTime.now().format(dtf1));
			} catch (ParseException e) {
			    utilDate = null; // handle the exception
			}
			
			ps.setDate(18,new java.sql.Date(utilDate.getTime()));
			
			ps.setString(19, cliente.getIdEmpresa());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("No se pudo actualizar el cliente " + cliente.getIdEmpresa());
			e.printStackTrace();
	
		}finally {
			try {
				if(getConexion() != null)
					getConexion().close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	private modCliente setRS(ResultSet rs) {
		
		modCliente temp = new modCliente();
		
		try {
	
			temp.setActivo(rs.getBoolean(1));
			temp.setBloqueo(rs.getBoolean(2));
			temp.setIdEmpresa(rs.getString(3));
			temp.setRazonSocial(rs.getString(4));
			temp.setDireccionCalle(rs.getString(5));
			temp.setLocalProvi(rs.getString(6));
			temp.setTelefonos(rs.getString(7));
			temp.setCelularEmpresa(rs.getString(8));
			temp.setCUIT(rs.getLong(9));
			temp.setIdVendedor(rs.getString(10));
			temp.setIdRubroEmpresa(rs.getString(11));
			temp.setMail1(rs.getString(12));
			temp.setMail2(rs.getString(13));
			temp.setMail3(rs.getString(14));
			temp.setMail4(rs.getString(15));
			temp.setMail5(rs.getString(16));
			temp.setFechaUltOper(rs.getDate(17).toLocalDate());
			temp.setFechaAlta(rs.getDate(18).toLocalDate());
			temp.setFechaModiRegistro(rs.getDate(19).toLocalDate());

		} catch (SQLException e) {
			
			System.out.println("Error al leer los datos de " + nombreBD);
			
		}
		return temp;
	}
	private String stringSQLDeAlta() {
		
		return  "INSERT INTO clientes (activo,bloqueo,idCliente,razonsocial,direlegalcalle,direlegalidlocalprovi"
				+ ",telefonos,celular,cuit,idvendedor,idrubroempresa,mail1,mail2,mail3,mail4,mail5,"
				+ "fechaultventa,fechaalta,fechamodiregistro)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";	
	}

	private Connection getConexion() {
		if(this.conexion==null) 
			setConexion();
		
		return conexion;
	}
	
	private void setConexion() {

			this.conexion=new modConexion(nombreBD,archivoDeConfiguracionBD).getConexion();
	}
	@Override
	public boolean verificaSiExistePorID(String ID) {
		
		if(ID==null || ID.isEmpty())
			return false;
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM clientes WHERE idcliente=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, ID.trim());
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
				if(getConexion() != null) {
					getConexion().close();
					conexion=null;
				}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public boolean verificaSiExistePorRazonSocial(String razonSocial) {
		
		if(razonSocial == null || razonSocial.isEmpty())
			return false;
		
		PreparedStatement ps = null;
		ResultSet rs=null;

		String sql="SELECT * FROM clientes WHERE razonsocial=?";

		try {
		
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, razonSocial.trim());
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
				if(getConexion() != null) {
					getConexion().close();
					conexion=null;
				}
		
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}





}
