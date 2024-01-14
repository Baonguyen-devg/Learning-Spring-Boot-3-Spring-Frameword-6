package com.example.Learningspringboot1;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Course {
	private long _id;
	private String _name;
	private String _author;
	
	public Course() {}
	public Course(long id, String name, String author) {
		super();
		this._id = id;
		this._name = name;
		this._author = author;
	}

	public long getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public String get_author() {
		return _author;
	}

	@Override
	public String toString() {
		return "Course [id=" + _id + ", name=" + _name + ", author=" + _author + "]";
	}
}

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
			new Course(1, "SpringFramework", "In28Minutes"),
			new Course(2, "Unity2D", "SaiGame"),
			new Course(3, "Unity3D", "CodeMonkey"),
			new Course(4, "UnityMachineLearning", "CodeMonkey"),
			new Course(5, "Java", "LQT"),
			new Course()
		);
	}
}
