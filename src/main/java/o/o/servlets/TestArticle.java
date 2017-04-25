package o.o.servlets;

import java.io.IOException;


import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import o.o.entities.Article;
import o.o.manager.Library;



@WebServlet("/article")
public class TestArticle extends AbstractGenericServlet {

	private static final long serialVersionUID = 4127160026348238231L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
				
		Integer id_article = Integer.parseInt(req.getParameter("id_article"));
		Article article = Library.getInstance().getArticle(id_article);
		context.setVariable("article", article);
	
		
		templateEngine.process("single", context, resp.getWriter());
	}
}