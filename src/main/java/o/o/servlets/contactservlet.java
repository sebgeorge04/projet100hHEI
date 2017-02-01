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

import o.o.entities.Contact;
import o.o.manager.Library;



@WebServlet("/contact")
public class contactservlet extends AbstractGenericServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
	
		templateEngine.process("contact", context, resp.getWriter());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
	
		String email = req.getParameter("email");
		String sujet	 = req.getParameter("sujet");
		
	
		String message = req.getParameter("message");

		
		
		System.out.println(" name" + nom);
        System.out.println("email" + email);
        System.out.println("sujet" + sujet);
        System.out.println("message" +message);
        
        
		Contact newcontact= new Contact(nom,email,sujet,message);
		Contact addedcontact=Library.getInstance().addContact(newcontact);

		
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Your have uploaded: " + nom + "<br/>";      
	        htmlRespone += "<h2>Your have uploaded: " + email + "<br/>";
	        htmlRespone += "<h2>Your have uploaded: " + sujet + "<br/>";
	        htmlRespone += "<h2>Your have uploaded: " + message + "<br/>";
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
}
}

