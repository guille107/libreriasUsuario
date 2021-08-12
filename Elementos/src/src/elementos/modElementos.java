package elementos;

public class modElementos {
	
	protected String descripcion;
	protected Double peso;
	
	public modElementos() {
		
	}

	public modElementos( String descripcion,Double peso) {
		this.descripcion = descripcion;
		this.peso=peso;

	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	
}
