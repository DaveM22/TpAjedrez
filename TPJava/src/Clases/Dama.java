package Clases;

public class Dama extends Pieza {
	public Dama(String id_pieza,String color,String posicion)
	{
		super(id_pieza,color,posicion);
	}

	public boolean validarMovimiento(String a, String b, String color) {
		String letras="abcdefgh";
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int posletra1=letras.indexOf(a.substring(0, 1))+1;
		int posletra2=letras.indexOf(b.substring(0, 1))+1;
		int res1=Math.abs(c-d);
		int res2=Math.abs(posletra1-posletra2);
	
		if((a.substring(0,1).equals(b.substring(0,1)) | c==d )| res1==res2)
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

public class dama extends Pieza {

	public Dama(String posicion, String color) {
		super(posicion, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean esvalidoMovimiento(String a, String b, String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int distancia=Math.abs(c-d);
		if((a.substring(0,1).equals(b.substring(0,1)) | c==d )|(!a.substring(0,1).equals(b.substring(0,1)) && c!=d ))
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
