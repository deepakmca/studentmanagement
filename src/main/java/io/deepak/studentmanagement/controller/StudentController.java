package io.deepak.studentmanagement.controller;

import io.deepak.studentmanagement.model.Student;
import io.deepak.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/getAllStudent")
    public ResponseEntity getAllStudent(){
       var list =  service.getAllStudent();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{studentId}")
    public ResponseEntity getStudentById(@PathVariable String studentId){
        var list =  service.getStudentById(studentId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity saveStudent(@RequestBody Student student){
       var message =  service.saveStudent(student);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/getStudentPerformance/{semester}/{branchCode}")
    public ResponseEntity getStudentPerformance(@PathVariable int semester, @PathVariable String branchCode){
        var list =  service.getStudentPerformance(semester, branchCode);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
