package com.sqlconnetion.inserting;

import com.sqlconnetion.inserting.implementationandconstructor.StudentDAO;
import com.sqlconnetion.inserting.main.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InsertingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner ->
		{
//			createstudent(studentDAO);
			createmultiplestudent(studentDAO);
//			finddata(studentDAO);
//			findallData(studentDAO);
//			findbydlast(studentDAO);
//			UpdateValue(studentDAO);
//			DelteElement(studentDAO);

//			DeleteAllelements(studentDAO);
		};


	}

	private void createstudent(StudentDAO studentDAO)
	{
		Student a = new Student("sa","sdas","sda@gmail.com");
		System.out.println("Done written");

		studentDAO.save(a);
		System.out.println("saved to database");

		System.out.println(a.getId());

	}
	private void createmultiplestudent(StudentDAO studentDAO)
	{
		Student s1 = new Student("samuel","evv","sam@email.com");
		Student s2 = new Student("emuel","do","emm@email.com");
		Student s3 = new Student("moses","son","moss@email.com");
		System.out.println("Successfully wrote in Database");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
		System.out.println("Successfully saved to the database.");

	}
	private void finddata(StudentDAO studentDAO)
	{
		Student a1 = new Student("pas","sa","sf@email.com");

		studentDAO.save(a1);
		int theId = a1.getId();

		System.out.println(theId);

		Student as = studentDAO.findbyId(theId);
		System.out.println(as.toString());
	}

	private void findallData(StudentDAO studentDAO)
	{
		List<Student> theStudentList = studentDAO.findall();
		for (Student tempStudent: theStudentList)
		{
			System.out.println(tempStudent);
		}
	}

	private void findbydlast(StudentDAO studentDAO)
	{
		List<Student> students = studentDAO.findbylastname("sa");
		for (Student i : students)
		{
			System.out.println(i);
		}

	}
	private void UpdateValue(StudentDAO studentDAO)
	{
		int studentId = 1;

		Student myStudent = studentDAO.findbyId(studentId);
		myStudent.setFirstname("Amigos");
		studentDAO.update(myStudent);
		System.out.println("\n Updating done to data given value change to "+ myStudent + "\n\n now print entiew data "  );
		findallData(studentDAO);
	}
	private  void DelteElement(StudentDAO studentDAO)
	{
		int studentId = 1;
		studentDAO.delete(studentId);
		System.out.println("Delte from "+studentId+" \n\n new database -- \n\n");
		findallData(studentDAO);
	}
	private void DeleteAllelements(StudentDAO studentDAO)
	{
		System.out.println("ELements are deleting..........");

		int itemsCount = studentDAO.deleteAll();
		System.out.println("Total items that been deleted are : "+itemsCount);
	}
}