package com.bilgeadam.egitim.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

// merge=update find=find delete=remove insert=persist select=TypedQuery
public class _12_limit {
	// logger
	private static final Logger logger = LogManager.getLogger(_12_limit.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// sql
		// select * from student limit 5
		
		String hql = "select stu from StudentEntity as stu ";
		
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		// ilk 5 datayı bize dönderiyor.
		typedQuery.setMaxResults(5);
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
		
	}
}
