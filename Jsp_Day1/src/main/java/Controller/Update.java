package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.EmpDao;
import DTOs.Emp;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		System.out.println(id);
		
		System.out.println(req.getParameter("Update"));
		if(req.getParameter("Update").equals("update")) {
			Emp emp=EmpDao.getEmpById(id);
			
			req.setAttribute("emp", emp);
			
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		else if(req.getParameter("Update").equals("delete")) {
			EmpDao.deletEmp(id);
			List<Emp> emp = EmpDao.getAllEmP();
			req.setAttribute("List", emp);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
			
		}
	
	}
}
