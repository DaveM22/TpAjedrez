package CapadeNegocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import CapaDatos.CatalogoPartida;
import CapaDatos.CatalogoPiezas;
import CapaDeInterfaz.Tablero;
import Clases.Alfil;
import Clases.Dama;
import Clases.Partida;
import Clases.Peon;
import Clases.Pieza;
import Clases.Rey;
import Clases.Torre;

public class ControladorJuego {
private static Partida PartidaActual;
private static  ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ControladorJuego ctrl = new ControladorJuego();
Tablero frame1 = new Tablero();
frame1.setVisible(true);

	}
	
	public void inicializatablero()
	{
		int i;
		int j=1;
		getPiezas().add(new Rey("R","Negro","d1"));
		getPiezas().add(new Dama("D","Negro","e1"));
		getPiezas().add(new Alfil("A1","Negro","c1"));
		getPiezas().add(new Alfil("A2","Negro","f1"));
		getPiezas().add(new Torre("T1","Negro","a1"));
		getPiezas().add(new Torre("T2","Negro","h1"));
		for(i=97;i<105;i++)
		{
			getPiezas().add(new Peon("P"+j,"Negro",(char)i+"2"));
			j++;
		}
		
		j=1;
		getPiezas().add(new Rey("R","Blanco","d8"));
		getPiezas().add(new Dama("D","Blanco","e8"));
		getPiezas().add(new Alfil("A1","Blanco","c8"));
		getPiezas().add(new Alfil("A2","Blanco","f8"));
		getPiezas().add(new Torre("T1","Blanco","a8"));
		getPiezas().add(new Torre("T2","Blanco","h8"));
		for(i=97;i<105;i++)
		{
			getPiezas().add(new Peon("P"+j,"Blanco",(char)i+"7"));
			j++;
		}
		
		
		
	}
	
	public String mostrarfichasNegras()
	{
		String lista ="";
		for(Pieza i:getPiezas())
		{
			if(i.getColor()=="Negro" && i.getPosicion()!="")
	  lista += i.getClass().getSimpleName()+" "+i.getPosicion()+"\n";
		}
		return lista;
	}
	
	public String mostrarfichasBlancas()
	{
		String lista ="";
		for(Pieza i:getPiezas())
		{
			if(i.getColor()=="Blanco" && i.getPosicion()!="")
	  lista += i.getClass().getSimpleName()+" "+i.getPosicion()+"\n";
		}
		return lista;
	}
	
	
	public String realizarMovimiento(String posicionori,String posiciondes,String color)
	{
	 Pieza origen = buscarPieza(posicionori);
	 Pieza destino = buscarPieza(posiciondes);
	 if(origen!=null)
	 {
		 if(origen.validarMovimiento(posicionori,posiciondes, color)&& origen.getColor().equals(color))
		 {
			 if(destino!=null)
			 {
				 if(destino.getColor()!=origen.getColor() )
				 {
				 this.DescontarPieza(posicionori, posiciondes);
				 if(color.equals("Blanco"))
					 return "Negro";
				 else
					 return "Blanco";
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "Movimiento invalido: Las piezas son del mismo color","error",JOptionPane.ERROR_MESSAGE);
				 return color;
				 }
			 }
			 else
			 {
			 this.nuevaPosicion(origen, posiciondes);
			 
			 if(color.equals("Blanco"))
				 return "Negro";
			 else
				 return "Blanco";
			 }
		 }
		 else
			 JOptionPane.showMessageDialog(null, "Movimiento invalido","error",JOptionPane.ERROR_MESSAGE);

	 }
	return color;
	}
	
	
	public Pieza buscarPieza(String posicion)
	{
		for(Pieza i:getPiezas())
		{
		if(i.getPosicion().equals(posicion) )
           return i;
		}
		return null;
	}
	
	public void nuevaPosicion(Pieza p,String destino)
	{
		for(Pieza i:getPiezas())
		{
			if(i.equals(p))
			{
				i.setPosicion(destino);
			}
		}
	}
	
	
	public void nuevoJuego(String dni1,String dni2,String color)
	{
		CatalogoPartida cp = new CatalogoPartida();
		cp.agregarPartida(dni1, dni2, color);
	}
	
	public void asignarPiezas(String dni1,String dni2)
	{
		CatalogoPiezas cp = new CatalogoPiezas();
		for(Pieza i:getPiezas())
		{
		cp.asignarPiezasBD(i,dni1,dni2);
	}
	
	}
	
	
	
	public boolean partidaPendiente(String dni1,String dni2)
	{
		CatalogoPartida cp = new CatalogoPartida();
		return cp.buscarPartida(dni1, dni2);
	}
	

	public void traerPosiciones(String dni1,String dni2)
	{
		CatalogoPiezas cp = new CatalogoPiezas();
		cp.traerPosicionesBD(dni1, dni2);
	}



	
	public void borrarPiezas(String dni1,String dni2)
	{
		CatalogoPiezas cp = new CatalogoPiezas();
		cp.BorrarPosicionesAntiguas(dni1, dni2);
	}
	
	
	public void DescontarPieza(String posorigen,String posdestino)
	{
		for(Pieza i:piezas)
		{
			if(i.getPosicion().equals(posdestino))
			i.setPosicion("");
			
		}
		this.buscarPieza(posorigen).setPosicion(posdestino);
	}
	
	public static ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public static void setPiezas()
	{
	ControladorJuego.piezas=null;
	}
	
	public Pieza estadoReyN()
	{
		for(Pieza i:piezas)
		{
		if(i.getClass().getSimpleName().equals("Rey")&&i.getColor().equals("Negro"))
			return i;
		}
		return null;
	}
	
	public Pieza estadoReyB()
	{
		for(Pieza i:piezas)
		{
		if(i.getClass().getSimpleName().equals("Rey")&&i.getColor().equals("Blanco"))
			return i;
		}
		return null;
	}
	
	public void terminarPartida(String dni1,String dni2)
	{
		CatalogoPartida cp = new CatalogoPartida();
		cp.BorrarPartida(dni1, dni2);
	}
	
	/*
	public String asignarUltimoTurno(String dni1,String dni2)
	{
		CatalogoPartida cp = new CatalogoPartida();
		return (cp.UltimoTurno(dni1, dni2));
	}
*/
	public static Partida getPartidaActual() {
		return PartidaActual;
	}

	public static void setPartidaActual(Partida partidaActual) {
		PartidaActual = partidaActual;
	}

}
