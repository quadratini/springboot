package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}


	private void deleteStudent(StudentDAO studentDAO) {
		// get student and delete student
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("Duck");
		studentDAO.update(student);
		System.out.println(studentDAO.findById(1));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Mouse");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Mickey", "Mouse", "hohhooh@gmail.com");
		Student tempStudent2 = new Student("Donald", "Duck", "duckduck@gmail.com");
		Student tempStudent3 = new Student("Minnie", "Mouse", "itsminnie@gmail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("James", "Lee", "james@gmail.com");
		studentDAO.save(tempStudent);
	}

	private void createAndReadStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Mickey", "Mouse", "hohhooh@gmail.com");
		studentDAO.save(tempStudent);
		Student student = studentDAO.findById(tempStudent.getId());
		System.out.println(student.getFirstName());
	}
}
