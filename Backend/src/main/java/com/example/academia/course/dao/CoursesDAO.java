package com.example.academia.course.dao;

import com.example.academia.course.bean.Courses;
import jakarta.ws.rs.PathParam;

import java.util.List;

public interface CoursesDAO {

    boolean UpdateCourseName(int courseID, String updatedName);

//    boolean UpdateCourse(Courses courObj);
    boolean DeleteCourse(int courseID);
    public List<String> ExtractCoursesList();

    boolean addCourse(Courses c);

    boolean UpdateCapacity( int courseID, int capacity);

}