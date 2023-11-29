package com.ouatar.springboot.demo.myapp.rest;
import com.ouatar.springboot.demo.myapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    // define @PostConstruct to load the dtudent data
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poskf","hhfkf0","jhfj")) ;
        theStudents.add(new Student("dk","f,0","jg44jf")) ;
        theStudents.add(new Student("Poldls","hh0","jfdddjf")) ;

    }
    @GetMapping("/students")
    public List<Student> getStudents(){
            return  theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check the studentid again list size

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundExption("Student id not found -  " + studentId);
        }
        return theStudents.get(studentId);
    }


}

