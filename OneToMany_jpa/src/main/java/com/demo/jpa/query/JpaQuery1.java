package com.demo.jpa.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.jpa.entity.Emp;

public class JpaQuery1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
		EntityManager em = emf.createEntityManager();

		try {
			//Query query=em.createQuery("select e from Emp e where e.empName like '%u%'");
			Query query=em.createQuery("select e from Emp e where e.salary between 60000 and 90000");
			
			List<Emp> empList=query.getResultList();
			
			empList.forEach(e->System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getSalary()));

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {

			em.close();
			emf.close();
		}

	}

}
