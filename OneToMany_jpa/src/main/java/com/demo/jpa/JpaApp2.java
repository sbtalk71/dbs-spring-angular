package com.demo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.demo.jpa.entity.Emp;

public class JpaApp2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
		EntityManager em = emf.createEntityManager();

		try {

			Emp e = em.find(Emp.class, 116);

			System.out.println(e.getEmpId()+" "+e.getEmpName());

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			em.close();
			emf.close();
		}

	}

}
