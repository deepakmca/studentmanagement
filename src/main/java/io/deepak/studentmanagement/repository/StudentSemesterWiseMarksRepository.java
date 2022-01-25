package io.deepak.studentmanagement.repository;

import io.deepak.studentmanagement.model.StudentSemesterWiseMarks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSemesterWiseMarksRepository extends CrudRepository<StudentSemesterWiseMarks, Integer> {

    @Query("select new Map(a.totalMarksObtained as totalMarksObtained, b.id.studentId as studentId) from" +
            " StudentSemesterWiseMarks a, Student b " +
            "where a.studentId = b.id.studentId and a.semester = :semester and b.branchCode = :branchCode ")
    public List getMarks(@Param("semester") int semester, @Param("branchCode") String branchCode);
}
