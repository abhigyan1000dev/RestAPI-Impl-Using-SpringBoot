package com.springRest.springRest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springRest.springRest.entities.Course;


@Service
public class courseServiceIMPL implements CourseService{

	
	List<Course> list;
	public courseServiceIMPL()
	{
		list=new ArrayList<>();
		list.add(new Course(145, "United Airlines", "Bhai isme to placement pkka"));
		list.add(new Course(146, "Infosys ", "Bhai iska to paper pkka nikalna hai"));
		list.add(new Course(148, "FCS ", "Bhai isme to hona hi hai"));
		
	
	}
	
	@Override
	public List<Course> getCourses() {
			
		
		return list;
	}

	@Override
	public Course getCourse(long courseID) {
		
		Course c=null;
		
		for(Course cc:list)
		{
			
			if(cc.getId()==courseID)
			{
				c=cc;
				break;
			}
			
		}
		
		return c;
	}

	
	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		long id=(course.getId());
		String updatedName=(course.getName());
		String updatedDesription=(course.getDescription());
		
		for(Course cc:list)
		{
			if(cc.getId()==id)
			{
				cc.setName(updatedName);
				cc.setDescription(updatedDesription);
			}
		}
		return course;
	}

	@Override
	public Course deleteCoursefromList(long IDtoBeDeleted) {
			System.out.print(IDtoBeDeleted);
			Course c=null;
			for(Course cc:list)
			{
				if(cc.getId()==IDtoBeDeleted)
				{
					c=cc;
					break;
				}
			}
			list.remove(c);
			return null;
	}
	
	
}
