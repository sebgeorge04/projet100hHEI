package o.o.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import o.o.daos.LoginDao;
@WebServlet("/connexiontest")
public class ServletTestConnexion extends AbstractGenericServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
	
		templateEngine.process("login", context, resp.getWriter());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException { 
		
		
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("email");  
	    String p=request.getParameter("motdepasse");  
	    request.getSession().setAttribute("utilisateurConnecte", n);
	    
	    if(LoginDao.validate(n, p)){  
	    	if(request.getParameter("email").equals("admin")){ response.sendRedirect("admin");
	    	
	    	}else {
	        response.sendRedirect("welcome"); }
	    }  
	 
	    
	    else{  
	        out.print("Mauvais Login ou password");  
	       response.sendRedirect("connexiontest");
	    }  
	          
	    out.close();  
	    }  
}

