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

import o.o.manager.Library;


@WebServlet("/details")
public class ArticleSolo extends AbstractGenericServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("articles", Library.getInstance().listArticles());
		context.setVariable("connexion", Library.getInstance().listComptes());
		context.setVariable("categories", Library.getInstance().listCategories());
		//templateEngine.process("single", context, resp.getWriter());
		String nom = req.getParameter("nom");
		req.setAttribute( "nom", nom );
		String description = req.getParameter("description");
		req.setAttribute( "description", description);
		Integer prix = Integer.parseInt(req.getParameter("prix"));
		req.setAttribute( "prix", prix );
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
            
            out.println("<link rel='stylesheet' href='css/etalage.css'>");
            out.println("<script src='js/jquery.etalage.min.js'></script>");
          
            out.println("<script>");
            out.println("jQuery(document).ready(function($){");
		
            out.println("$('#etalage').etalage({");
            out.println("thumb_image_width: 300,");
            out.println("thumb_image_height: 400,");
							
            out.println("show_hint: true,");
            out.println("click_callback: function(image_anchor, instance_id){");
            out.println("alert('Callback example:\nYou clicked on an image with the anchor: '+image_anchor+'\n(in Etalage instance: '+instance_id+')');");
            out.println("}");
            out.println("});");
          
            out.println("$('.dropdownlist').change(function(){");
            out.println("etalage_show( $(this).find('option:selected').attr('class') );");
            out.println("});");

            out.println("});");
            out.println("</script>");
          
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
       	out.println("<div class='row'>");
       	out.println("<div class='col-md-9 single_left'>");
       	out.println("<div class='single_image'>");
       	out.println("<ul id='etalage'>");
       	out.println("<li>");
       	out.println("<a href='optionallink.html'>");
       	out.println("<img class='etalage_thumb_image' src='images/3.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/3.jpg' />");
       	out.println("</a>");
       	out.println("</li>");
       	out.println("<li>");
       	out.println("<img class='etalage_thumb_image' src='images/4.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/4.jpg' />");
       	out.println("</li>");
       	out.println("<li>");
       	out.println("<img class='etalage_thumb_image' src='images/5.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/5.jpg' />");
       	out.println("</li>");
       	out.println("<li>");
       	out.println("<img class='etalage_thumb_image' src='images/6.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/6.jpg' />");
       	out.println("</li>");
       	out.println("<li>");
       	out.println("<img class='etalage_thumb_image' src='images/7.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/7.jpg' />");
       	out.println("</li>");
       	out.println("<li>");
       	out.println("<img class='etalage_thumb_image' src='images/8.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/8.jpg' />");
       	out.println("</li>");
       	out.println("<li>");
       	out.println("<img class='etalage_thumb_image' src='images/9.jpg' />");
       	out.println("<img class='etalage_source_image' src='images/9.jpg' />");
       	out.println("</li>");
       	out.println("</ul>");
       	out.println("</div>");
		     
		        out.println("<div class='single_right'>");
		        out.println("<h3>"+nom+"</h3>");
		        out.println("<p class='m_10'>"+description+"</p>");
		        out.println("<ul class='options'>");
		        out.println("<h4 class='m_12'>Options</h4>");
		        out.println("<li><a href='#'>151</a></li>");
		        out.println("<li><a href='#'>148</a></li>");
		        out.println("<li><a href='#'>156</a></li>");
		        out.println("<li><a href='#'>145</a></li>");
		        out.println("<li><a href='#'>162(w)</a></li>");
		        out.println("<li><a href='#'>163</a></li>");
		        out.println("</ul>");
		        out.println("<ul class='product-colors'>");
		        out.println("<h3>available Colors</h3>");
		    out.println("<li><a class='color1' href='#'><span></span></a></li>");
		    out.println("<li><a class='color2' href='#'><span></span></a></li>");
		    out.println("<li><a class='color3' href='#'><span></span></a></li>");
		    out.println("<li><a class='color4' href='#'><span></span></a></li>");
		    out.println("<li><a class='color5' href='#'><span></span></a></li>");
		    out.println("<li><a class='color6' href='#'><span></span></a></li>");
		    out.println("<div class='clear'> </div>");
		    out.println("</ul>");
		    out.println("<div class='btn_form'>");
		    out.println("<form>");
		    out.println("<input type='submit' value='Acheter' title=''>");
		    out.println("</form>");
		    out.println("</div>");
		    out.println("<ul class='add-to-links'>");
		    out.println("<li><img src='images/wish.png' alt=''><a href='#'>Ajouter à la liste de souhait</a></li>");
		    out.println("</ul>");
			
		    out.println("</div>");
		    out.println("<div class='clear'> </div>");
		    out.println("</div>");
		    out.println("<div class='col-md-3'>");
		    out.println(" <div class='box-info-product'>");
		    out.println("<p class='price2'>"+prix+"</p>");
		    out.println("<ul class='prosuct-qty'>");
		    out.println("<span>Quantité:</span>");
		    out.println("<select>");
		    out.println("<option>1</option>");
		    out.println("<option>2</option>");
		    out.println("<option>3</option>");
		    out.println("<option>4</option>");
		    out.println("<option>5</option>");
		    out.println("<option>6</option>");
		    out.println("</select>");
		    out.println("</ul>");
		    out.println("<button type='submit' name='Submit' class='exclusive'>");
		    out.println("<span>Ajouter au panier</span>");
		    out.println("</button>");
		    out.println("</div>");
		    out.println("</div>");
		    out.println("</div>");	
	
		    out.println("</div>");
		    out.println("</div>");
		    out.println("</div>");
		    out.println("</div>");
		    out.println("</div>");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("articles", Library.getInstance().listArticles());
		context.setVariable("connexion", Library.getInstance().listComptes());
		context.setVariable("categories", Library.getInstance().listCategories());
		templateEngine.process("single", context, resp.getWriter());
		String nom = req.getParameter("nom");
		req.getSession().setAttribute("nom", nom);
		
		String description = req.getParameter("description");
		req.getSession().setAttribute("description", description);
	
		Integer prix = Integer.parseInt(req.getParameter("prix"));
		req.getSession().setAttribute("prix", prix);
		
		
	

}
}
