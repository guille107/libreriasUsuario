package personas;

import java.sql.ResultSet;

public interface IPersonas {
	
	public boolean buscaXID(String texto);
	public boolean buscaXDescripcion(String texto);
	public boolean buscaXidProveedor(String texto);
	public Object[] listaDeTodos(String cadena);
	public boolean altaElemento(Object elemento);
	public boolean bajaElemento(Object elemento);
	public boolean modiElemento(Object elemento);
	public void deRSASetters(ResultSet rs); // Metodo para sobreescribor por cada tipo de elemento
	public ResultSet deObjetoABBDD(Object elemento); // Metodo para sobreescribor por cada tipo de elemento

}
