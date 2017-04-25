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
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
	    	TemplateEngine templateEngine = this.createTemplateEngine(req);
	        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
	        templateResolver.setCharacterEncoding("UTF-8");
			WebContext context = new WebContext(req, resp, req.getServletContext());
			
		
	    	HttpSession session = req.getSession();
	        Cart shoppingCart;
	        shoppingCart = (Cart) session.getAttribute("cart");
	        if(shoppingCart == null){
	          shoppingCart = new Cart();
	          session.setAttribute("cart", shoppingCart);
	        }
	        String name = req.getParameter("nom");
	        Integer price = Integer.parseInt(req.getParameter("prix"));
	        shoppingCart.addToCart(name, price);
	        session.setAttribute("cart", shoppingCart);
	        try (PrintWriter out = resp.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>result</title>");       
	            out.println("<link href='css/bootstrap.css' rel='stylesheet' type='text/css' />");
	            out.println("<link href='css/style.css' rel='stylesheet' type='text/css' />");
	            out.println("<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>");
	            out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
	            out.println("<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>");
	            out.println("<script type='application/x-javascript'> addEventListener('load', function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>");
	            out.println("<script src='js/jquery.min.js'></script>");
	           //metre le javascript//
	            out.println("</head>");
	            out.println("<body>");
	        	out.println("<div class='header'>");
	        	out.println("<div class='container'>");
	        	out.println("<div class='row'>");
	        	out.println("<div class='col-md-12'>");
	        	out.println("<div class='header-left'>");
	        	out.println("<div class='logo'>");
	        	out.println("<a href='index.html'><img src='images/logo.png' alt=''/></a>");
	        	out.println("</div>");
	        	out.println("<div class='menu'>");
	        	out.println("<a class='toggleMenu' href='#'><img src='images/nav.png' alt='' /></a>");
	        	out.println("<ul class='nav' id='nav'>");
	        	out.println("<li><a href='shop.html'>Shop</a></li>");
	        	out.println("<li><a href='team.html'>Team</a></li>");
	        	out.println("<li><a href='shop.html'>Events</a></li>");
	        	out.println("<li><a href='experiance.html'>Experiance</a></li>");
	        	out.println("<li><a href='shop.html'>Company</a></li>");
	        	out.println("<li><a href='contact.html'>Contact</a></li>");
	        	out.println("<div class='clear'></div>");
	        	out.println("</ul>");
	        	out.println("<script type='text/javascript' src='js/responsive-nav.js'></script>");
	        	out.println(" </div>");
	        	out.println("<div class='clear'></div>");
	        	out.println("</div>");
	        	out.println("<div class='header_right'>");
	        	out.println("<div class='search-box'>");
	        	out.println("<div id='sb-search' class='sb-search'>");
	        	out.println("<form>");
	        	out.println("<input class='sb-search-input' placeholder='Enter your search term...' type='search' name='search' id='search'>");
	        	out.println("<input class='sb-search-submit' type='submit' value=''>");
	        	out.println("<span class='sb-icon-search'> </span>");
	        	out.println("</form>");
	        	out.println("</div>");
	        	out.println("</div>");
	        	out.println("<script src='js/classie.js'></script>");
	        	out.println("<script src='js/uisearch.js'></script>");
	        	out.println("<script>");
	        	out.println("new UISearch( document.getElementById( 'sb-search' ) );");
	        	out.println("</script>");
	        	out.println(" <ul class='icon1 sub-icon1 profile_img'>");
	        	out.println("<li><a class='active-icon c1' href='#'> </a>");
	        	out.println("<ul class='sub-icon1 list'>");
	        	out.println("<div class='product_control_buttons'>");
	        	out.println("<a href='#'><img src='images/edit.png' alt=''/></a>");
	        	out.println("<a href='#'><img src='images/close_edit.png' alt=''/></a>");
	        	out.println("</div>");
	        	out.println("<div class='clear'></div>");
	        	out.println("<li class='list_img'><img src='images/1.jpg' alt=''/></li>");
	        	out.println("<li class='list_desc'><h4><a href='#'>velit esse molestie</a></h4><span class='actual'>1 x$12.00</span></li>");
	        	out.println("<div class='login_buttons'>");
	        	out.println("<div class='check_button'><a href='checkout.html'>Check out</a></div>");
	        	out.println("<div class='login_button'><a href='login.html'>Login</a></div>");
	        	out.println("<div class='clear'></div>");
	        	out.println("</div>");
	        	out.println("<div class='clear'></div>");
	        	out.println("</ul>");
	        	out.println("</li>");
	        	out.println("</ul>");
	        	out.println("<div class='clear'></div>");
	        	out.println("</div>");
	        	out.println("</div>");
	        	out.println("</div>");
	        	out.println("</div>");
	        	out.println("</div>");
	        	//
	        	out.println("<div class='main'>");
	        out.println("<div class='shop_top'>");
	       	 out.println("<div class='container'>");
	            out.println("<h2>Article ajoute au panier</h2>");
	            out.println("Ajouter d'autres articles <a href='index.html'>Accueil</a>");
	            out.println("<hr>");
	            out.println("<h2>Panier</h2>");
	            
	            HashMap<String, Integer> items = shoppingCart.getCartItems();
	            out.println("<table border='1px'>");
	             
	            for(String key: items.keySet()){
	          
	                out.println("<form action='deleteItem'><input type='hidden' name='name' value='"+key+"'><tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td><td><input type='submit' value='delete'></td></tr></form>");
	            }
	            
	             out.println("</table>");
	             out.println("</br>");
	             out.println("</br>");
	             out.println("<a href='coordonnees'>Paiement</a>");
	            out.println("</div>");
	            
	            out.println("</div>");
	            
	            out.println("</div>");
	          //  out.println("</table>"); //rajouté
	            
	            out.println("</div>"); // rajouté
	            
	            out.println("<div class='footer'>");
	            out.println("<div class='container'>");
	            out.println("<div class='row'>");
	            out.println("<div class='col-md-3'>");
	            out.println("<ul class='footer_box'>");
	            out.println("<h4>Products</h4>");
	            out.println("<li><a href='#'>Mens</a></li>");
	            out.println("<li><a href='#'>Womens</a></li>");
	            out.println("<li><a href='#'>Youth</a></li>");
	            out.println("</ul>");
	            out.println("</div>");
	            out.println("<div class='col-md-3'>");
	            out.println("<ul class='footer_box'>");
	            out.println("<h4>About</h4>");
	            out.println("<li><a href='#'>Careers and internships</a></li>");
	            out.println("<li><a href='#'>Sponserships</a></li>");
	            out.println("<li><a href='#'>team</a></li>");
	            out.println("<li><a href='#'>Catalog Request/Download</a></li>");
	            out.println("</ul>");
	            out.println("</div>");
	            out.println("<div class='col-md-3'>");
	            out.println("<ul class='footer_box'>");
	            out.println("<h4>Customer Support</h4>");
	            out.println("<li><a href='#'>Contact Us</a></li>");
	            out.println("<li><a href='#'>Shipping and Order Tracking</a></li>");
	            out.println("<li><a href='#'>Easy Returns</a></li>");
	            out.println("<li><a href='#'>Warranty</a></li>");
	            out.println("<li><a href='#'>Replacement Binding Parts</a></li>");
	            out.println("</ul>");
	            out.println("</div>");
	            out.println("<div class='col-md-3'>");
	            out.println("<ul class='footer_box'>");
	            out.println("<h4>Newsletter</h4>");
	            out.println("<div class='footer_search'>");
	            out.println("<form>");
	            out.println("<input type='text' value='Enter your email' onfocus='this.value = '';' onblur='if (this.value == '') {this.value = 'Enter your email';}>");
	            out.println("<input type='submit' value='Go'>");
	            out.println("</form>");
	            out.println("</div>");
	            out.println("<ul class='social'>");	
	            out.println("<li class='facebook'><a href='#'><span> </span></a></li>");
	            out.println("<li class='twitter'><a href='#'><span> </span></a></li>");
	            out.println("<li class='instagram'><a href='#'><span> </span></a></li>");	
	            out.println("<li class='pinterest'><a href='#'><span> </span></a></li>");
	            out.println("<li class='youtube'><a href='#'><span> </span></a></li>");										  				
	            out.println("</ul>");
	            out.println("</ul>");
	            out.println("</div>");
	            out.println("</div>");
	            out.println("<div class='row footer_bottom'>");
	            		out.println("<div class='copy'>");
	            		out.println("<p>© 2014 Template by <a href='http:w3layouts.com' target='_blank'>w3layouts</a></p>");
	            		out.println("</div>");
	            		out.println("<dl id='sample' class='dropdown'>");
	            		out.println("<dt><a href='#'><span>Change Region</span></a></dt>");
	            		out.println("<dd>");
	            		out.println("<ul>");
	            		out.println("<li><a href='#'>Australia<img class='flag' src='images/as.png' alt='' /><span class='value'>AS</span></a></li>");
	            		out.println("<li><a href='#'>Sri Lanka<img class='flag' src='images/srl.png' alt='' /><span class='value'>SL</span></a></li>");
	            		out.println("<li><a href='#'>Newziland<img class='flag' src='images/nz.png' alt='' /><span class='value'>NZ</span></a></li>");
	            		out.println("<li><a href='#'>Pakistan<img class='flag' src='images/pk.png' alt='' /><span class='value'>Pk</span></a></li>");
	            		out.println("<li><a href='#'>United Kingdom<img class='flag' src='images/uk.png' alt='' /><span class='value'>UK</span></a></li>");
	            		out.println("<li><a href='#'>United States<img class='flag' src='images/us.png' alt='' /><span class='value'>US</span></a></li>");
	            		out.println("</ul>");
	            		out.println("</dd>");
	            		out.println("</dl>");
	            		out.println("</div>");
	            		out.println("</div>");
	            		out.println("</div>");
	          out.println("</body>");
	          out.println("</html>");
	             
	        }
	    }
	      
	             
	        
}

    
