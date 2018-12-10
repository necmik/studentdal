package com.bharath.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.student.dal.entities.Student;
import com.bharath.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("Necmi");
		student.setCourse("Java Web Services");
		student.setFee(30d);
		
		studentRepository.save(student);
	}
	
	@Test
	public void testFindStudentById() {
		Optional<Student> student = studentRepository.findById(10l);
		if (!student.isPresent()) {
			System.out.println("Student not found");
		} else {
			System.out.println(student);
		}
		
		student = studentRepository.findById(3l);
		if (!student.isPresent()) {
			System.out.println("Student not found");
		} else {
			System.out.println(student);
		}
	}
	
	@Test
	public void testUpdateStudentById() {
		Optional<Student> studentOpt = studentRepository.findById(1l);
		if (studentOpt.isPresent()) {
			Student student = studentOpt.get();
			student.setFee(45d);
			
			studentRepository.save(student);
		}
	}
	
	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(2L);
		studentRepository.delete(student);
		
		//studentRepository.deleteById(2L);
	}

}
