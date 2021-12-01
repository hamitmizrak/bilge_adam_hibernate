package com.bilgeadam.egitim.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

public class _08_where2 {
	// logger
	private static final Logger logger = LogManager.getLogger(_08_where2.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// NormalSQL
		// select * from student where tc_number>=5
		
		// String hql = "select stu from StudentEntity as stu where tcNumber>=5"; //
		// manuel yazmak için
		String hql = "select stu from  StudentEntity as stu where tcNumber>=:key"; // dynamic kullanıcıdan almak
		
		String userValeu = JOptionPane.showInputDialog("lütfen bir sayı giriniz");
		int number = 5;
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		typedQuery.setParameter("key", number);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
		
	}
}
