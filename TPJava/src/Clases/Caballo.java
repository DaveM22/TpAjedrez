package Clases;

public class Caballo extends Pieza{
	
	public Caballo(String id_pieza,String color,String posicion)
	{
		super(id_pieza,color,posicion);
	}
	public boolean validarMovimiento(String a, String b, String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
        int distancia=Math.abs(c-d);
        if((!a.substring(0,1).equals(b.substring(0,1))& distancia==2) |(!a.substring(0,1).equals(b.substring(0,1))& distancia==1))
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
}


/*
 package Clases;

public class Caballo extends Pieza {

	public Caballo(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esvalidoMovimiento(String a, String b, String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
        int distancia=Math.abs(c-d);
        if(!a.substring(0,1).equals(b.substring(0,1))& distancia==2)
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}

}
 */
