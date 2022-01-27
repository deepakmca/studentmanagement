package io.deepak.studentmanagement.serviceimpl;

import io.deepak.studentmanagement.model.Student;
import io.deepak.studentmanagement.repository.StudentRepository;
import io.deepak.studentmanagement.repository.StudentSemesterWiseMarksRepository;
import io.deepak.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentRepository repository;

    @Autowired
    StudentSemesterWiseMarksRepository studentSemesterWiseMarksRepository;

    @Override
    public List getAllStudent() {
        var student = repository.findAll();
        if(student != null){
            Map<String, Object> map = new HashMap<>();
            map.put("total" , ((Collection<Student>) student).size());
            map.put("data" , student);
            return List.of(map);
        }else{
            return List.of("No Record Found!!");
        }
    }

    @Override
    public Student getStudentById(String studentId) {
        Student l = null;
        try{
          l =  repository.findById(Integer.parseInt(studentId)).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        return l;
    }

    @Override
    public String saveStudent(Student student) {
        var message = "";
        var lastIds = 1;

        var list = (List<Student>) repository.findAllByOrderByStudentIdDesc();
        lastIds = list.size() < 1 ? lastIds : list.get(0).getStudentId();
        if (repository.findByEmail(student.getEmail()).isEmpty()) {
            var obj = Student.builder()
                    .code(student.getBranchCode().concat("_").concat(String.valueOf(student.getAdmissionYear())).concat("_").concat(String.valueOf(lastIds)))
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .email(student.getEmail())
                    .mobile(student.getMobile())
                    .admissionYear(student.getAdmissionYear())
                    .branchCode(student.getBranchCode())
                    .course(student.getCourse())
                    .currentSemester(student.getCurrentSemester())
                    .marks(student.getMarks())
                    .build();
             repository.save(obj);
            message ="Student Create Successfully";
        }else{
            message ="Student Email found, Please use another Email";
        }
        return message;
    }

    @Override
    public List getStudentPerformance(int semester, String branchCode) {
    Map map = null;
        Map map1 = null;
        Map map2 = null;
        Map map3 = null;
    var list = studentSemesterWiseMarksRepository.getMarks(semester, branchCode);

    int c1 =1, c2=1, c3=1, c4=1;
    List localList = new ArrayList();
    for(int i=0; i < list.size(); i++){
       Map m = (Map) list.get(i);
        int marks = Integer.parseInt(m.get("totalMarksObtained").toString());
        int percentage = ((marks * 100) / 1000);
        if(percentage >= 75 && percentage < 100){
            if(map != null && map.containsValue("75-100")){
                map.put("range", "75-100");
                map.put("total", c1);
            }else{
                map = new HashMap();
                map.put("range", "75-100");
                map.put("total", c1);
            }
            c1++;
        }else if(percentage >= 50 && percentage < 75){
            if(map1 != null && map1.containsValue("50-75")){
                map1.put("range", "50-75");
                map1.put("total", c2);
            }else{
                map1 = new HashMap();
                map1.put("range", "50-75");
                map1.put("total", c2);
            }
            c2++;
        }else if(percentage >= 25 && percentage < 50){
            if(map2 != null && map2.containsValue("25-50")){
                map2.put("range", "25-50");
                map2.put("total", c3);
            }else{
                map2 = new HashMap();
                map2.put("range", "25-50");
                map2.put("total", c3);
            }
            c3++;
        }else{
            if(map3 != null && map3.containsValue("0-25")){
                map3.put("range", "0-25");
                map3.put("total", c4);
            }else {
                map3 = new HashMap();
                map3.put("range", "0-25");
                map3.put("total", c4);
            }
            c4++;
        }
    }
        localList.add(map);
        localList.add(map1);
        localList.add(map2);
        localList.add(map3);
        return localList;
    }
}
