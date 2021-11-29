package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class StudentController implements Serializable, IDatabaseCrud<StudentEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	
	// DML:Create Delete Update : transaction
	// DQL:select : transaction isteğe bağlı
	// create:persist
	// delete: remove
	// update: merge
	// find : find
	
	// Ekleme
	@Override
	public void create(StudentEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdır" + StudentController.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// silmek
	@Override
	public void delete(StudentEntity entity) {
		
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Başarılı " + StudentEntity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				findEntity.setEmailAddress(entity.getEmailAddress());
				findEntity.setStudentName(entity.getStudentName());
				findEntity.setStudentPassword(entity.getStudentPassword());
				findEntity.setStudentSurname(entity.getStudentSurname());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + StudentEntity.class);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<StudentEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from StudentEntity as str where str.id>=:key";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<StudentEntity> arrayList = (ArrayList<StudentEntity>) typedQuery.getResultList();
		return arrayList;
	}
	
	// find
	@Override
	public StudentEntity find(long id) {
		Session session = databaseConnectionHibernate();
		StudentEntity studentEntity;
		try {
			studentEntity = session.find(StudentEntity.class, id);
			
			if (studentEntity != null) {
				System.out.println("bulundu... " + studentEntity);
				return studentEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kayıt donder
	@Override
	public StudentEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
}
