package com.example.academia.course.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;


import java.util.List;

@Entity
@Table(name= "Courses")
public class Courses {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;

    @Column(name = "course_code", nullable = false, unique = true)
    private Integer courseCode;

    @Column(name = "name", nullable = false)
    private String courseName;

    @Column(name = "description")
    private String courseDescription;

    @Column(name = "year", nullable = false)
    private Integer courseYear;

    @Column(name = "term", nullable = false)
    private Integer courseTerm;

    @Column(name = "credits", nullable = false)
    private Integer courseCredits;

    @Column(name = "capacity", nullable = false)
    private Integer courseCapacity;

    @Column(name = "faculty", nullable = false)
    private Integer courseFaculty;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @OneToMany(mappedBy = "Prerequisite" , fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Prerequisite> prerequisiteList;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "courseIdentity" , fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Prerequisite> courseList;

    public Courses() {

    }

    public Courses(Integer courseID, Integer courseCode, String courseName, String courseDescription, Integer courseYear, Integer courseTerm, Integer courseCredits, Integer courseCapacity, Integer courseFaculty) {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseYear = courseYear;
        this.courseTerm = courseTerm;
        this.courseCredits = courseCredits;
        this.courseCapacity = courseCapacity;
        this.courseFaculty = courseFaculty;
    }

    public List<Prerequisite> getPrerequisiteList() {
        return prerequisiteList;
    }

    public void setPrerequisiteList(List<Prerequisite> prerequisiteList) {
        this.prerequisiteList = prerequisiteList;
    }

    public List<Prerequisite> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Prerequisite> courseList) {
        this.courseList = courseList;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Integer getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(Integer courseYear) {
        this.courseYear = courseYear;
    }

    public Integer getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(Integer courseTerm) {
        this.courseTerm = courseTerm;
    }

    public Integer getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(Integer courseCredits) {
        this.courseCredits = courseCredits;
    }

    public Integer getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(Integer courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public Integer getCourseFaculty() {
        return courseFaculty;
    }

    public void setCourseFaculty(Integer courseFaculty) {
        this.courseFaculty = courseFaculty;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseID=" + courseID +
                ", courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseYear=" + courseYear +
                ", courseTerm=" + courseTerm +
                ", courseCredits=" + courseCredits +
                ", courseCapacity=" + courseCapacity +
                ", courseFaculty=" + courseFaculty +
                ", prerequisiteList=" + prerequisiteList +
                ", courseList=" + courseList +
                '}';
    }
}