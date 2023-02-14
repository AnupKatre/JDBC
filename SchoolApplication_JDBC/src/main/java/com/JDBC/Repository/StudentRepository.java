package com.JDBC.Repository;

import com.JDBC.Model.Student;
import com.JDBC.Model.StudentDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository {
    private static Connection con = StudentUtil.getConnection();


    public boolean studentPresent(int id) throws SQLException {
        String findQuery = "select * from student where studentId = ?";
        PreparedStatement stmt = con.prepareStatement(findQuery);
        stmt.setInt(1,id);


        if(stmt.executeQuery().next()){
            return true;
        }
        return false;
    }
    public Student findStudent(int stdId) throws SQLException {

        String findQuery = "select * from student where studentId = ?";

        PreparedStatement stmt = con.prepareStatement(findQuery);
        stmt.setInt(1,stdId);
        ResultSet res = stmt.executeQuery();

        if (res.next()) {
            Student student = new Student(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
            return student;
        }
        return null;
    }

    public boolean addStudent(StudentDTO student) throws SQLException {
        String insertQuery = "insert into student values (? ,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertQuery);
        stmt.setInt(1, student.getStdId());
        stmt.setString(2, student.getStdName());
        stmt.setString(3, student.getStdAddress());
        stmt.setString(4, student.getStdEmail());
        return stmt.execute();
    }

    public List<Student> getStudent() throws SQLException {
        String getQuery = "Select * from student";
        PreparedStatement stmt = con.prepareStatement(getQuery);
        ResultSet r = stmt.executeQuery();
        List<Student> studentList = new ArrayList<Student>();
        while (r.next()) {
            studentList.add(new Student(r.getInt(1), r.getString(2), r.getString(3), r.getString(4)));
        }
        return studentList;
    }

    public String updateStudent(int stdId, StudentDTO student) throws SQLException {
        String updateQuery = "Update student set studentId = ? , studentName = ? , studentAddress = ? , studentEmail = ?  where studentId = ?";
        PreparedStatement stmt = con.prepareStatement(updateQuery);
        stmt.setInt(1, stdId);
        stmt.setString(2, student.getStdName());
        stmt.setString(3, student.getStdAddress());
        stmt.setString(4, student.getStdEmail());
        stmt.setInt(5, stdId);
        stmt.executeUpdate();
        return "Updated Successfully";
    }

    public String deleteStudent(int stdId) throws SQLException {
        String deleteQuery = "delete from student where studentId = ?";
        PreparedStatement stmt = con.prepareStatement(deleteQuery);
        stmt.setInt(1, stdId);
        stmt.executeUpdate();
        return "Deleted Successfully";
    }

    public String addStudentUsingProcedure(StudentDTO student) throws SQLException {


        CallableStatement stmt = con.prepareCall("{call addStudent(?,?,?,?)}");
        stmt.setInt(1, student.getStdId());
        stmt.setString(2, student.getStdName());
        stmt.setString(3, student.getStdAddress());
        stmt.setString(4, student.getStdEmail());
        stmt.execute();
        return "Student Added";
    }

    public List<Student> getStudentsUsingProcedure() throws SQLException {
        CallableStatement stmt = con.prepareCall("{call getStudents()}");
        ResultSet r = stmt.executeQuery();
        List<Student> studentList = new ArrayList<Student>();
        while (r.next()) {
            studentList.add(new Student(r.getInt(1), r.getString(2), r.getString(3), r.getString(4)));
        }
        return studentList;

    }

    public String updateContactsUsingProcedure(int id2, StudentDTO student) throws SQLException{
        CallableStatement stmt = con.prepareCall("{call updateStudent(?,?,?,?,?)}");
        stmt.setInt(1, id2);
        stmt.setInt(2, student.getStdId());
        stmt.setString(3, student.getStdName());
        stmt.setString(4, student.getStdAddress());
        stmt.setString(5, student.getStdEmail());
        stmt.execute();
        return "Student Updated";
    }

    public String deleteStudentUsingProcedure(int id5) throws SQLException {
        CallableStatement stmt = con.prepareCall("{call deleteStudent(?)}");
        stmt.setInt(1,id5);
        stmt.execute();
        return "Delete successfully";
    }

    public String findStudentUsingProcedure(int id6) throws SQLException{
        CallableStatement stmt = con.prepareCall("{call findStudent(?)}");
        stmt.setInt(1,id6);
        ResultSet res = stmt.executeQuery();
        if (res.next()) {
            Student student = new Student(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
            return student.toString();
        }
        return null;
    }
}
