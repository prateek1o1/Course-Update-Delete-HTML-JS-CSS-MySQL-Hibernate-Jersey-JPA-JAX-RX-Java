package com.example.academia.course.util;

import com.example.academia.course.bean.Courses;
import com.example.academia.course.bean.Admin;
import com.example.academia.course.bean.Prerequisite;
import com.example.academia.course.dao.CoursesDAO;
import com.example.academia.course.dao.AdminDAO;
import com.example.academia.course.dao.impl.CoursesDAOImpl;
import com.example.academia.course.dao.impl.AdminDAOImpl;
import com.example.academia.course.dao.impl.PrerequisiteDAOImlp;
import com.example.academia.course.dao.PrerequisiteDAO;

public class InitializeDB {
    public static void main(String[] args) {

//        List<Courses> courseList = new ArrayList<>();
//        CoursesDAO coursesDAO1= new CoursesDAOImpl();
//        courseList=coursesDAO1.extractCourses();

        CoursesDAO coursesDAO= new CoursesDAOImpl();
        PrerequisiteDAO coursesPreDAO=new PrerequisiteDAOImlp();
        AdminDAO adminDAO =new AdminDAOImpl();

        Courses c1=new Courses();
        Courses c2=new Courses();
        Courses c3=new Courses();
        Courses c4=new Courses();
        Courses c5=new Courses();
        Prerequisite p1=new Prerequisite();
        Prerequisite p2=new Prerequisite();
        Prerequisite p3=new Prerequisite();
        Admin l1 = new Admin();


        c1.setCourseName("Visual Recognition");
        c1.setCourseCapacity(100);
        c1.setCourseCode(101);
        c1.setCourseCredits(4);
        c1.setCourseFaculty(8);
        c1.setCourseDescription("Intensive");
        c1.setCourseTerm(2);
        c1.setCourseYear(1998);
        c1.setCourseID(1);

        c2.setCourseName("Advance Visual Recognition");
        c2.setCourseCapacity(100);
        c2.setCourseCode(102);
        c2.setCourseCredits(4);
        c2.setCourseFaculty(8);
        c2.setCourseDescription("Intensive");
        c2.setCourseTerm(2);
        c2.setCourseYear(1998);
        c2.setCourseID(2);

        c3.setCourseName("Machine Learning");
        c3.setCourseCapacity(100);
        c3.setCourseCode(103);
        c3.setCourseCredits(4);
        c3.setCourseFaculty(8);
        c3.setCourseDescription("Intermediate");
        c3.setCourseTerm(2);
        c3.setCourseYear(1998);
        c3.setCourseID(3);

        c4.setCourseName("Reinforcement Learning");
        c4.setCourseCapacity(100);
        c4.setCourseCode(104);
        c4.setCourseCredits(4);
        c4.setCourseFaculty(10);
        c4.setCourseDescription("Intermediate");
        c4.setCourseTerm(2);
        c4.setCourseYear(1998);
        c4.setCourseID(4);

        c5.setCourseName("Graph Theory");
        c5.setCourseCapacity(100);
        c5.setCourseCode(105);
        c5.setCourseCredits(4);
        c5.setCourseFaculty(10);
        c5.setCourseDescription("Intermediate");
        c5.setCourseTerm(2);
        c5.setCourseYear(1998);
        c5.setCourseID(5);

        p1.setID(1);
        p1.setPrerequisite(c1);
        p1.setCourseIdentity(c2);
        p1.setDescription("Hard");

        p2.setID(2);
        p2.setPrerequisite(c3);
        p2.setCourseIdentity(c2);
        p2.setDescription("Master");

        p3.setID(3);
        p3.setPrerequisite(c3);
        p3.setCourseIdentity(c1);
        p3.setDescription("Rookie");


        l1.setEmail("prateek.chhimwal@iiitb.ac.in");
        l1.setPassword("1234");

        adminDAO.addlogin(l1);

        coursesDAO.addCourse(c2);
        coursesDAO.addCourse(c1);
        coursesDAO.addCourse(c3);
        coursesDAO.addCourse(c4);
        coursesDAO.addCourse(c5);
        coursesPreDAO.addPrerequisiteCourse(p1);
        coursesPreDAO.addPrerequisiteCourse(p2);
        coursesPreDAO.addPrerequisiteCourse(p3);


    }
}
