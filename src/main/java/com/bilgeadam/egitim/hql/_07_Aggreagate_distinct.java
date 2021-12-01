package com.bilgeadam.egitim.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class _07_Aggreagate_distinct {
	// logger
	private static final Logger logger = LogManager.getLogger(_07_Aggreagate_distinct.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// Bütün listeyi çağır
		// String hql = "FROm StudentEntity as stu";
		
		// tekrarlı verileri çağırma
		String hql = "select distinct(bigData) from  StudentEntity as stu";
		
		TypedQuery<String> typedQuery = session.createQuery(hql, String.class);
		
		ArrayList<String> studentEntities = (ArrayList<String>) typedQuery.getResultList();
		
		for (String temp : studentEntities) {
			logger.info(temp);
		}
		
	}
}
