package com.example.hibernatepostgress.dao;

import com.example.hibernatepostgress.model.Person;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @Autowired
    private SessionFactory factory;

    public void savePerson(Person person) {
        getSession().save(person);
    }

    private Session getSession() {
        Session session = factory.getCurrentSession();
        if (session == null) {
            session = factory.openSession();
        }
        return session;
    }
}
