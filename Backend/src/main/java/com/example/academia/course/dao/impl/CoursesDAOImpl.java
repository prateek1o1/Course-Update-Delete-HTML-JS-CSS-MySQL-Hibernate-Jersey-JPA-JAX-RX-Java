package com.example.academia.course.dao.impl;

import com.example.academia.course.bean.Courses;
import com.example.academia.course.dao.CoursesDAO;
import com.example.academia.course.util.HibernateSessionUtil;
import jakarta.ws.rs.PathParam;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

public class CoursesDAOImpl implements CoursesDAO {

    @Override
    public boolean DeleteCourse(int courseID) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String query_string="DELETE FROM Courses WHERE courseID=:courseID";
            Query query=session.createQuery(query_string);
            query.setParameter("courseID", courseID);
            int i = query.executeUpdate();
            transaction.commit();
            if(i>0){

                return true;
            }
            else
            {
                return false;
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }
    @Override
    public List<String> ExtractCoursesList() {
        List<String> courseList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){

            String sql = "SELECT courseName FROM Courses";
            Query query = session.createQuery(sql);
            List<Object> list =query.list();
            for(Object obj : list){
                String s=(String) obj;
                courseList.add(s);
            }
            return courseList;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }

    }

    @Override
    public boolean addCourse(Courses courObj)
    {
        try(Session session = HibernateSessionUtil.getSession())
        {
            Transaction t = session.beginTransaction();
            session.save(courObj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public boolean UpdateCourseName(int courseID, String updatedName) {

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query query = session.createQuery("from Courses where courseID=:ID");
            query.setParameter("ID", courseID);

            Courses result = (Courses)query.list().get(0);
            result.setCourseName(updatedName);
            session.update(result);
            t.commit();
            return true;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }


   public boolean UpdateCapacity(int courseID,int capacity)
    {

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query query = session.createQuery("from Courses where courseID=:ID");
            query.setParameter("ID", courseID);

            Courses result = (Courses)query.list().get(0);
            result.setCourseCapacity(capacity);
            session.update(result);
            t.commit();
            return true;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}