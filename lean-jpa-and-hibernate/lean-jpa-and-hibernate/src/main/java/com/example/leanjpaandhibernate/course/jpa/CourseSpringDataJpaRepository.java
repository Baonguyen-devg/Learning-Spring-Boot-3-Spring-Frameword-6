package com.example.leanjpaandhibernate.course.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leanjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	public List<Course> findByAuthor(String author);
	public List<Course> findByName(String name);
}
