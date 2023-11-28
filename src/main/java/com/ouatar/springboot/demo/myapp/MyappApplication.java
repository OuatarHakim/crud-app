package com.ouatar.springboot.demo.myapp;

import com.ouatar.springboot.demo.myapp.dao.StudentDAO;
import com.ouatar.springboot.demo.myapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
   @Bean

	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
	   return runner -> {

		  // createStudent(studentDAO);
		  // createMultipleStudents( studentDAO);
		  // readStudent(studentDAO);
		  // queryForStudent(studentDAO);
	      //readStudentByLastName(studentDAO);
	        updateStudent(studentDAO);
			deleteStudent(studentDAO);
	   };
   }

   private void deleteAllStudents(StudentDAO studentDAO){
	   System.out.println("Deleting all students ");
	   int numRowDeleted  = studentDAO.deleteAll();
	   System.out.println("Number rows deleted : " +  numRowDeleted);
   }
	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(5);
	}

	private void updateStudent(StudentDAO studentDAO) {
	   int id = 1 ;
	   Student s = studentDAO.findById(id);
	   s.setFirstname("Hak");
	   studentDAO.update(s);

	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		List<Student> thestudents = studentDAO.findByLastName("Hakim");

		for(Student st :thestudents){
			System.out.println(st);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> stds = studentDAO.findAll();
		System.out.println(stds);

	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("JO","jj","jj@gmail.com");
		studentDAO.save(tempStudent);

		System.out.println(studentDAO.findById(tempStudent.getId()));
	}

	public  void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating 3 students objects ...0");
		Student tempStudent1 = new Student("Hakim","Hakim","hakim@gmail.com");
		Student tempStudent2 = new Student("akim","Hkim","haki@gmail.com");
		Student tempStudent3 = new Student("Haim","Haki","hakm@gmail.com");

		System.out.println("Saving the students  ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}
	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating  new student object  ...");
		Student tempStudent  = new Student("Paul" , "Doe" , "paul@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student : Genetated id : " + tempStudent.getId());


	}


}
