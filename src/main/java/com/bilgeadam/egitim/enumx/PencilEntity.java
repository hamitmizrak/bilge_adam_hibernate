package com.bilgeadam.egitim.enumx;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pencil")
public class PencilEntity implements Serializable {
	private static final long serialVersionUID = -792549439068723998L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pencilName;
	
	// enum değerleri
	//0=Kursun, 1=PilotKalem, 2=TukenmezKalem
	@Enumerated(value = EnumType.STRING)
	private EPencil pencilType;
	private String pencilTrade;
	
	// getter and setter
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPencilName() {
		return pencilName;
	}
	
	public void setPencilName(String pencilName) {
		this.pencilName = pencilName;
	}
	
	public String getPencilTrade() {
		return pencilTrade;
	}
	
	public void setPencilTrade(String pencilTrade) {
		this.pencilTrade = pencilTrade;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// enum
	public EPencil getPencilType() {
		return pencilType;
	}
	
	public void setPencilType(EPencil pencilType) {
		this.pencilType = pencilType;
	}
	
}
