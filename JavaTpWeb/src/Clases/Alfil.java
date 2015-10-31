package Clases;



public class Alfil extends Pieza{
	
	public Alfil(String id_pieza,String color,String posicion)
	{
		super(id_pieza,color,posicion);
	}
	
	public  boolean validarMovimiento(String a, String b, String color)
	{
	String letras="abcdefgh";
	int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
	int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	int posletra1=letras.indexOf(a.substring(0, 1))+1;
	int posletra2=letras.indexOf(b.substring(0, 1))+1;
	int res1=Math.abs(c-d);
	int res2=Math.abs(posletra1-posletra2);
	if(res1==res2)
	return true;
	else return false;
	}
}