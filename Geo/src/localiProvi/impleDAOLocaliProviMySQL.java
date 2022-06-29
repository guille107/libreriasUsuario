package localiProvi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import conexiones.modConexion;
import varios.Constantes;

public class impleDAOLocaliProviMySQL implements IDAOLocaliProvi {
	private ArrayList<modLocaliProvi> lista = new ArrayList<modLocaliProvi>();
	private Connection conexion;
	
	private String nombreBD=Constantes.NOMBRE_BD;
	private String archivoDeConfiguracionBD=Constantes.ARCHIVO_DE_CONFIG_BD;
	
	
	@Override
	public modLocaliProvi[] getTodasLasLocaliProvi() {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM localprovi";
		
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
	
	@Override
	public modLocaliProvi getLocaliProviPorID(String idLocalProvi) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM localprovi where id=?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, idLocalProvi.trim());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				return setRS(rs);
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
		
		return null;
		
	}
	@Override
	public String[] getTodasLasLocalidadesPorProvincia(String provincia) {
		
		ArrayList<String> listaLocalidades = new ArrayList<String>();	
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT distinct localidad FROM localprovi where provincia=?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, provincia.trim().toUpperCase());
			rs=ps.executeQuery();
			
		
				while(rs.next()) {
					listaLocalidades.add(rs.getString(1));
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
		String[] temp=new String[listaLocalidades.size()];
		
		if (listaLocalidades.size() > 0) {
	        	
			listaLocalidades.toArray(temp);
	        	
	            
	        } else {
	            
	        }
		return temp;
	}
		
	@Override
	public modLocaliProvi getLocaliProviPorCodPostal(String codPostal) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM localprovi where codpostal=?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, codPostal.trim());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				return setRS(rs);
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
		
		return null;
	}


	private void agregarALista(modLocaliProvi modLocaliProvi) {
		lista.add(modLocaliProvi);
	
	}
	private modLocaliProvi[] genArray(ArrayList<modLocaliProvi> lista2) {
		modLocaliProvi[] temp=new modLocaliProvi[lista2.size()];
		
		if (lista2.size() > 0) {
	        	
	        	lista2.toArray(temp);
	        	
	            
	        } else {
	            
	        }
		return temp;
	
	}
	private modLocaliProvi setRS(ResultSet rs) {
		
		modLocaliProvi temp = new modLocaliProvi();
		
		try {
			
			temp.setIdLocalProvi(rs.getString(1));
			temp.setProvincia(rs.getString(2));
			temp.setLocalidad(rs.getString(3));
			temp.setCodPostal(rs.getString(4));
			temp.setPrefijoTelefono(rs.getString(5));
			temp.setPais(rs.getString(6));
			temp.setEsCapital(rs.getBoolean(7));
			
		} catch (SQLException e) {
			
			System.out.println("Error al leer los datos de LocaliProvi");
			
		}
		return temp;
	}
	
	@Override
	public modLocaliProvi[] getLocaliProviTodasLasCapitales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altaModLocaliProvi() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaModLocaliProvi() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modiModLocaliProvi() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean verificaSiExisteID(String ID) {
		
		if(ID==null || ID.isEmpty())
			return false;
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		String sql="SELECT * FROM localprovi WHERE id=?";

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
	public modLocaliProvi getLocaliProviPorPaisProvinciaLocalidad(String pais, String provincia, String Localidad) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM localprovi where pais=? and provincia=? and localidad =? ";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, pais.trim().toUpperCase());
			ps.setString(2, provincia.trim().toUpperCase());
			ps.setString(3, Localidad.trim().toUpperCase());

			
			
			rs=ps.executeQuery();
			
		
				while(rs.next()) {
					return setRS(rs);
					
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
		
		return null;
	}

	@Override
	public String extraerCodDeProvinciaDesdeNombreDeProvincia(String provincia) {
		String idProvincia = "";
		PreparedStatement ps = null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM localprovi where provincia=?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, provincia.trim().toUpperCase().trim());
			
			rs=ps.executeQuery();
	
			if(rs.next()) {			
				
				idProvincia=rs.getString(1).substring(4, 6);
		
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
		
		return idProvincia;
	}

	@Override
	public String[] getTodosLosPaises() {
		
		modLocaliProvi[] todasLasLocaliProvi = getTodasLasLocaliProvi();
		String[] paises = new String[todasLasLocaliProvi.length];
		ArrayList<String> arListaFinal = new ArrayList<String>(1);
		
		for(int a = 0; a < paises.length; a++) {
			if(todasLasLocaliProvi[a].getPais().trim()!=null)
				paises[a] = todasLasLocaliProvi[a].getPais().trim();
		}
				
		Arrays.sort(paises);
		arListaFinal.add(0, paises[0]);
		int j = 0;
		for(int i = 0; i < paises.length-1; i++) {
			if (!arListaFinal.get(j).equals(paises[i+1]) ){
				j++;
				arListaFinal.add(j, paises[i+1]);
				
			}
		} 
		String[] temp=new String[arListaFinal.size()];
		
		if (arListaFinal.size() > 0) {
        	
			arListaFinal.toArray(temp);
        	          
        } else {
            return null;
        }

		   return temp;
	}

	@Override
	public String[] getTodasLasProvinciasPorPais(String pais) {
		ArrayList<String> listaProvincias = new ArrayList<String>();	
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT distinct provincia FROM localprovi where pais=?";
		
		try {
			ps=getConexion().prepareStatement(sql);
			ps.setString(1, pais.trim().toUpperCase());
			rs=ps.executeQuery();
			
		
				while(rs.next()) {
					listaProvincias.add(rs.getString(1));
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
		String[] temp=new String[listaProvincias.size()];
		
		if (listaProvincias.size() > 0) {
	        	
			listaProvincias.toArray(temp);
	        	
	            
	        } else {
	            
	        }
		return temp;

	}


}