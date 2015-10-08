package CapaDatos;
import java.sql.*;
import java.util.ArrayList;

import CapaDatos.FactoryConexion;
import CapadeNegocio.ControladorJuego;
import Clases.Alfil;
import Clases.Peon;
import Clases.Pieza;
import Clases.Rey;

public class CatalogoPiezas {
	

	
	
	public void asignarPiezasBD(Pieza p, String dni1,String dni2)
	{
	ResultSet rs = null;
	PreparedStatement stmt = null;
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into piezas(dni1,dni2,id_pieza,pieza,color,posicion) values (?,?,?,?,?,?)");
		stmt.setString(1, dni1);
		stmt.setString(2, dni2);
		stmt.setString(3, p.getId_pieza());
	    stmt.setString(4, p.getClass().getSimpleName());
	    stmt.setString(5, p.getColor());
	    stmt.setString(6, p.getPosicion());
	    stmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(rs!=null ) rs.close();
			if(stmt != null) stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FactoryConexion.getInstancia().releaseConn();
	}
}
	
	public void guardarPiezasBD(Pieza p, String dni1,String dni2)
	{
	ResultSet rs = null;
	PreparedStatement stmt = null;
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update personas set id_pieza=?,pieza=?,color=?,posicion=? where dn1=? and dni2=? (?,?,?,?,?,?)");
		stmt.setString(1, p.getId_pieza());
	    stmt.setString(2, p.getClass().getSimpleName());
	    stmt.setString(3, p.getColor());
	    stmt.setString(4, p.getPosicion());
	    stmt.setString(5, dni1);
		stmt.setString(6, dni2);
	    stmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(rs!=null ) rs.close();
			if(stmt != null) stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FactoryConexion.getInstancia().releaseConn();
	}
}
	
	
	
	public void traerPosicionesBD(String dni1, String dni2)
	{
	ControladorJuego ctrl = new ControladorJuego();
    ArrayList<Pieza> listado = new ArrayList<Pieza>();
	ResultSet rs = null;
	Pieza p = null;
	
	PreparedStatement stmt = null;
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select id_pieza,pieza,posicion,color from piezas where dni1=? and dni2=? ");
	    stmt.setString(1, dni1);
	    stmt.setString(2, dni2);
		rs=stmt.executeQuery();

	while(rs.next()&& rs!=null)
	{
     for(Pieza i:ControladorJuego.getPiezas())
     {
    	 if((i.getClass().getSimpleName().equals(rs.getString("pieza")))&&(i.getColor().equals(rs.getString("color")))&&(i.getId_pieza().equals(rs.getString("id_pieza"))))
    			 {
    		 i.setPosicion(rs.getString("posicion"));
    		
    			 }
     }
	
	}
	ControladorJuego.getPiezas().addAll(listado);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try {
			if(rs!=null ) rs.close();
			if(stmt != null) stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FactoryConexion.getInstancia().releaseConn();
	}

}
	
	
	
	
	public void BorrarPosicionesAntiguas(String dni1,String dni2)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from piezas where dni1=? and dni2=?");
		    stmt.setString(1, dni1);
		    stmt.setString(2, dni2);
		    stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
	}
	
	}



	





