package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class UserReadRepository {

    public List<User> readUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;
            transaction = session.beginTransaction();
            List<User> users =
                    session.createQuery("FROM User", User.class).list();
            transaction.commit();
            return users;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
