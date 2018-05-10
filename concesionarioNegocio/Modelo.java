package concesionarioNegocio;

public enum Modelo {
	
	CORDOBA(Marca.SEAT),
	TOLEDO(Marca.SEAT),
	IBIZA(Marca.SEAT),
	SERIE1(Marca.BMW),
	SERIE2(Marca.BMW),
	SERIE3(Marca.BMW),
	SERIE5(Marca.BMW);
	
	private Marca marca;
	
	Modelo(Marca marca){
		this.marca = marca;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public String toString() {
		//return getMarca() + " " + name();
		
		return name();
	}
}
