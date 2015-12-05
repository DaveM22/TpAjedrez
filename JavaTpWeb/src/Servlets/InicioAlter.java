package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CapadeNegocio.ControladorJuego;

/**
 * Servlet implementation class InicioAlter
 */
@WebServlet("/InicioAlter")
public class InicioAlter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioAlter() {
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
		
		    ControladorJuego.limpiarArray();
			ctrl.tablero();
			ctrl.traerPosiciones(dni1, dni2);
			ctrl.eliminarFichasNulas();
	        color=ControladorJuego.getPartidaActual().getTurno();
			request.getSession().setAttribute("listado", ControladorJuego.getPiezas());
			request.getSession().setAttribute("color",color);
			request.setAttribute("error", "");
			request.getRequestDispatcher("Movimientos.jsp").forward(request,response);
		 
	
	}
}
