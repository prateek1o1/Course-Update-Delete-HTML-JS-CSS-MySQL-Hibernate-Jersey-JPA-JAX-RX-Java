package com.example.academia.course.dao.impl;

import com.example.academia.course.bean.Courses;
import com.example.academia.course.bean.Prerequisite;
import com.example.academia.course.dao.PrerequisiteDAO;
import com.example.academia.course.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PrerequisiteDAOImlp implements PrerequisiteDAO {

    @Override
    public boolean addPrerequisiteCourse (Prerequisite preObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(preObj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
//    @Override
//    public boolean UpdateCID(int courseID,int newID)
//    {
//
//        try (Session session = HibernateSessionUtil.getSession()) {
//            Transaction t = session.beginTransaction();
//
//            Query query = session.createQuery("from Prerequisite where courseIdentity=:ID");
//            query.setParameter("ID", courseID);
//
//            Courses result = (Courses)query.list().get(0);
//            result.setCourseID(newID);
//            session.update(result);
//            t.commit();
//            return true;
//
//        }
//        catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//            return false;
//        }
//    }
//    @Override
//    public boolean UpdatePID(int courseID,int newID)
//    {
//
//        try (Session session = HibernateSessionUtil.getSession()) {
//            Transaction t = session.beginTransaction();
//
//            Query query = session.createQuery("from Prerequisite where Prerequisite=:ID");
//            query.setParameter("ID", courseID);
//
//            Courses result = (Courses)query.list().get(0);
//            result.setCourseID(newID);
//            session.update(result);
//            t.commit();
//            return true;
//
//        }
//        catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//            return false;
//        }
//    }
}
