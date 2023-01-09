package com.example.academia.course.bean;

import jakarta.persistence.*;

@Entity
@Table(name= "Admin")
public class Admin {
    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    public Admin() {
    }
    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
