package io.deepak.studentmanagement.controller;

import io.deepak.studentmanagement.model.Student;
import io.deepak.studentmanagement.model.StudentSemesterWiseMarks;
import io.deepak.studentmanagement.service.StudentSemesterWiseMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marks")
public class StudentSemesterWiseMarksController {

    @Autowired
    StudentSemesterWiseMarksService service;

    @PostMapping("/saveMarks")
    public ResponseEntity saveStudent(@RequestBody StudentSemesterWiseMarks marks){
        String message =  service.saveStudentSemesterWiseMarks(marks);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
