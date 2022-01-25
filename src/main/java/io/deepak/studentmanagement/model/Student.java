package io.deepak.studentmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(exclude = "student")
@EqualsAndHashCode(exclude = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;
    private int admissionYear;
    private String branchCode;
    private String course;
    private int currentSemester;

    @OneToMany(mappedBy="student")
    private Set<StudentSemesterWiseMarks> marks;


}
