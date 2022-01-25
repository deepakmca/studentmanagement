package io.deepak.studentmanagement.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "studentsemesterwisemarks")
public class StudentSemesterWiseMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int  studentId;
    private int semester;
    private int totalMarksObtained;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "studentId", nullable=false, insertable = false, updatable = false)
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
