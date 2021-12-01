package com.bilgeadam.egitim.relation.oneToMany;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// 1
@Entity
@Table(name = "teacher_relation")
public class Teacher implements Serializable {
	private static final long serialVersionUID = -7255354817841783548L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacherId;
	private String teacherName;
	private String teacherSurname;
	
	// composition
	// unutma: sadece getter and setter ekle,constructura ekleme
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Student> studentList;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(String teacherName, String teacherSurname) {
		this.teacherName = teacherName;
		this.teacherSurname = teacherSurname;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(teacherId, teacherName, teacherSurname);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return teacherId == other.teacherId && Objects.equals(teacherName, other.teacherName)
				&& Objects.equals(teacherSurname, other.teacherSurname);
	}
	
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSurname=" + teacherSurname
				+ "]";
	}
	
	public long getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getTeacherSurname() {
		return teacherSurname;
	}
	
	public void setTeacherSurname(String teacherSurname) {
		this.teacherSurname = teacherSurname;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// composition getter and setter
	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
}
