package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

import CapadeNegocio.ControladorJuego;

/**
 * Servlet implementation class Ldni1
 */
@WebServlet("/Ldni1")
public class Ldni1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ldni1() {
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
		String dni = (String)request.getParameter("dni");
		String nombre = (String)request.getParameter("nombre");
		String apellido = (String)request.getParameter("apellido");
		ControladorJuego ctrl = new ControladorJuego();
		if(ctrl.busquedaUsuario(dni))
		{
		request.setAttribute("errorLogin", "El usuario ya se encuentra registrado");
		request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
		}
		else
		{
	
		ctrl.agregarPersona(dni, nombre, apellido);
		response.sendRedirect("Inicio");
		}
	}

}
