package com.bilgeadam.egitim.relation.oneToMany;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// N
// FK student içinde olması gerekiyor
@Entity
@Table(name = "student_relation")
public class Student implements Serializable {
	private static final long serialVersionUID = -7255354816341783548L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	private String studentName;
	private String studentSurname;
	
	// composition
	// unutma: sadece getter and setter ekle,constructura ekleme
	@ManyToOne
	@JoinColumn(name = "teacherId")
	private Teacher teacher;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentName, String studentSurname) {
		this.studentName = studentName;
		this.studentSurname = studentSurname;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(studentId, studentName, studentSurname);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentId == other.studentId && Objects.equals(studentName, other.studentName)
				&& Objects.equals(studentSurname, other.studentSurname);
	}
	
	// getter
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentSurname=" + studentSurname
				+ "]";
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(long studentId) {
		this.studentId = studentId;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	// composition getter and setter
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
