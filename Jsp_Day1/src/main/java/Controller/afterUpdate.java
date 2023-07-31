package Controller;

import java.io.IOException;
import java.util.List;

import DTOs.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.EmpDao;

/**
 * Servlet implementation class afterUpdate
 */
@WebServlet("/afterUpdate")
public class afterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Emp e = new Emp();

		e.setNumber(Long.parseLong(req.getParameter("number")));
		Emp e1 = EmpDao.getEmpById(e.getNumber());
		e.setName(req.getParameter("name"));
		e.setAddress(req.getParameter("address"));
		e.setEmail(req.getParameter("email"));
		e.setPassword(req.getParameter("password"));
		String s1 = req.getParameter("passwordnew");
		if (e1.getPassword().equals(e.getPassword())) {
			System.out.println(s1);
			if (!(s1.equals(""))) {
				e.setPassword(req.getParameter("passwordnew"));
			}
			EmpDao.mergeEmp(e);
			List<Emp> emp = EmpDao.getAllEmP();
			req.setAttribute("List", emp);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		} else {
			String s = "Incorrect Entered passwored";
			req.setAttribute("msg", s);
			req.setAttribute("emp", e1);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}

	}

}
