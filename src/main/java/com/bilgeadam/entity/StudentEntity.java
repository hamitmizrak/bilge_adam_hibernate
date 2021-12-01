package com.bilgeadam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 8254402310579127680L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // for postgres
	private long studentId;
	
	@Column(name = "student_name", length = 255)
	private String studentName;
	
	@Column(name = "student_surname")
	private String studentSurname;
	
	@Column(name = "student_email_address")
	private String emailAddress;
	
	@Column(name = "student_password")
	private String studentPassword;
	
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
