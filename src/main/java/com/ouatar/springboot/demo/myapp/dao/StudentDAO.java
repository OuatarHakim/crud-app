package com.ouatar.springboot.demo.myapp.dao;

import com.ouatar.springboot.demo.myapp.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent );
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastname);
    void update(Student student);
    void delete(int id);

    int  deleteAll();
}
