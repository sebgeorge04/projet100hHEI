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

import o.o.entities.Article;
import o.o.entities.Categories;
import o.o.entities.Comptes;
import o.o.manager.Library;





@WebServlet("/insert")
public class InsertAdminServlet extends AbstractGenericServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("categories", Library.getInstance().listCategories());
	
		templateEngine.process("insertadmin", context, resp.getWriter());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		Integer id_article = Integer.parseInt(req.getParameter("id_article"));
		String description = req.getParameter("description");
		Integer id = Integer.parseInt(req.getParameter("id"));
		
	
		Integer prix = Integer.parseInt(req.getParameter("prix"));
		Categories cat = Library.getInstance().getCategories(id);
		
		
		System.out.println(" ID" + id_article);
		System.out.println(" name" + nom);
        System.out.println("description" + description);
        System.out.println("categorie" + cat);
        System.out.println("prix" +prix);
        
        
		Article article= new Article(cat,id_article,nom,description,prix);
		Article addedArt=Library.getInstance().addArticle(article); 

		
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Récapitulatif: <br/>";
	        htmlRespone += "<h2>Nom de l'article: " + nom + "<br/>";      
	        htmlRespone += "<h2>Description de l'article: " + description + "<br/>";
	        htmlRespone += "<h2>Prix: " + prix + "<br/>";
	        htmlRespone += "<h2>Catégorie: " + cat + "<br/>";
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
	}
}
