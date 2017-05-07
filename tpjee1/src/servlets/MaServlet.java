package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		/*String[] lesLoisirs=request.getParameterValues("loisirs");
		response.getWriter().append("Served at: ").append(request.getContextPath())
		.append("\n Customer Address: ").append(request.getRemoteAddr())
		.append("\n Nom : ").append(request.getParameter("nom"))
		.append("\n Prenom : ").append(request.getParameter("prenom"))
		.append("\n Mot de passe : ").append(request.getParameter("mdp"))
		.append("\n Loisirs : ");
		
		for(String l : lesLoisirs)
		{
			response.getWriter().append(l+"\n");
		}*/
		
		//1- R�cup�ration les param�tres
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mdp = request.getParameter("mdp");
		String[] lesLoisirs = request.getParameterValues("loisirs");
		//2- Traitement avec la couche service
		
		//3- Pr�paration de l'envoi
		// Premier param�tre : nom de l'attribut que l'on veut envoyer � la JSP
		// Deuxi�me param�tre : objet que l'on veut envoyer
		// En g�n�ral, on met le m�me nom pour les deux param�tres
		request.setAttribute("lenom", nom);
		request.setAttribute("leprenom", prenom);
		request.setAttribute("lemdp", mdp);
		request.setAttribute("lesloisirs", lesLoisirs);
		
		//4 Envoi � la JSP
		request.getRequestDispatcher("/resultat.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
