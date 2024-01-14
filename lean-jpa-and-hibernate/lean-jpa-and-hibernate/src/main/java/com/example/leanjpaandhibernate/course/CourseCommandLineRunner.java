package com.example.leanjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.leanjpaandhibernate.course.jpa.CourseSpringDataJpaRepository;

@Order(value = 1)
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	//private CourseJdbcRepository repository;
	//private CourseJpaRepository repository;
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Build A Basic Unity Game", "SaiGame"));
		repository.save(new Course(2, "Build A 2D Unity Game", "CodeMonkey"));
		repository.save(new Course(3, "Build A 3D Unity Game", "SaiGame"));
		repository.save(new Course(4, "Build A Mutilplayer Unity Game", "SaiGame"));

		repository.deleteById(3l);
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(2l));
		System.out.println(repository.findAll());
		System.out.println("-----------------------------------------");
		
		System.out.println(repository.findByAuthor("SaiGame"));
		System.out.println(repository.findByAuthor("CodeMonkey"));
		System.out.println("-----------------------------------------");
		
		System.out.println(repository.findByName("Build A Basic Unity Game"));
	}
}
