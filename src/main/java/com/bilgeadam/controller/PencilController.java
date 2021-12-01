package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.egitim.enumx.PencilEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class PencilController implements Serializable, IDatabaseCrud<PencilEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(PencilController.class); // logger classı import
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
	public void create(PencilEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + PencilController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + PencilController.class);
			e.printStackTrace();
		}
	}
	
	// silmek
	@Override
	public void delete(PencilEntity entity) {
		
		try {
			PencilEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + PencilEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + PencilController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(PencilEntity entity) {
		try {
			PencilEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setPencilName(entity.getPencilName());
				findEntity.setPencilTrade(entity.getPencilTrade());
				findEntity.setPencilType(entity.getPencilType());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + PencilEntity.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + PencilController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<PencilEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from PencilEntity as str where str.id>=:key";
		TypedQuery<PencilEntity> typedQuery = session.createQuery(hql, PencilEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<PencilEntity> arrayList = (ArrayList<PencilEntity>) typedQuery.getResultList();
		logger.info("listelendi " + PencilEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public PencilEntity find(long id) {
		Session session = databaseConnectionHibernate();
		PencilEntity pencilEntity;
		try {
			pencilEntity = session.find(PencilEntity.class, id);
			
			if (pencilEntity != null) {
				System.out.println("bulundu... " + pencilEntity);
				return pencilEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + PencilController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kayıt donder
	@Override
	public PencilEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
}
