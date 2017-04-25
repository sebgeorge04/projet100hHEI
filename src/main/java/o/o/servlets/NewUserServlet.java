package o.o.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import o.o.entities.Comptes;
import o.o.manager.Library;


@WebServlet("/adduser")
public class NewUserServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 4982865059712541281L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
	
	
		templateEngine.process("register", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
	
		String prenom = req.getParameter("prenom");
		String motdepasse	 = req.getParameter("motdepasse");
		
	
		String email = req.getParameter("email");

		
		
		System.out.println(" name" + nom);
        System.out.println("prenom" + prenom);
        System.out.println("motdepasse" + motdepasse);
        System.out.println("email" +email);
        
        
		Comptes newcompte= new Comptes(nom,prenom,motdepasse,email,0,1);
		Comptes addedActor=Library.getInstance().addComptes(newcompte);

		
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Récapitulatif: <br/>";
	        htmlRespone += "<h2>Nom du client: " + nom + "<br/>";      
	        htmlRespone += "<h2>Prenom du client: " + prenom + "<br/>";
	        htmlRespone += "<h2>Votre login: " + email + "<br/>";
	        htmlRespone += "<h2>Votre mot de passe : " + motdepasse + "<br/>";
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
	}
}
