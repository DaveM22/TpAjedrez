package Servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import CapadeNegocio.ControladorJuego;
import Clases.Partida;
import Clases.Pieza;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ControladorJuego ctrl = new ControladorJuego();
		String dni1=(String)request.getSession().getAttribute("dni1");
		String dni2=(String)request.getSession().getAttribute("dni2");
		String color;
		if(ctrl.busquedaUsuario(dni1)==false)
		{
			request.getSession().setAttribute("dniRegistrar", dni1);
			request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
		}
		else
		{
				
		
		
			if(ctrl.busquedaUsuario(dni2)==false)
		{
				request.getSession().setAttribute("dniRegistrar", dni2);
				request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
		}
			else
			{
	          if(ctrl.partidaPendiente(dni1, dni2))
	          {
	          ctrl.terminarPartida(dni1, dni2);
	          ctrl.borrarPiezas(dni1, dni2);
	          }
				ControladorJuego.limpiarArray();
				ctrl.inicializatablero();
				ctrl.nuevoJuego(dni1, dni2, "Blanco");
				ctrl.asignarPiezas(dni1, dni2);
				request.getSession().setAttribute("color","Blanco");
				request.setAttribute("error", "");
				request.getSession().setAttribute("listado", ControladorJuego.getPiezas());
				request.getRequestDispatcher("Movimientos.jsp").forward(request,response);
				}
				}
			}
		
		
		}
		
			
		
	


