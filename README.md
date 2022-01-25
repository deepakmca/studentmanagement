# studentmanagement
Student Management System

List of APIs
**1** get All Student List Method Type - GET- http://localhost:8081/student/getAllStudent
**2** get Student BY ID Method Type - GET- http://localhost:8081/student/getStudentById/5
**3** save Student Data - Method Type - POST - http://localhost:8081/student/saveStudent
JSON Data-
{
"firstName":"Gaurav",
"lastName":"Sharma",
"email":"gaurav@gmail.com",
"mobile":"9990312121",
"admissionYear":"2021",
"branchCode":"IT",
"course":"MCA",
"currentSemester":"4"
}

**4** save Marks Data Method Type - POST - http://localhost:8081/marks/saveMarks
{
    "studentId":"8",
    "semester":"4",
    "totalMarksObtained":"900"
}
**5** get student performance Data - Method Type GET http://localhost:8081/student/getStudentPerformance/3/IT
{
    "semester":"4",
    "branchCode":"IT"
}
