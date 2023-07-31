package DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import DTOs.Emp;

public class EmpVerify {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chandu");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public static String EmpValidate(HttpServletRequest req) {
		String s = "";
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		DTOs.Emp e = new Emp();
		e.setEmail(email);
		et.begin();
		Query q=null;
		try {
		q = em.createQuery("select e from Emp e where e.email=?1");
		q.setParameter(1, e.getEmail());
		e = (Emp) q.getSingleResult();
		}
		catch (javax.persistence.NoResultException e1) {
			// TODO: handle exception
			s="Invalid Email Id";
		 
		 return s;
		}
		finally {
		et.commit();
		}
		if (e != null) {
			if (e.getEmail().equals(email)) {
				if (e.getPassword().equals(password)) {
					s = "Login Success";
				} else {
					s = "Incorrect password";
				}
			} else {
				s = "User Does't Exit";
			}
		} else {
			s = "User Does't Exit";
		}
		return s;
	}

}
