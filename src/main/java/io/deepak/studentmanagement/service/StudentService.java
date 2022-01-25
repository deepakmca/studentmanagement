package io.deepak.studentmanagement.service;

import io.deepak.studentmanagement.model.Student;

import java.util.List;

public interface StudentService {

    public List getAllStudent();

    public Student getStudentById(String studentId);

    public String saveStudent(Student Student);

    public List getStudentPerformance(int semester, String branchCode);
}
