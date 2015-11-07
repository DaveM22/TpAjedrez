package Clases;

import CapadeNegocio.ControladorJuego;

public class Peon extends Pieza {
	
	
	public Peon(String id_pieza,String color,String posicion)
	{
		super(id_pieza,color,posicion);
	}
	boolean primerMovimiento;
	public  boolean validarMovimiento(String a, String b,String color) {
		int c=Integer.parseInt(a.substring(1));  //analizo la parte numerica de la posicion(cadena)
		int d=Integer.parseInt(b.substring(1));  //analizo la parte numerica de la posicion(cadena)
	    ControladorJuego cp = new ControladorJuego();
	int distancia = color.contentEquals("Blanco")? (c-d) : (d-c);  //Hago la pregunta de que color es
	if((distancia==2 & c==7 & color=="Blanco"))
	return true;
	else
	{
	if(distancia==1 && !a.substring(0,1).equals(b.substring(0,1)) && c!=d && cp.buscarPieza(b)!=null )                                               //el calculo de la distancia dependera de que color sea,esto se debe
		                                                             // a como avanzan las fichas blancas y las negras entonces sera 
		                                                             // un movimiento valido si la distancia entre que recorre es 1	                                                             // si la distancia es negativa recorreria hacia atras y no es valido
	{
		return true;
	}
	else
	{
      if(distancia==1 && a.substring(0,1).equals(b.substring(0,1)) && c!=d && cp.buscarPieza(b)==null)
    	  return true;
      else return false;
	}
	}
	}




}


 


