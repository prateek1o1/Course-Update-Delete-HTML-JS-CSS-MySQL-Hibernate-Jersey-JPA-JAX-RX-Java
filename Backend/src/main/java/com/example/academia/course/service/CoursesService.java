package com.example.academia.course.service;

import com.example.academia.course.bean.Courses;
import com.example.academia.course.dao.CoursesDAO;
import com.example.academia.course.dao.PrerequisiteDAO;
import com.example.academia.course.dao.impl.CoursesDAOImpl;
import com.example.academia.course.dao.impl.PrerequisiteDAOImlp;

import java.util.List;

public class CoursesService {

    CoursesDAOImpl coursesDAO = new CoursesDAOImpl();
    public List<String> getList()
    {
        CoursesDAO coursesDAO1 = new CoursesDAOImpl();
        return (coursesDAO1.ExtractCoursesList());
    }

    public boolean deleteCourse (int courseID)
    {
        CoursesDAO coursesDAO2 = new CoursesDAOImpl();
        return (coursesDAO2.DeleteCourse(courseID));
    }

    public boolean UpdateCourseName(int courseID,String updatedName){
        CoursesDAO coursesDAO3 = new CoursesDAOImpl();

        return (coursesDAO3.UpdateCourseName(courseID,updatedName));
    }

   public boolean UpdateCapacity(int courseID,int capacity)
    {
        CoursesDAO coursesDAO4 = new CoursesDAOImpl();
        return (coursesDAO4.UpdateCapacity(courseID,capacity));
    }

}
