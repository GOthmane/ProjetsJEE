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
 * Servlet implementation class ModifierClient
 */
@WebServlet("/ModifierClient")
public class ModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
				
		//1- Récupération les paramètres
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String couleurYeux = request.getParameter("couleurYeux");
		int age = Integer.parseInt(request.getParameter("age"));
		//2- Traitement avec la couche service
		IClientService cs = new ClientService();
		cs.modifierClient(id, nom, prenom, couleurYeux, age);
		//3- Préparation de l'envoi
		// Premier paramètre : nom de l'attribut que l'on veut envoyer à la JSP
		// Deuxième paramètre : objet que l'on veut envoyer
		// En général, on met le même nom pour les deux paramètres
		
		//4 Envoi à la JSP
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
