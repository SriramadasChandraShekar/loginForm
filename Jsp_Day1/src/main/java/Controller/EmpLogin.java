package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAOs.*;
import DTOs.Emp;

/**
 * Servlet implementation class EmpLogin
 */
@WebServlet("/EmpLogin")  
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String s = DAOs.EmpVerify.EmpValidate(req);
		if(s.equals("Login Success")) {
			List<Emp> emp=EmpDao.getAllEmP();
			req.setAttribute("List",emp);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		}
		else { 
			req.setAttribute("message", s);
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
	}
}
