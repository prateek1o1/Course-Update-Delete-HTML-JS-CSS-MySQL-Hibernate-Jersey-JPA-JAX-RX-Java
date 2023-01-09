package com.example.academia.course.dao.impl;

import com.example.academia.course.bean.Admin;
import com.example.academia.course.dao.AdminDAO;
import com.example.academia.course.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public boolean addlogin(Admin l) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(l);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public Admin verify(Admin lObj) {

        try (Session session = HibernateSessionUtil.getSession();){
            String loginEmail = lObj.getEmail();
            String loginPassword = lObj.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Admin WHERE email = :loginEmail and password = :loginPassword"
                            )
                            .setParameter("loginEmail", loginEmail)
                            .setParameter("loginPassword", loginPassword)
                            .list()
            );

            // If no valid Student found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Admin) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }
}
