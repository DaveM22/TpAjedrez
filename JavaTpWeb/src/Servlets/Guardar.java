package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CapadeNegocio.ControladorJuego;
import Clases.Pieza;

/**
 * Servlet implementation class Guardar
 */
@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guardar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dni1=(String)request.getSession().getAttribute("dni1");
		String dni2=(String)request.getSession().getAttribute("dni2");
		String color=(String)request.getSession().getAttribute("color");
		ArrayList<Pieza> piezas = (ArrayList<Pieza>)request.getSession().getAttribute("listado");
		ControladorJuego ctrl = new ControladorJuego();
		ControladorJuego.importarArray(piezas);
		ctrl.terminarPartida(dni1, dni2);
		ctrl.borrarPiezas(dni1, dni2);
		ctrl.nuevoJuego(dni1, dni2, color);
		ctrl.asignarPiezas(dni1, dni2);
		request.setAttribute("error", "La partida ha sido guardada existosamente");
		request.getRequestDispatcher("Movimientos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
