package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.entity.Department;
import fr.formation.inti.entity.Employee;

/**
 * Servlet implementation class UserController
 */

@WebServlet("/emp")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao edao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		edao = new EmployeeDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		edao.beginTransaction();
		List<Employee> employees = edao.findAll();
		edao.commitTransaction();
		
		// edao.close();

		request.setAttribute("employees", employees);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		
		// Get the right format of Date
		String date = (String) request.getParameter("startDate");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date startDate = null;
		try {
			startDate = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee emp = new Employee(firstName, lastName, startDate);
		
		edao.beginTransaction();
		edao.save(emp);
		edao.commitTransaction();
		
		// edao.close();
		
		request.setAttribute("msg", "Employee has been saved!");

		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
