package DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DTOs.*;

public class EmpDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chandu");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public static Emp saveEmp(Emp e) {
		et.begin();
		em.persist(e);
		et.commit();
		return e;
	}

	public static List<Emp> getAllEmP() {

		Query q = em.createQuery("select s from Emp s");
		List<Emp> emp = q.getResultList();
		return emp;
	}

	public static void deletEmp(long id) {
		Emp e = new Emp();
		et.begin();
		e = em.find(Emp.class, id);
		em.remove(e);
		et.commit();

	}

	public static Emp getEmpById(long id) {
		// TODO Auto-generated method stub
		et.begin();
		Emp e = em.find(Emp.class, id);
		et.commit();
		return e;
	}

	public static Emp mergeEmp(Emp e) {
		// TODO Auto-generated method stub
		et.begin();
		e = em.merge(e);
		et.commit();
		return e;
	}
}
