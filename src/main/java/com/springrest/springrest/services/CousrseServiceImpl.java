package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CousrseServiceImpl implements CourseService {

	List<Course> list;
	public CousrseServiceImpl() {
		list =new ArrayList<>();
		list.add(new Course(123,"Java","lets learn Java"));
		list.add(new Course(321,"React","lets learn React"));		
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public Course getCourse(long courseId) {
		for(Course course:list) {
			if(course.getId()==courseId) {
				return course;
			}
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Object updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course updatedCourse=null;
		for(Course oldCourse:list) {
			if(oldCourse.getId()==course.getId()) {
				oldCourse.setDescription(course.getDescription());
				oldCourse.setTitle(course.getTitle());
				updatedCourse=oldCourse;
				break;
			}	
		}
		if(updatedCourse == null)
			return "No course found";
		return updatedCourse;
		
	}

	@Override
	public String deleteCourse(Long courseId) {
		for(Course course:list) {
			if(course.getId()==courseId){
				list.remove(course);
				return "Course removed successfully";
			}
		}
		return "No Course found";
	}
}
