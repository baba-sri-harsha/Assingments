package com.courseapp;

import com.courseapp.Service.ICourseService;
import com.courseapp.Service.ITrainerService;
import com.courseapp.model.Category;
import com.courseapp.model.Course;
import com.courseapp.model.TechStack;
import com.courseapp.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringDatajapaManytomanyApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajapaManytomanyApplication.class, args);
	}

	private ICourseService courseService;
	private ITrainerService trainerService;

	@Autowired
	public void setCourseService (ICourseService courseService){
		this.courseService = courseService;
	}
	@Autowired
	public void setTrainerService (ITrainerService trainerService){
		this.trainerService = trainerService;
	}


	@Override
	public void run(String... args) throws Exception {

//		adding trainers individually using cascading all

//		Trainer trainer = new Trainer("Kathy", 4.5, 10, TechStack.FULLSTACK.DATABASE.name(), LocalDate.of(2020, 10, 21));
//		Course course = new Course("java in 10 days",1000,45, Category.TESTING.name());
//		trainerService.addTrainer(trainer);
//		courseService.addCourse(course);

//		adding trainers induvidually or getting the tranier already added  and adding them courses using cascading merge

//		Trainer trainer1 = trainerService.getById(1);
//		Trainer trainer1= new Trainer("akash",4,11,TechStack.BACKEND.name(), LocalDate.of(2010,11,1));
//		Trainer trainer2= new Trainer("sandeep",3,1,TechStack.FULLSTACK.name(), LocalDate.of(2012,12,2));
//	ask 	Trainer trainer4=trainerService.getById(4);
//			Trainer trainer2=trainerService.getById(2);


//	Set<Trainer> trainers= new HashSet<>(Arrays.asList(trainer4));
//
//		Course course= new Course("full stack development",8000,15,Category.FULLSTACK.name());
//		course.setTrainers(trainers);
//		courseService.addCourse(course);


//		courseService.getAll().forEach(course1 -> {
//			System.out.println(course1.getCourseName());
//			Set<Trainer>trainers1=course1.getTrainers();
//			for(Trainer train:trainers1){
//				System.out.println(train);
//			}
//		});

//		System.out.println(courseService.getById(1));

//	   courseService.getByNameContaining("d").forEach(System.out::println);

//		courseService.getByNameAndFees("f",500000).forEach(System.out::println);

//		courseService.getByTrainer("baba").forEach(System.out::println);

//		courseService.getByTrainerExpertise("baba",TechStack.FRONTEND.name()).forEach(System.out::println);

//		courseService.getByTrainerExperience("baba",15).forEach(System.out::println);

//		courseService.getByTrainerCourseName("harsha","oracle").forEach(System.out::println);

//		courseService.getByNameDuration("harsha",10).forEach(System.out::println);

		//Trainer testing




//		for derived queries having like % % no need to pass %% in service impl

//		trainerService.getByTrainerName("a").forEach(System.out::println);

//		trainerService.getByCoursesCourseName("oracle in 80 days").forEach(System.out::println);

//		trainerService.getByTechStack(TechStack.FRONTEND.name()).forEach(System.out::println);

//		trainerService.getByTrainerRatings(Category.FULLSTACK.name(), 4.2).forEach(System.out::println);

//		trainerService.getByTrainerExperience(Category.FULLSTACK.name(), 15).forEach(System.out::println);

//		trainerService.getByCourseNameFees("full",400000).forEach(System.out::println);

//		trainerService.getByNameDuration("f",11).forEach(System.out::println);

//		trainerService.getByJoiningBetween(LocalDate.of(2023,12,3)).forEach(System.out::println);


	}
}
