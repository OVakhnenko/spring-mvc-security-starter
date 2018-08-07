package com.vectree.billing.service.dao;

import com.vectree.billing.domain.User;
import com.vectree.billing.service.interfaces.UserRepository;
import lombok.Cleanup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO class for User.
 *
 * @version 0.1.
 */
@Repository("userDao")
public class UserDao implements UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        @Cleanup Session session = sessionFactory.openSession();
        session.persist(user);
        session.flush();
        LOGGER.info("User successfully saved. User: " + user);
    }

    @Override
    public void edit(User user) {
        @Cleanup Session session = sessionFactory.openSession();
        session.update(user);
        session.flush();
        LOGGER.info("User successfully updated. User: " + user);
    }

    @Override
    public void delete(int id) {
        @Cleanup Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.flush();
        LOGGER.info("User successfully deleted. User: " + user);
    }

    @Override
    public User getById(int id) {
        @Cleanup Session session = this.sessionFactory.openSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public User getByName(String name) {
        @Cleanup Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from User where username=:name");
        query.setParameter("name", name);
        return (User) query.uniqueResult();
    }

    @Override
    @SuppressWarnings({"unchecked", "JpaQlInspection"})
    public List<User> list() {
        @Cleanup Session session = this.sessionFactory.openSession();
        return session.createQuery("from User order by id").list();
    }
}
