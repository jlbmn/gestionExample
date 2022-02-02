package fr.formation.inti.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/*")
public class LogFilter implements Filter {
	
	private static final Log log = LogFactory.getLog(LogFilter.class);
	private ServletContext context ;
	
    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request ; 
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		res.setHeader("Pragma", "no-cache"); 
		res.setHeader("Expires", "0"); 
		
		log.debug("------------------------------");
		
		
		HttpSession session = req.getSession(false);
		
		log.debug(session == null);
		
		String uri = req.getRequestURI();

		// css is authorized
		if(uri.endsWith("css")) {
			chain.doFilter(request, response);
			return;
		}
		
		// Authorized : login.jsp, index.jsp, /login
		if(session == null && !(uri.endsWith("login") || uri.endsWith("index.jsp") || uri.endsWith("login.jsp"))) {
			this.context.log("Unauthorized access, URI : " +uri);
			res.sendRedirect("login.jsp"); // redirect to login page
			return;
		} else {
			this.context.log("Authorized access, URI : " +uri);
			chain.doFilter(request, response);
			return;
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");	}

}
