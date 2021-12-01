package com.bilgeadam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "bilge_adam")
public class BilgeAdamEntity implements Serializable {
	private static final long serialVersionUID = -4149516439705226333L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// blob: büüyk verilerimizi database gömmek isteyebiliriz.
	// bütün veriler database olsun
	// büyük veriler uğraşmak
	
	@Lob
	private String html;
	
	@Lob
	private String css;
	
	@Lob
	private byte[] picture;
	
	// email :
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	
	// password
	// updatable:false ==> güncelleme yapamazsın ==> session.merge
	@Column(name = "password", updatable = true)
	private String password;
	
	// insertable:false ==> ekleme yapamazsın==> session.persist
	@Column(name = "specific_value", insertable = false)
	private String spesicificValue;
	
	@Column(name = "price", columnDefinition = "Decimal(10,2) default '100.00'")
	private double price;
	
	// getter and setter
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSpesicificValue() {
		return spesicificValue;
	}
	
	public void setSpesicificValue(String spesicificValue) {
		this.spesicificValue = spesicificValue;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getCss() {
		return css;
	}
	
	public void setCss(String css) {
		this.css = css;
	}
	
	public byte[] getPicture() {
		return picture;
	}
	
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
}
