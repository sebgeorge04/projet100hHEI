package o.o.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import o.o.utils.MotDePasseUtils;

@WebServlet("/connexion")
public class ConnexionServlet extends AbstractGenericServlet {

	private static final long serialVersionUID = -1488650966375438002L;

	private Map<String, String> utilisateursAutorises;
	
	@Override
	public void init() throws ServletException {
		utilisateursAutorises = new HashMap<>();
		utilisateursAutorises.put("bob", "oo");
		utilisateursAutorises.put("jean", "85ed883f9d60e290a72a21806355784c36a6c58384862d8f:beb821ab281f45eb4aa51a4fd3fb0399f5c1169f045190bd");
		utilisateursAutorises.put("marie", "be57854ec857fe477b42e8b928a52d8feb716f17a33a6f60:3073e9a6a89054cf5f1ae9baecd70988adde19377ce01200");

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
	
		templateEngine.process("login", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiantSaisi = request.getParameter("identifiant");
		String motDePasseSaisi = request.getParameter("motdepasse");
		try {
			if(utilisateursAutorises.containsKey(identifiantSaisi) && MotDePasseUtils.validerMotDePasse(motDePasseSaisi, utilisateursAutorises.get(identifiantSaisi))) {
				request.getSession().setAttribute("utilisateurConnecte", identifiantSaisi);
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("home");
	}

}

