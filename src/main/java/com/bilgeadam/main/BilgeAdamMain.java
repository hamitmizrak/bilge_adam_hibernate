package com.bilgeadam.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bilgeadam.controller.BilgeAdamController;
import com.bilgeadam.entity.BilgeAdamEntity;

// Session session = HibernateUtil.getSessionfactory().openSession();
// session.getTransaction().begin();
// session.persist(bilgeAdamEntity);
// session.getTransaction().commit();
// System.out.println("ekleme tamamdır\" + BilgeAdamController.class");

/*
 * S.O.L.I.D
 * Single Responsibility:tek sorumluluk anlamına geliyor.
 */
public class BilgeAdamMain {
	
	public static void main(String[] args) throws IOException {
		
		// fileUpload==> nio
		// database html yükledi.
		// CLOB is for large text data (text)
		String html = new String(Files.readAllBytes(Paths.get("bilgeadam.htm")));
		
		// database css eklemek
		String css = new String(Files.readAllBytes(Paths.get("bilgeadam.css")));
		
		// BLOB is for binary data (videos, images, documents, other)
		byte[] resimBlob = Files.readAllBytes(Paths.get("bilgeadam.jpg"));
		
		// rol management
		// emaail
		// admin>>bilgeadam@gmail.com
		// user>>asdasd@gmail.com
		BilgeAdamEntity bilgeAdamEntity = new BilgeAdamEntity();
		bilgeAdamEntity.setEmail("bilgeadam884@bilge.adam.com.tr");
		bilgeAdamEntity.setPassword("4525");
		// bilgeAdamEntity.setPrice(12345678.123);
		bilgeAdamEntity.setSpesicificValue("ekleme yapılıyor-2");
		bilgeAdamEntity.setHtml(html);
		bilgeAdamEntity.setCss(css);
		bilgeAdamEntity.setPicture(resimBlob);
		
		BilgeAdamController bilgeAdamController = new BilgeAdamController();
		bilgeAdamController.create(bilgeAdamEntity);
		
		////////////////////////////////////////////////////////////////////////////
		
		// BilgeAdamEntity bilgeAdamEntity2 = new BilgeAdamEntity();
		// bilgeAdamEntity2.setId(3);
		// bilgeAdamEntity2.setEmail("bilgeadam44@bilge.adam.com.tr");
		// bilgeAdamEntity2.setPassword("1111");
		//
		// BilgeAdamController bilgeAdamController = new BilgeAdamController();
		//
		// bilgeAdamController.update(bilgeAdamEntity2);
		
	}
	
}
