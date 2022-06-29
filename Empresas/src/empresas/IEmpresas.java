package empresas;

import java.sql.ResultSet;

public interface IEmpresas {
	
	public Object buscaXIDYDevuelveElObjetoEncontrado(String idEmpresa);
	public Object buscaXCUITYDevuelveElObjetoEncontrado(long CUIT);
	public boolean verificaSiExisteID(String idEmpresa);
	public boolean verificaSiExisteRazonSocial(String razonSocial);
	public Object buscarElElementoPorVariosCampos(String textoABuscar);
	
	public Object[] listaDeEmpresasPoridLocaliProvi(String idLocaliProvi);
	public Object[] listaDeEmpresasPorProvincias(String provincia);
	public Object[] listaDeEmpresasActivasONoActivas(boolean activo);
	public Object[] listaDeEmpresasBloqueadosONoBloqueados(boolean bloqueo);
	
	public Object[] listaDeTodosLosID();
	public Object[] listaDeTodos();
	public Object[] listaDeTodasLasRazonesSociales();
	
	public boolean altaEmpresa(Object elemento);
	public boolean eliminaElemento(Object elemento);
	public boolean actualizaElemento(Object elemento);
	public Object creaObjetoConRS(ResultSet rs); 
	public ResultSet deObjetoABBDD(Object elemento); 
	
}
