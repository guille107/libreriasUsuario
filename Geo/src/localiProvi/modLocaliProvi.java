package localiProvi;

public class modLocaliProvi {
	
	private String idLocalProvi;
	private String provincia;
	private String Localidad;
	private String codPostal;
	private String prefijoTelefono;
	private String pais;
	private boolean esCapital; 
	 	
	public modLocaliProvi() {
		
	}
	
	public modLocaliProvi(String idLocaliProvi) {
		if(idLocaliProvi.trim().isEmpty())
			idLocaliProvi = "000_00_0000";
		
		this.idLocalProvi = idLocaliProvi.trim();
		
			
	}
	
	public modLocaliProvi getLocaliProviPorPaisProvinciaLocalidad(String pais, String provincia, String localidad){
		
		return new impleDAOLocaliProviMySQL().getLocaliProviPorPaisProvinciaLocalidad(pais,provincia,localidad);
	
	}
	public modLocaliProvi[] getListaCompleta() {
		
		return  new impleDAOLocaliProviMySQL().getTodasLasLocaliProvi();
	
	}
	
	public modLocaliProvi getModelo() {
		
		
		return buscaLocaliProviPorID(this.idLocalProvi);
		
	}

	public modLocaliProvi buscaLocaliProviPorID(String ID) {
		
		return  new impleDAOLocaliProviMySQL().getLocaliProviPorID(ID);

	}
	
	public String[] todasLasLocalidadesDeUnaProvincia(String provincia) {	
	
 
	
	return new impleDAOLocaliProviMySQL().getTodasLasLocalidadesPorProvincia(provincia);
	
	}
	
	public modLocaliProvi buscaLocaliProviPorCodPostal(String codPostal) {
		return new impleDAOLocaliProviMySQL().getLocaliProviPorCodPostal(codPostal);
	}
	
	public String[] getProvinciasPorPais(String pais) {
		
		return new impleDAOLocaliProviMySQL().getTodasLasProvinciasPorPais(pais);
	}
	public String extraerCodDeProvinciaDesdeNombreDeProvincia(String provincia) {
		return new impleDAOLocaliProviMySQL().extraerCodDeProvinciaDesdeNombreDeProvincia(provincia);
	}
	public modLocaliProvi devulveLocaliProviDesdeDatos(String pais, String provincia, String localidad) {
		String Pais = pais.toUpperCase();
		String Provincia = provincia.toUpperCase();
		String Localidad = localidad.toUpperCase();
		
		
		return new impleDAOLocaliProviMySQL().getLocaliProviPorPaisProvinciaLocalidad(Pais, Provincia, Localidad);
		 
	}

	public boolean verificaSiExistePorID(String ID){
		
		return new impleDAOLocaliProviMySQL().verificaSiExisteID(ID);
	}

	public String getIdLocalProvi() {
		return idLocalProvi;
	}
	public void setIdLocalProvi(String idLocalProvi) {
		this.idLocalProvi = idLocalProvi;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getPrefijoTelefono() {
		return prefijoTelefono;
	}

	public void setPrefijoTelefono(String prefijoTelefono) {
		this.prefijoTelefono = prefijoTelefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isEsCapital() {
		return esCapital;
	}

	public void setEsCapital(boolean esCapital) {
		this.esCapital = esCapital;
	}

	@Override
	public String toString() {
		return "modLocaliProvi [idLocalProvi=" + getIdLocalProvi() + ", Localidad=" + Localidad + ", provincia=" + provincia
				+ ", codPostal=" + codPostal + ", prefijoTelefono=" + prefijoTelefono + ", pais=" + pais
				+ ", esCapital=" + esCapital + "]";
	}

	public String[] getTodosLosPaises() {
		return new impleDAOLocaliProviMySQL().getTodosLosPaises();
	}
	

}
