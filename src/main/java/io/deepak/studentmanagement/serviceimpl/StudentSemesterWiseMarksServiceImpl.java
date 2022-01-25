package io.deepak.studentmanagement.serviceimpl;

import io.deepak.studentmanagement.model.StudentSemesterWiseMarks;
import io.deepak.studentmanagement.repository.StudentSemesterWiseMarksRepository;
import io.deepak.studentmanagement.service.StudentSemesterWiseMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSemesterWiseMarksServiceImpl implements StudentSemesterWiseMarksService {

    @Autowired
    StudentSemesterWiseMarksRepository repository;

    @Override
    public String saveStudentSemesterWiseMarks(StudentSemesterWiseMarks marks) {
           var obj = StudentSemesterWiseMarks.builder()
                   .studentId(marks.getStudentId())
                   .totalMarksObtained(marks.getTotalMarksObtained())
                   .semester(marks.getSemester())
                   .build();
             repository.save(obj);
        return "Student Semester Wise Marks Entry Successfully";
    }
}
