package com.example.leanjpaandhibernate.course.jpa;

import org.springframework.stereotype.Component;

import com.example.leanjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course select(long id) {
		return entityManager.find(Course.class, id);
	}

	public void delete(long id) {
		Course course = select(id);
		entityManager.remove(course);
	}
}
