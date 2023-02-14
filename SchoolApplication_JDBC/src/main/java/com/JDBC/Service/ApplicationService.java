package com.JDBC.Service;

import com.JDBC.Exception.QueryFailedException;
import com.JDBC.Model.Student;
import com.JDBC.Model.StudentDTO;
import com.JDBC.Repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class ApplicationService {

    private StudentRepository repository = new StudentRepository();

    public String addStudent(StudentDTO student) throws QueryFailedException, SQLException {
//        if (repository.addStudent(student)) {
//        }

        if(!repository.studentPresent(student.getStdId())){

            repository.addStudent(student);
            return "Student added successfully";
        }
        return "Student ID already Exist!";


//        return "Student not added";
    }

    public List<Student> getStudents() throws SQLException {
        return repository.getStudent();
    }

    public String updateContacts(int id, StudentDTO student) throws SQLException {
        if(repository.studentPresent(student.getStdId())){
            return repository.updateStudent(id, student);
        }
        return "Student ID Not Present!";
    }

    public String deleteStudent(int id) throws SQLException {
        if(repository.studentPresent(id)) return repository.deleteStudent(id);
        return "Delete Operation Failed!\nStudent Id Not present.";
    }


    public String findStudent(int id9) throws SQLException,QueryFailedException {
        if(repository.studentPresent(id9)){

            return repository.findStudent(id9).toString();
        }
        return "Student not present";
    }
//=====================================================================================================================
//=====================================================================================================================
    public String addStudentUsingProcedure(StudentDTO newStudentDTO) throws SQLException {
        if(!repository.studentPresent(newStudentDTO.getStdId())){
            return repository.addStudentUsingProcedure(newStudentDTO);
        }
        return "Student ID already Exist!";
    }

    public List<Student> getStudentsUsingProcedure() throws SQLException {
        return repository.getStudentsUsingProcedure();
    }

    public String updateContactsUsingProcedure(int id2, StudentDTO student) throws SQLException {
        if(repository.studentPresent(student.getStdId())){
            return repository.updateContactsUsingProcedure(id2,student);
        }
        return "Student ID Not Present";
    }

    public String deleteStudentUsingProcedure(int id5) throws SQLException {
        if(repository.studentPresent(id5)){
            return repository.deleteStudentUsingProcedure(id5);
        }
        return "Student ID Not Present";
    }

    public String findStudentUsingProcedure(int id6) throws SQLException {
        if(repository.studentPresent(id6)){
            return repository.findStudentUsingProcedure(id6);
        }
        return "Student Id Not present.";
    }
}
