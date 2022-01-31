package fr.formation.inti.controller;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.UserService;

/**
 * Servlet implementation class UserController
 */

@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        service = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = null ; 
		// try/catch if entity is not found in db
		try {
			user = service.findByLoginAndPassword(login, password);
		} catch(NoResultException nre) {
			nre.printStackTrace();
			request.setAttribute("errorMessage", "Error! login or password incorrect. ");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(300); 
			session.setAttribute("user", user);
		} else {
			request.setAttribute("errorMessage", "Error! login or password incorrect!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
			
		
	}

}
