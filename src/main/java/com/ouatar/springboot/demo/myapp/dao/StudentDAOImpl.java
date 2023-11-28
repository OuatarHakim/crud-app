package com.ouatar.springboot.demo.myapp.dao;

import com.ouatar.springboot.demo.myapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    // define field for entity manager

    private EntityManager entityManager;


    //inhect entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> thequery = entityManager.createQuery("FROM Student",Student.class);
        return thequery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastname) {
        TypedQuery<Student> thequery = entityManager.createQuery("FROM Student WHERE lastname=:thedata",Student.class);
        thequery.setParameter("thedata",lastname);
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        Student student1 = entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(int id) {
       Student s = entityManager.find(Student.class,id);
       entityManager.remove(s);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return  numRowsDeleted;
    }
}
