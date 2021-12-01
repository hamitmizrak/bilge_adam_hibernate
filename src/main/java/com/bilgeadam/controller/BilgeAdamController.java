package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class BilgeAdamController implements Serializable, IDatabaseCrud<BilgeAdamEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(BilgeAdamController.class); // logger classı import
	// all < trace=yeşil < debug=yeşil < info=yeşil < warn=sarı < error=kırmızı <
	// fatal=kırmız < off
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	// DML:Create Delete Update : transaction
	// DQL:select : transaction isteğe bağlı
	// create:persist
	// delete: remove
	// update: merge
	// find : find
	
	// Ekleme
	@Override
	public void create(BilgeAdamEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + BilgeAdamController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
	}
	
	// silmek
	@Override
	public void delete(BilgeAdamEntity entity) {
		
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + BilgeAdamEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setEmail(entity.getEmail());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + BilgeAdamEntity.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<BilgeAdamEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from BilgeAdamEntity as str where str.id>=:key";
		TypedQuery<BilgeAdamEntity> typedQuery = session.createQuery(hql, BilgeAdamEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<BilgeAdamEntity> arrayList = (ArrayList<BilgeAdamEntity>) typedQuery.getResultList();
		logger.info("listelendi " + BilgeAdamEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public BilgeAdamEntity find(long id) {
		Session session = databaseConnectionHibernate();
		BilgeAdamEntity bilgeAdamEntity;
		try {
			bilgeAdamEntity = session.find(BilgeAdamEntity.class, id);
			
			if (bilgeAdamEntity != null) {
				System.out.println("bulundu... " + bilgeAdamEntity);
				return bilgeAdamEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kayıt donder
	@Override
	public BilgeAdamEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
}
