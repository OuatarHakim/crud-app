package com.ouatar.springboot.demo.myapp.dao;

import com.ouatar.springboot.demo.myapp.entity.Student;

public interface StudentDAO {

    void save(Student theStudent );
    Student findById(int id);
}
