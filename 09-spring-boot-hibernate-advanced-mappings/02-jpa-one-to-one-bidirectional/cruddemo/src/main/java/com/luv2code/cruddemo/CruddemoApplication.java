package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	
	//CommandLineRunner from the spring boot framework
	//Executed after the Spring Beans have been loaded
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}


	private void deleteInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Deleting instructor detail id: "+theId);
		
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}


	private void findInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// get the instructor detail object
		int theId = 1;	
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		// print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		
		// print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
		
		System.out.println("Done!!");
	}


	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		System.out.println("Deleting instructor id: "+theId);
		
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}


	private void findInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		System.out.println("Finding instructor id: "+theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}


	private void createInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// create the instructor
		Instructor tempInstructor = new Instructor("Bhumika","Saini","bhumi@luv2code.com");
		
		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://ww.luv2code.com-bhumikayoutube","Cooking Food!");
		
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		// save the instructor
		//NOTE: this will also save the InstructorDetail object because of CascadeType.ALL
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		
		System.out.println("Done!");
	}

}
