package o.o.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import o.o.entities.Article;
import o.o.entities.Categories;
import o.o.manager.Library;


@WebServlet("/list")
public class ListArticles extends AbstractGenericServlet {

	private static final long serialVersionUID = -4105724410207270827L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Article> articlesList =Library.getInstance().listArticles();
		List<Categories> catList =Library.getInstance().listCategories();
		
		context.setVariable("articles", articlesList);
		context.setVariable("categories", catList);


		templateEngine.process("listadmin", context, resp.getWriter());
	}
}

