package com.bilgeadam.egitim.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class _06_Aggreagate_avg {
	// logger
	private static final Logger logger = LogManager.getLogger(_06_Aggreagate_avg.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// Javada: bigData
		// Sql : big_data
		
		// SQL count
		// select count(big_data) from student;
		String hql = "select avg(tcNumber) from StudentEntity";
		
		// kodlar
		TypedQuery<Double> typedQuery = session.createQuery(hql, Double.class);
		Double bigDataCounter = typedQuery.getSingleResult();
		logger.info("Sonuç:  " + bigDataCounter);
		
	}
}
