package com.bilgeadam.egitim.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.util.HibernateUtil;

// import org.apache.log4j.Logger;

// private static final Logger logger =
// LogManager.getLogger(StudentController.class); // logger classı import
// // all < trace=yeşil < debug=yeşil < info=yeşil < warn=sarı < error=kırmızı <
// // fatal=kırmız < off
//
// public static void main(String[] args) {
// logger.trace("trace logger durumu");
// logger.debug("debug logger durumu");
// logger.info("info logger durumu");
// logger.warn("warn logger durumu");
// logger.error("error logger durumu");
// logger.fatal("fatal logger durumu");
// }

public class _01_HqlQuery_Select {
	private static final Logger logger = LogManager.getLogger(_01_HqlQuery_Select.class);
	
	public static void main(String[] args) {
		// interface uğramayacaksam mutlaka yapmalıyız
		// HibernateUtil.getSessionfactory().openSession()
		// transaction yapmamıza gerek yok çünkü select yapıyoruz yani sadece okuma
		// yapıyoruz.
		Session session = HibernateUtil.getSessionfactory().openSession();
		// SELECT * FROM bilge_adam.student;
		
		// unexpected end of subtree : içi boş
		// hql: Hibernate Query Language
		// hql: sql benzer ancak sql değildir.
		// UNUTMA: from'dan sonra Databasedeki tablo adını yazmayacağız StudentEntity
		// yazılacak
		String hql = "SELECT stu FROm StudentEntity as stu";
		// String hql = "FROm StudentEntity ";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
	}
}
