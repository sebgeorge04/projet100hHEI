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





@WebServlet("/newcat")
public class NewCategorie extends AbstractGenericServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("categories", Library.getInstance().listCategories());
	
		templateEngine.process("newcategorie", context, resp.getWriter());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
	
		Integer id = Integer.parseInt(req.getParameter("id"));
		
	

		
		
		System.out.println(" ID" + id);
		System.out.println(" nom" + nom);
      
        
        
		Categories categorie= new Categories(id,nom);
		Categories addedcat=Library.getInstance().addCategories(categorie); 

		
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Récapitulatif: <br/>";
	        htmlRespone += "<h2>Nom de la categorie: " + nom + "<br/>";      
	        htmlRespone += "<h2>ID de la catégorie: " +id  + "<br/>";
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
	}
}