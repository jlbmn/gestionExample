package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.entity.Employee;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/add")
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao edao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAdd() {
        super();
        edao = new EmployeeDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String title = (String) request.getParameter("title");
		
		// Get the right format of Date
		String date = (String) request.getParameter("startDate");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date startDate = null;
		try {
			startDate = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee emp = new Employee(firstName, lastName, title, startDate);
		
		edao.beginTransaction();
		edao.save(emp);
		edao.commitTransaction();
		
		// edao.close();
		
		request.setAttribute("msg", "Employee has been saved!");

		request.getRequestDispatcher("/emp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
