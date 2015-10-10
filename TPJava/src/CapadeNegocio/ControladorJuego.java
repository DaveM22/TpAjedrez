package CapadeNegocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import CapaDatos.CatalogoPartida;
import CapaDatos.CatalogoPiezas;
import CapaDeInterfaz.Tablero;
import Clases.Alfil;
import Clases.Caballo;
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
		getPiezas().add(new Caballo("C1","Negro","b1"));
		getPiezas().add(new Caballo("C2","Negro","g1"));
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
		getPiezas().add(new Caballo("C1","Blanco","b8"));
		getPiezas().add(new Caballo("C2","Blanco","g8"));
		for(i=97;i<105;i++)
		{
			getPiezas().add(new Peon("P"+j,"Blanco",(char)i+"7"));
			j++;
		}
		
		
		
	}
	
	
	public void tablero()
	{
		int i;
		int j=1;
		getPiezas().add(new Rey("R","Negro",""));
		getPiezas().add(new Dama("D","Negro",""));
		getPiezas().add(new Alfil("A1","Negro",""));
		getPiezas().add(new Alfil("A2","Negro",""));
		getPiezas().add(new Torre("T1","Negro",""));
		getPiezas().add(new Torre("T2","Negro",""));
		getPiezas().add(new Caballo("C1","Negro",""));
		getPiezas().add(new Caballo("C2","Negro",""));
		for(i=97;i<105;i++)
		{
			getPiezas().add(new Peon("P"+j,"Negro",""));
			j++;
		}
		
		j=1;
		getPiezas().add(new Rey("R","Blanco",""));
		getPiezas().add(new Dama("D","Blanco",""));
		getPiezas().add(new Alfil("A1","Blanco",""));
		getPiezas().add(new Alfil("A2","Blanco",""));
		getPiezas().add(new Torre("T1","Blanco",""));
		getPiezas().add(new Torre("T2","Blanco",""));
		getPiezas().add(new Caballo("C1","Blanco",""));
		getPiezas().add(new Caballo("C2","Blanco",""));
		for(i=97;i<105;i++)
		{
			getPiezas().add(new Peon("P"+j,"Blanco",""));
			j++;
		}
		
		
		
	}
	
	public String mostrarfichasNegras()
	{
		String lista ="";
		for(Pieza i:getPiezas())
		{
			if(i.getColor()=="Negro")
	  lista += i.getClass().getSimpleName()+" "+i.getPosicion()+"\n";
			
		}
		return lista;
	}
	
	public String mostrarfichasBlancas()
	{
		String lista ="";
		for(Pieza i:getPiezas())
		{
			if(i.getColor()=="Blanco")
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
			 JOptionPane.showMessageDialog(null, "Movimiento invalido para la pieza","error",JOptionPane.ERROR_MESSAGE);

	 }
	 else{
	JOptionPane.showMessageDialog(null, "No se encuentra ninguna pieza en la posicion de origen","error",JOptionPane.ERROR_MESSAGE);
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
		boolean dni_1;
		boolean dni_2;
		dni_1=cp.buscarUsuarios(dni1);
		dni_2=cp.buscarUsuarios(dni2);
		if(dni_1==true & dni_2==true)
		cp.agregarPartida(dni1, dni2, color);
		else if(dni_1==false)
			JOptionPane.showMessageDialog(null, "Jugador: "+dni1+" no registrado","Error",JOptionPane.ERROR_MESSAGE);
		else 
			JOptionPane.showMessageDialog(null, "Jugador: "+dni2+" no registrado","Error",JOptionPane.ERROR_MESSAGE);	
			
		
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
		Pieza p=null;
		for(Pieza i:piezas)
		{
			if(i.getPosicion().equals(posdestino))
			{
			p=i;
			}
			
		}
		piezas.remove(p);
		this.buscarPieza(posorigen).setPosicion(posdestino);
	}
	
	public static ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public static void setPiezas()
	{
	piezas.removeAll(piezas);
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
		CatalogoPiezas p = new CatalogoPiezas();
		cp.BorrarPartida(dni1, dni2);
		p.BorrarPosicionesAntiguas(dni1, dni2);
		this.mostrarfichasNegras();
		this.mostrarfichasBlancas();
		
	}
	

	public static Partida getPartidaActual() {
		return PartidaActual;
	}

	public static void setPartidaActual(Partida partidaActual) {
		PartidaActual = partidaActual;
	}
	
	public void eliminarFichasNulas()
	{
		ArrayList<Pieza> cant = new ArrayList<Pieza>();
		for(Pieza i:piezas)
		{
			if(i.getPosicion().equals(""))
			cant.add(i);
		}
		piezas.removeAll(cant);
	}

}
