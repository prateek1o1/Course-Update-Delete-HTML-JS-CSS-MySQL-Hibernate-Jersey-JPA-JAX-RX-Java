package com.example.academia.course.service;

import com.example.academia.course.bean.Admin;
import com.example.academia.course.dao.AdminDAO;
import com.example.academia.course.dao.impl.AdminDAOImpl;

public class AdminService {
    AdminDAOImpl studentDAO = new AdminDAOImpl();

    public Admin verify(Admin aObj){
        Admin loggedInStudent = studentDAO.verify(aObj);

        // If no login happens, then return null
        if (loggedInStudent == null)
            return null;

        return loggedInStudent;
    }
}
