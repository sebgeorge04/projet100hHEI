package o.o.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import o.o.entities.Cart;
import o.o.entities.Comptes;
import o.o.manager.Library;

	
@WebServlet("/CartServlet")	
	public class CartServlet extends AbstractGenericServlet {
	//
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	    HttpSession session = request.getSession();
        Cart shoppingCart;
        shoppingCart = (Cart) session.getAttribute("cart");
        if(shoppingCart == null){
          shoppingCart = new Cart();
          session.setAttribute("cart", shoppingCart);
        }
        String nom = request.getParameter("nom");
        Integer prix = Integer.parseInt(request.getParameter("prix"));
        shoppingCart.addToCart(nom, prix);
        session.setAttribute("cart", shoppingCart);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<h1>Article ajouté au panier</h1>");
            out.println("<form action='index.html'>Ajouter d'autres articles au panier?<input type='submit' value='go'></form>");
            out.println("<hr>");
            out.println("<h2>Panier</h2>");
            HashMap<String, Integer> items = shoppingCart.getCartItems();
            out.println("<table border='1px'>");
             
            for(String key: items.keySet()){
                out.println("<tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td></tr>");
            }
            out.println("<table>");
        
             
        }
    } //
	    @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/checkout.html");
	    	view.forward(req, resp);
			
	        HttpSession session = req.getSession();
	        Cart shoppingCart;
	        shoppingCart = (Cart) session.getAttribute("cart");
	        if(shoppingCart == null){
	          shoppingCart = new Cart();
	          session.setAttribute("cart", shoppingCart);
	        }
	        String nom = req.getParameter("nom");
	        Integer prix = Integer.parseInt(req.getParameter("prix"));
	        shoppingCart.addToCart(nom, prix);
	        session.setAttribute("cart", shoppingCart);
	        try (PrintWriter out = resp.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	  
	            out.println("<h1>Article ajouté au panier</h1>");
	            out.println("<form action='manches'>Ajouter d'autres articles au panier?<input type='submit' value='go'></form>");
	            out.println("<hr>");
	            out.println("<h2>Panier</h2>");
	            HashMap<String, Integer> items = shoppingCart.getCartItems();
	            out.println("<table border='1px'>");
	             
	            for(String key: items.keySet()){
	                out.println("<tr><td>"+key+" - </td><td>"+"€"+items.get(key)+"</td></tr>");
	            }
	            out.println("<table>");
	      
	             
	        }
}
}
    
