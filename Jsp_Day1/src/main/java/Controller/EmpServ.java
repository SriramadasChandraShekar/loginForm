package Controller;

import DTOs.*;
import java.io.IOException;
import java.io.InputStream;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAOs.EmpDao;

/**
 * Servlet implementation class EmpServ
 */
@WebServlet("/EmpServ")
public class EmpServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Emp e1 = new Emp();

		e1.setName(req.getParameter("name"));
		e1.setAddress(req.getParameter("address"));
		e1.setNumber(Long.parseLong(req.getParameter("number")));
		e1.setEmail(req.getParameter("email"));
		e1.setPassword(req.getParameter("password"));

		Emp DbEmp = EmpDao.saveEmp(e1);
		if (DbEmp != null) {
			req.setAttribute("message", e1.getName() + "!!:) You have Successfully SignedUp!! Proceed for Login");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("Singup.jsp").forward(req, resp);
		}

	}

}
