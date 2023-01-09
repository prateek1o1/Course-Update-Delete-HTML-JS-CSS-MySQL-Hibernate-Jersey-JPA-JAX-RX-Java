package com.example.academia.course.dao;

import com.example.academia.course.bean.Admin;

public interface AdminDAO {

    Admin verify(Admin lObj);
    public boolean addlogin(Admin l);
}
