package com.example.academia.course.bean;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Prerequisite {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "course_identity")
    private Courses courseIdentity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="prerequisite", nullable = false)
    private Courses Prerequisite;

    @Column(name= "description")
    private String Description;


    public Prerequisite(){
    }
    public Prerequisite(Integer ID, Courses courseIdentity, Courses prerequisite, String description) {
        this.ID = ID;
        this.courseIdentity = courseIdentity;
        Prerequisite = prerequisite;
        Description = description;
    }

    @Override
    public String toString() {
        return "Course_Prerequisite{" +
                "ID=" + ID +
                ", courseIdentity=" + courseIdentity +
                ", Prerequisite=" + Prerequisite +
                ", Description='" + Description + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Courses getCourseIdentity() {
        return courseIdentity;
    }

    public void setCourseIdentity(Courses courseIdentity) {
        this.courseIdentity = courseIdentity;
    }

    public Courses getPrerequisite() {
        return Prerequisite;
    }

    public void setPrerequisite(Courses prerequisite) {
        Prerequisite = prerequisite;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


}
