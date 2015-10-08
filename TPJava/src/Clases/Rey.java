package Clases;

public class Rey extends Pieza {
public Rey(String id_pieza,String color,String posicion)
{
	super(id_pieza,color,posicion);
}

	public  boolean validarMovimiento(String a,String b,String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distancia=Math.abs(c-d); //Hago un valor absoluto de la distancia entre el origen y destino
        
		if(distancia==1 || distancia==0)     //Como es rey la distancia en valor absoluto 
        {                                    //Debe ser 1 en una direccion que no sea sobre la misma fila
        	return true; //O puede ser 0 si se mueve dentro de su misma fila
        }
        else
        {
        	return false;
        }

	}


}


/*
 public Rey(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esvalidoMovimiento(String a,String b,String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distancia=Math.abs(c-d); //Hago un valor absoluto de la distancia entre el origen y destino
        
		if(distancia==1 || distancia==0)     //Como es rey la distancia en valor absoluto 
        {                                    //Debe ser 1 en una direccion que no sea sobre la misma fila
        	return true; //O puede ser 0 si se mueve dentro de su misma fila
        }
        else
        {
        	return false;
        }

	}

}

 */
