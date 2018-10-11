package edu.chain;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.entidade.UserInfo;

/**
 * Servlet Filter implementation class FilterAuthentication
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/jsp/*", "/admin.jsp" })
public class FilterAuthentication implements Filter {
    public FilterAuthentication() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		UserInfo user = (UserInfo)session.getAttribute("LOGADO");
		HttpServletResponse res = (HttpServletResponse)response;
		
		String pagina = req.getServletPath();
		
		System.out.println("Filtro executando, acesso na pagina " + pagina);
		
		if ("/login.jsp".equals(pagina) || "/Authenticator".equals(pagina)) { 
			chain.doFilter(request, response);
		} else if (user != null && user.isLogado()) { 
			chain.doFilter(request, response);
		} else { 
			res.sendRedirect("../login.jsp");
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
