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

import o.o.daos.ArticleDaoImpl;
import o.o.entities.Article;
import o.o.entities.Categories;
import o.o.entities.Comptes;
import o.o.manager.Library;






@WebServlet("/delete")
public class DeleteServlet extends AbstractGenericServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("categories", Library.getInstance().listCategories());
	
		templateEngine.process("deleteadmin", context, resp.getWriter());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_article = Integer.parseInt(req.getParameter("id_article"));
		
		ArticleDaoImpl articleDao = new ArticleDaoImpl();

		articleDao.deleteArticle(id_article);
		
		System.out.println("article" + id_article);
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Your have deleted the actor n°: " + id_article + "<br/>";      
	       
	        
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
}
}

