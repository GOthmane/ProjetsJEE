package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ClientService;
import service.IClientService;

/**
 * Servlet implementation class AjouterClient
 */
@WebServlet("/AjouterClient")
public class AjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClientService cs = new ClientService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterClient() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String couleurYeux = request.getParameter("couleurYeux");
		int age = Integer.parseInt(request.getParameter("age"));
		//2- Traitement avec la couche service
		Client c = new Client();
		c.setNom(nom);c.setPrenom(prenom);c.setCouleurYeux(couleurYeux);c.setAge(age);
		cs.ajouterClient(c);
		//3- Pr�paration de l'envoi
		// Premier param�tre : nom de l'attribut que l'on veut envoyer � la JSP
		// Deuxi�me param�tre : objet que l'on veut envoyer
		// En g�n�ral, on met le m�me nom pour les deux param�tres
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		//4 Envoi � la JSP
		request.getRequestDispatcher("/resultatAjouterClient.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
