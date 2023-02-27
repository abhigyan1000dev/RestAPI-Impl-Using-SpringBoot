package com.springRest.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.entities.Course;
import com.springRest.springRest.services.CourseService;

@RestController
public class MyControllerClass {
	
	
	
	@Autowired
	private CourseService courseServiceObj;
	
	
	
	
	@GetMapping("/home")
	public String home()
	{
		return "This is the Demonstration of How Rest API with SpringBoot Works";
	}
	
	
//	Getting a List of Courses
	@GetMapping("/courses")
	public List<Course>getCourses()
	{
		return this.courseServiceObj.getCourses();
	}
	
	
//	Getting a single Course 
	@GetMapping("/courses/{courseID}")
	public Course getCourse(@PathVariable String courseID )
	{
		
		return this.courseServiceObj.getCourse(Long.parseLong(courseID));
	}
	
//	Adding  a course to the List<Courses> 
	@PostMapping("/courses")
	public Course addParticularCourse(@RequestBody Course course)
	{
		return this.courseServiceObj.addCourse(course);
	}
	
	
//	Updating a course that already exists
	@PutMapping("/courses")
	public Course updateParticularCouse(@RequestBody Course course)
	{
		return this.courseServiceObj.updateCourse(course);
	}
	
	
	
//	Deleting a record from list
	@DeleteMapping("/courses/{IDtoBeDeleted}")
	public Course deleteParticularRecord(@PathVariable String IDtoBeDeleted) {
		return this.courseServiceObj.deleteCoursefromList(Long.parseLong(IDtoBeDeleted));
	}
}
