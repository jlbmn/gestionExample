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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.entity.Department;
import fr.formation.inti.entity.Employee;

/**
 * Servlet implementation class UserController
 */

@WebServlet("/delete")
public class EmployeeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao edao;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDelete() {
		edao = new EmployeeDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer empId = Integer.valueOf(request.getParameter("empId"));
		
		edao.beginTransaction();
		// remove employee found by id
		edao.remove(edao.findById(empId));
		edao.commitTransaction();
		
		// edao.close();

		request.setAttribute("msg", "Employee has been deleted!");
		request.getRequestDispatcher("/emp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
		
	}

}
