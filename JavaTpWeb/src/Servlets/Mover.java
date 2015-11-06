package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import CapadeNegocio.ControladorJuego;
import Clases.Pieza;
import Excepciones.MovInvalidoException;
import Excepciones.appException;

/**
 * Servlet implementation class Mover
 */
@WebServlet("/Mover")
public class Mover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mover() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ControladorJuego ctrl = new ControladorJuego();
		String posori=(String)request.getParameter("posori");
		String posdes=(String)request.getParameter("posdes");
		String color=(String)request.getSession().getAttribute("color");
		String dni1=(String)request.getSession().getAttribute("dni1");
		String dni2=(String)request.getSession().getAttribute("dni2");
		String LetrasValidas="abcdefgh";
	    String NumerosValidos="12345678";
	    ArrayList<Pieza> piezas;
	    piezas=null;
		piezas =(ArrayList<Pieza>)request.getSession().getAttribute("listado");
		ControladorJuego.importarArray(piezas);
		
		if(posori.equals("") | posdes.equals(""))
		{
			request.setAttribute("error","Una o ambas posiciones son nulas. \n Complete los campos faltantes");
			request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
		}
		else
			if(posori.length()==2 & (LetrasValidas.contains(posori.substring(0, 1)) & NumerosValidos.contains(posori.substring(1)))  & (posdes.length()==2 &  LetrasValidas.contains(posdes.substring(0, 1)) & NumerosValidos.contains(posdes.substring(1))))
			{
		try {
			color=ctrl.realizarMovimiento(posori, posdes, color);
			if(ctrl.estadoReyB()==null)
			{
				ControladorJuego.limpiarArray();
				ctrl.terminarPartida(dni1, dni2);
				request.setAttribute("ganador",dni2);
				request.getRequestDispatcher("Ganador.jsp").forward(request, response);
			}
			else
			{
			   if(ctrl.estadoReyN()==null)
			   {
				   ControladorJuego.limpiarArray();
				   ctrl.terminarPartida(dni1, dni2);
				   request.setAttribute("ganador", dni1);
				   request.getRequestDispatcher("Ganador.jsp").forward(request, response);
			   }
			   else
			   {
			request.getSession().setAttribute("color", color);
			request.getSession().setAttribute("listado", ControladorJuego.getPiezas());
			request.setAttribute("error","");
			request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
			   }
			}
		} catch (MovInvalidoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMensaje());
			request.getRequestDispatcher("Movimientos.jsp").forward(request,response);
		}
			}
			else	
			{
				request.setAttribute("error","Una o las posiciones no pertencen al tablero");
				request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
			}
	    /*
		try {
			color=ctrl.realizarMovimiento(posori, posdes, color);
		    request.getSession().setAttribute("color", color);
		    request.getSession().setAttribute("listado", piezas);
		    request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
		} catch (appException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
	

}
