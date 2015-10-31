package Clases;

public abstract class Pieza {
	
	private String id_pieza;
	private String color;
	private String posicion;
	
	public Pieza(String id_pieza,String color,String posicion)
	{
		this.id_pieza=id_pieza;
		this.color=color;
		this.posicion=posicion;
	}




	public String getId_pieza() {
		return id_pieza;
	}


	public void setId_pieza(String id_pieza) {
		this.id_pieza = id_pieza;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}



	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void quePieza(String nombre, String Color)
	{
	
	
	}


	public abstract boolean validarMovimiento(String a, String b, String color);
	

}
