package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
// POJO
// Bean
// Entity Bean
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "student") // database tablo karşılığı
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 8254402310579127680L;
	
	// nesne dğişkeni
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Mysql
	// @GeneratedValue(strategy = GenerationType.AUTO) //postgresql
	@Column(name = "student_id")
	private long studentId;
	
	@Column(name = "student_name", length = 150)
	private String studentName;
	
	@Column(name = "student_surname")
	private String studentSurname;
	
	@Column(name = "student_email_address")
	private String emailAddress;
	
	@Column(name = "student_password")
	private String studentPassword;
	
	// DATE:yıl ay gün
	// TIME:saat dakika saniye
	// TIMESTAMP:yıl ay gün saat dakika saniye
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private java.util.Date date;
	
	// parametresiz constructor
	public StudentEntity() {
		
	}
	
	// parametreli constructor
	public StudentEntity(String studentName, String studentSurname, String emailAddress, String studentPassword) {
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.emailAddress = emailAddress;
		this.studentPassword = studentPassword;
	}
	
	// toString
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentSurname="
				+ studentSurname + ", emailAddress=" + emailAddress + ", studentPassword=" + studentPassword + ", date="
				+ date + "]";
	}
	
	// hash code
	@Override
	public int hashCode() {
		return Objects.hash(date, emailAddress, studentId, studentName, studentPassword, studentSurname);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntity other = (StudentEntity) obj;
		return Objects.equals(date, other.date) && Objects.equals(emailAddress, other.emailAddress)
				&& studentId == other.studentId && Objects.equals(studentName, other.studentName)
				&& Objects.equals(studentPassword, other.studentPassword)
				&& Objects.equals(studentSurname, other.studentSurname);
	}
	
	// getter and setter
	public long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentSurname() {
		return studentSurname;
	}
	
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getStudentPassword() {
		return studentPassword;
	}
	
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
