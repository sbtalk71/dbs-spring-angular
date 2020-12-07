package com.demo.jpa.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.jpa.entity.Emp;

public class JpaJoinQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
		EntityManager em = emf.createEntityManager();

		try {
			
			
			Query query=em.createNamedQuery("empJoinAddress");
			
			List<Object[]> empList=query.getResultList();
			
			for(Object[] data:empList) {
				String name=(String)data[0];
				Double salary=(Double)data[1];
				String pin=(String)data[2];
				
				System.out.println(name+" "+salary+" "+pin);
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {

			em.close();
			emf.close();
		}

	}

}
