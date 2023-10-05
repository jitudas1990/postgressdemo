package com.example.hibernatepostgress.dao;

import com.example.hibernatepostgress.model.Adress;
import com.example.hibernatepostgress.model.Person;
import jakarta.persistence.Query;
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

    public void saveAddress(Adress adress) {
        getSession().save(adress);
    }

    public Person getPersonDetails() {
        Person person = getSession().get(Person.class,2);

       // Person person = getSession().load(Person.class,1);
       // System.out.println(person);
        /*Using Hql query single result*/
       /* String query = "from Person";
        Query query1 = getSession().createQuery(query);
        List<Person> list = query1.getResultList();
        System.out.println(list.get(0));*/


        return person;
    }
    public List<Person> getPersonDetailsList() {
        /*Using Hql query multiple result*/
       String query = "from Person where name =:x";
        Query query1 = getSession().createQuery(query);
        query1.setParameter("x","Lipi");
        List<Person> list = query1.getResultList();
        return list;
    }
}
