package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClientService;
import service.IClientService;

/**
 * Servlet implementation class SupprimerClient
 */
@WebServlet("/SupprimerClient")
public class SupprimerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
				
		//1- R�cup�ration les param�tres
		int id = Integer.parseInt(request.getParameter("id"));
		//2- Traitement avec la couche service
		IClientService cs = new ClientService();
		cs.supprimerClient(id);
		
		//3- Pr�paration de l'envoi
		// Premier param�tre : nom de l'attribut que l'on veut envoyer � la JSP
		// Deuxi�me param�tre : objet que l'on veut envoyer
		// En g�n�ral, on met le m�me nom pour les deux param�tres
		//4 Envoi � la JSP
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
