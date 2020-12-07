package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.entity.Emp;

public class HibGetLoadEvict {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			//Emp emp = new Emp(115, "Chandra", "Chennai", 97000);
			
			//session.save(emp);
			//session.flush();
			
			/*
			 * Emp e1 =session.get(Emp.class, 114); Emp e2 =session.get(Emp.class, 112);
			 * //session.evict(e1); session.clear(); Emp e3 =session.get(Emp.class, 114);
			 * Emp e4 =session.get(Emp.class, 112);
			 */
			
			Emp e5=session.load(Emp.class, 214);
			
			System.out.println(e5.getClass().getName());
			
			System.out.println(e5.getEmpName());
			
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
