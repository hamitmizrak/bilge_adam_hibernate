package com.bilgeadam.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class _02_Aggreagate_Count {
	// logger
	private static final Logger logger = LogManager.getLogger(_02_Aggreagate_Count.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// Javada: bigData
		// Sql : big_data
		
		// SQL count
		// select count(big_data) from student;
		String hql = "select count(tcNumber) from StudentEntity";
		
		// kodlar
		// count: Long olmak zorundadır
		TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
		Long bigDataCounter = typedQuery.getSingleResult();
		logger.info("Sonuç:  " + bigDataCounter);
		
	}
}
