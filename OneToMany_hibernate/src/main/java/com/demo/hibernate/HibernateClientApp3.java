package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Address;
import com.demo.hibernate.entity.Emp;

public class HibernateClientApp3 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Address address=new Address("124","street2","800089");
			Emp emp = new Emp("Mukul", "Bangalore", 77000);
			
			emp.getAddress().add(address);
		
			
			session.save(emp);
			
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
