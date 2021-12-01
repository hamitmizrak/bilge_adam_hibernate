package com.bilgeadam.egitim.relation.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class OneToManyMain {
	
	public static void main(String[] args) {
		// her zaman tek olanla başlayalım.
		// 1
		Teacher teacher = new Teacher("Mustafa Kemal", "Atatürk");
		teacher.setStudentList(new ArrayList<Student>());
		
		// N
		// 1.öğrenci
		Student student = new Student("Hamit", "Mızrak");
		student.setTeacher(teacher);
		teacher.getStudentList().add(student);
		
		// 2.öğrenci
		Student student2 = new Student("Recep", "Ergan");
		student2.setTeacher(teacher);
		teacher.getStudentList().add(student2);
		
		// Create
		// Session session = HibernateUtil.getSessionfactory().openSession();
		// session.getTransaction().begin();
		// session.persist(teacher);
		// session.getTransaction().commit();
		
		System.out.println("*********************************************");
		// find teacher
		Session session = HibernateUtil.getSessionfactory().openSession();
		Teacher teacherFind = session.find(Teacher.class, 1L);
		System.out.println(teacherFind);
		System.out.println("*********************************************");
		
		// find student
		// select * from teacher_relation as te inner join student_relation as st on
		// te.teacherId=st.teacherId
		
		// hibernate innerJoin :stu.teacher.teacherId
		String hql = "select stu from Student as stu where stu.teacher.teacherId=1";
		TypedQuery<Student> studentList = session.createQuery(hql, Student.class);
		List<Student> listem = studentList.getResultList();
		
		for (Object temp : listem) {
			System.out.println(temp);
		}
	}
	
}
