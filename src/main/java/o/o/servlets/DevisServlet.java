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
import o.o.entities.Devis;
import o.o.manager.Library;


@WebServlet("/devis")
public class DevisServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 4982865059712541281L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
	
	
		templateEngine.process("devis", context, resp.getWriter());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
	
		String prenom = req.getParameter("prenom");
		String corps = req.getParameter("corps");
		String sens = req.getParameter("sens");
		String micros = req.getParameter("micros");
		String finition = req.getParameter("finition");
		String dessin = req.getParameter("dessin");
		String chevalet = req.getParameter("chevalet");
		String mecaniques = req.getParameter("mecaniques");
		String commentaires = req.getParameter("commentaires");
		Integer tel = Integer.parseInt(req.getParameter("tel"));
		Integer frettes = Integer.parseInt(req.getParameter("frettes"));
		
	
		
		
		
		
		System.out.println("prenom"+prenom);
		System.out.println(" name" + nom);
        System.out.println("tel" + tel);
        System.out.println("corps" + corps);
        System.out.println("sens" +sens);
        System.out.println("micros"+micros);
		System.out.println(" frettes" + frettes);
        System.out.println("finition" + finition);
        System.out.println("dessin" + dessin);
        System.out.println("chevalet" +chevalet);
        System.out.println("mecaniques" + mecaniques);
        System.out.println("commentaires" +commentaires);
        
        
		Devis devis= new Devis(null,nom,prenom,tel,corps,sens,micros,frettes,finition,dessin,chevalet,mecaniques,commentaires);
		Devis addeddev=Library.getInstance().addDevis(devis); 

		
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Récapitulatif: <br/>";
	        htmlRespone += "<h2>Nom : " + nom + "<br/>";      
	        htmlRespone += "<h2>Prenom: " + prenom + "<br/>";
	        htmlRespone += "<h2>tel: " + tel + "<br/>";
	        htmlRespone += "<h2>Corps: " + corps + "<br/>";
	        htmlRespone += "<h2>sens: " + sens + "<br/>";      
	        htmlRespone += "<h2>micros: " + micros + "<br/>";
	        htmlRespone += "<h2>frettes: " + frettes + "<br/>";
	        htmlRespone += "<h2>finition: " + finition + "<br/>";
	        htmlRespone += "<h2>dessin: " + dessin + "<br/>";      
	        htmlRespone += "<h2>chevalet: " + chevalet + "<br/>";
	        htmlRespone += "<h2>mecaniques: " + mecaniques + "<br/>";
	        htmlRespone += "<h2>commentaires: " + commentaires + "<br/>";
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
	}
}