package elementos;

import java.sql.ResultSet;

public interface IElementos {

	public Object buscaXIDYDevuelveElObjetoEncontrado(String id);
	public boolean verificaSiExisteID(String idElemento);
	public boolean verificaSiExisteDescripcion(String descripElemento);
	public Object buscaXidProveedor(String idProveedor);
	public Object[] listaDeTodos(String cadena);
	public boolean altaElemento(Object elemento);
	public boolean bajaElemento(Object elemento);
	public boolean modiElemento(Object elemento);
	public Object creaObjetoConRS(ResultSet rs); // Metodo para sobreescribor por cada tipo de elemento
	public ResultSet deObjetoABBDD(Object elemento); // Metodo para sobreescribor por cada tipo de elemento	
	
	
}
