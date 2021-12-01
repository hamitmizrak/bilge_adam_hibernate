package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

public class _09_between {
	// logger
	private static final Logger logger = LogManager.getLogger(_09_between.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		String hql = "select stu from  StudentEntity as stu where tcNumber between :minKey and :maxKey";
		
		int minValue = 4, maxValue = 7;
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		typedQuery.setParameter("minKey", minValue);
		typedQuery.setParameter("maxKey", maxValue);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
		
	}
}
