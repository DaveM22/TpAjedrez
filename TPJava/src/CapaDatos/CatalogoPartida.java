package CapaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogoPartida {
	public void agregarPartida(String dni1 , String dni2, String color)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into partida(dni1,dni2,turno) values (?,?,?)");
		    stmt.setString(1, dni1);
		    stmt.setString(2, dni2);
		    stmt.setString(3, color);
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
	
	
	public boolean buscarPartida(String dni1, String dni2)
	{
		boolean respuesta=false;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from partida where dni1=? and dni2=?");
		    stmt.setString(1, dni1);
		    stmt.setString(2, dni2);
		    rs=stmt.executeQuery();
		    if(rs!=null && rs.next())
		    respuesta = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null ) 
					{
					rs.close();
					
					}
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return respuesta;
	}

}
