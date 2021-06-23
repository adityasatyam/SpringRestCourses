package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CousrseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	
	
	
//	List<Course> list;
	public CousrseServiceImpl() {
//		list =new ArrayList<>();
//		list.add(new Course(123,"Java","lets learn Java"));
//		list.add(new Course(321,"React","lets learn React"));		
	
	
	}
	
	@Override
	public List<Course> getCourses() {
//		return list;
		return courseDao.findAll()  ;
	}
	
	@Override
	public Course getCourse(Long courseId) {
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				return course;
//			}
//		}
		return courseDao.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Object updateCourse(Course course) {
//		Course updatedCourse=null;
//		for(Course oldCourse:list) {
//			if(oldCourse.getId()==course.getId()) {
//				oldCourse.setDescription(course.getDescription());
//				oldCourse.setTitle(course.getTitle());
//				updatedCourse=oldCourse;
//				break;
//			}	
//		}
//		if(updatedCourse == null)
//			return "No course found";
//		return updatedCourse;
		courseDao.save(course);
		return course;
		
	}

	@Override
	public String deleteCourse(Long courseId) {
//		for(Course course:list) {
//			if(course.getId()==courseId){
//				list.remove(course);
//				return "Course removed successfully";
//			}
//		}
		Course entity = courseDao.getById(courseId);
		courseDao.delete(entity);
		return "No Course found";
	}
}
