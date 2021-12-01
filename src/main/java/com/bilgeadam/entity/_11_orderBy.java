package com.bilgeadam.entity;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

// merge=update find=find delete=remove insert=persist select=TypedQuery
public class _11_orderBy {
	// logger
	private static final Logger logger = LogManager.getLogger(_11_orderBy.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// sql
		// select * from student as st order by st.tc_number asc;
		// select * from student as st order by st.tc_number desc;
		
		String hql = "select stu from StudentEntity as stu order by stu.tcNumber desc ";
		
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
		
	}
}
