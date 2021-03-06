package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CapadeNegocio.ControladorJuego;

/**
 * Servlet implementation class AsignarSesion
 */
@WebServlet("/AsignarSesion")
public class AsignarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignarSesion() {
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
		String dni1=(String)request.getParameter("dni1");
		String dni2=(String)request.getParameter("dni2");
		request.getSession().setAttribute("dni1", dni1);
		request.getSession().setAttribute("dni2", dni2);
		ControladorJuego ctrl = new ControladorJuego();
		if(ctrl.partidaPendiente(dni1, dni2))
		request.getRequestDispatcher("Partidapendiente.jsp").forward(request, response);
		else
		request.getRequestDispatcher("/Inicio").forward(request, response);
		
		
		
	}

}
