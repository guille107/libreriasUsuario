package empresas;


public interface IDAOEmpresas {
	
		public Object[] getTodasLasEmpresas();
		public Object[] getTodasLasEmpresasActivas(boolean activa);
		public Object[] getTodasLasEmpresasBloqueadas(boolean bloqueo);
		public boolean verificaSiExistePorID(String ID);
		public boolean verificaSiExistePorRazonSocial(String razonSocial);

		
		public Object getEmpresasPorID(String id);
		public Object getEmpresasPorRazonSocial(String razonSocial);
		public Object getEmpresasPorCUIT(long CUIT);
		public Object getEmpresasPorCodPostal(String codPostal);
		public Object[] getEmpresasPorProvincia(String provincia);
		public Object[] getEmpresasPorPais(String pais);
		
		public boolean altaEmpresa(Object empresa);
		public boolean bajaEmpresa(Object empresa);
		public boolean actualizaEmpresa(Object empresa);

		
}
