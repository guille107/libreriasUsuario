package localiProvi;

public interface IDAOLocaliProvi {
	
	public boolean verificaSiExisteID(String ID);
	public modLocaliProvi[] getTodasLasLocaliProvi();
	public modLocaliProvi getLocaliProviPorID(String id);
	public modLocaliProvi getLocaliProviPorCodPostal(String codPostal);
	public String extraerCodDeProvinciaDesdeNombreDeProvincia(String provincia);
	public String[] getTodasLasLocalidadesPorProvincia(String provincia);
					
	public String[] getTodasLasProvinciasPorPais(String pais);
	public modLocaliProvi[] getLocaliProviTodasLasCapitales();
	public modLocaliProvi getLocaliProviPorPaisProvinciaLocalidad(String pais, String provincia, String Localidad);
	public String[] getTodosLosPaises();
	
	
	public boolean altaModLocaliProvi();
	public boolean bajaModLocaliProvi();
	public boolean modiModLocaliProvi();
	

}
