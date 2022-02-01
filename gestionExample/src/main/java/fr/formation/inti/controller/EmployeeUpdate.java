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

@WebServlet("/update")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(EmployeeUpdate.class);
	private EmployeeDao edao;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeUpdate() {
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
		Employee emp = edao.findById(empId);
		request.setAttribute("emp", emp);
		edao.commitTransaction();
		
		// edao.close();

		request.getRequestDispatcher("formUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Integer empId = Integer.valueOf(request.getParameter("empId"));
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		
//		String date = (String) request.getParameter("startDate");
//		SimpleDateFormat formatter = new SimpleDateFormat();  
//		Date startDate = null;
//		try {
//			startDate = formatter.parse(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		edao.beginTransaction();
		Employee e = edao.findById(empId);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setStartDate(new Date());
		edao.update(e);
		edao.commitTransaction();
		
		// edao.close();
		
		
		request.setAttribute("msg", "Employee has been updated!");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
