package com.bilgeadam.egitim.index;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

// fiyatı rengi urunadı
// index: büyük verileri almak ve filterleeme hızlılık v.s
// indexes = {}
// indexes = {@Index(columnList="",name = "",unique=true) }
// name bizim @Colum ==> yazdığımız
// maximum index hesaplamması: (toplam Sutun sayısında-(PK+FK))/2+(PK+FK)
// maximum index hesaplamması: sutun/10
// ram şişirmek

@Entity
@Table(name = "eticaret", indexes = { @Index(columnList = "fiyat", name = "BILGEADAM_INDEX", unique = true),
		@Index(columnList = "urun_adi", name = "URUN_ADI_INDEX"),
		@Index(columnList = "urun_rengi,tarih", name = "MULTIPLE_ADI_INDEX")

})
public class EticaretEntity implements Serializable {
	private static final long serialVersionUID = -8414769613424208321L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fiyat")
	private double fiyat;
	
	@Column(name = "urun_adi")
	private String urunAdi;
	
	@Column(name = "urun_rengi")
	private String urunRengi;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date tarih;
	
	public EticaretEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public EticaretEntity(double fiyat, String urunAdi, String urunRengi) {
		super();
		this.fiyat = fiyat;
		this.urunAdi = urunAdi;
		this.urunRengi = urunRengi;
	}
	
	// getter and setter
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getFiyat() {
		return fiyat;
	}
	
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	public String getUrunAdi() {
		return urunAdi;
	}
	
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	
	public String getUrunRengi() {
		return urunRengi;
	}
	
	public void setUrunRengi(String urunRengi) {
		this.urunRengi = urunRengi;
	}
	
	public Date getTarih() {
		return tarih;
	}
	
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
