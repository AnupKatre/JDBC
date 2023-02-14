package com.JDBC;

import com.JDBC.Exception.QueryFailedException;
import com.JDBC.Model.StudentDTO;
import com.JDBC.Model.Student;
import com.JDBC.Repository.StudentRepository;
import com.JDBC.Service.ApplicationService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App 
{

    static StudentRepository repository;
    public static void main(String[] args) throws SQLException, QueryFailedException {
        ApplicationService service = new ApplicationService();
        StudentRepository repository = new StudentRepository();
        Scanner inp = new Scanner(System.in);
        String Continue = "Y";
        String flag = "ON";
        do{
            System.out.println("\n============== Choose Operation ==============\n1.Add Student \n2.Get Students \n3.Update Student \n4.Delete Student\n5.Find Student\n9.Procedure\n");
            String choise = inp.next();
            switch (choise) {
                case "1":
                    System.out.println("Enter Student Details : ");
                    System.out.print("Student Id : ");
                    int stdId = inp.nextInt();
                    System.out.print("Student Name : ");
                    String stdName = inp.next();
                    System.out.print("Student Address : ");
                    String address = inp.next();
                    System.out.print("Student Email : ");
                    String email = inp.next();
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setStdId(stdId);
                    studentDTO.setStdName(stdName);
                    studentDTO.setStdAddress(address);
                    studentDTO.setStdEmail(email);
                    System.out.println();
                    System.out.println(service.addStudent(studentDTO));
                    break;
                case "2":

                    List<Student> students = service.getStudents();
                    students.stream().forEach((x) -> System.out.println(x.toString()));
                    break;
                case "3":
                    System.out.println("Enter Student Details : ");
                    System.out.print("Enter Student Id : ");
                    int id = inp.nextInt();
                    System.out.print("Student Name : ");
                    String name = inp.next();
                    System.out.print("Student Address : ");
                    String stdAddress = inp.next();
                    System.out.print("Student Email : ");
                    String stdEmail = inp.next();
                    StudentDTO studentDTO1 = new StudentDTO(id, name, stdAddress, stdEmail);
                    System.out.println(service.updateContacts(id, studentDTO1));
                    break;
                case "4":
                    System.out.println("Enter Students Details : ");
                    System.out.print("Enter Student Id : ");
                    int id4 = inp.nextInt();
                    System.out.println(service.deleteStudent(id4));
                    break;
                case "5":
                    System.out.println("Enter Students Details : ");
                    System.out.print("Enter Student Id : ");
                    int id9 = inp.nextInt();
                    System.out.println(service.findStudent(id9));
                    break;
                case "exit":
                    flag = "Exit";
                    break;
                case "9":
                    System.out.println("Choose Operation :\n1.Add Student \n2.Get Students \n3.Update Student \n4.Delete Student\n5.Find Student");
                    String c = inp.next();
                    switch (c) {
                        case "1":
                            System.out.println("Enter Student Details : ");
                            System.out.print("Student Id : ");
                            int stdId1 = inp.nextInt();
                            System.out.print("Student Name : ");
                            String stdName1 = inp.next();
                            System.out.print("Student Address : ");
                            String address1 = inp.next();
                            System.out.print("Student Email : ");
                            String email1 = inp.next();
                            StudentDTO newStudentDTO = new StudentDTO();
                            newStudentDTO.setStdId(stdId1);
                            newStudentDTO.setStdName(stdName1);
                            newStudentDTO.setStdAddress(address1);
                            newStudentDTO.setStdEmail(email1);
                            System.out.println();
                            System.out.println(service.addStudentUsingProcedure(newStudentDTO));
                            break;
                        case "2":

                            List<Student> student = service.getStudentsUsingProcedure();
                            student.stream().forEach((x) -> System.out.println(x.toString()));
                            break;
                        case "3":
                            System.out.println("Enter Student Details : ");
                            System.out.print("Enter Student Id : ");
                            int id2 = inp.nextInt();
                            System.out.print("Student Name : ");
                            String name2 = inp.next();
                            System.out.print("Student Address : ");
                            String stdAddress2 = inp.next();
                            System.out.print("Student Email : ");
                            String stdEmail2 = inp.next();
                            StudentDTO studentDTO0 = new StudentDTO(id2, name2, stdAddress2, stdEmail2);
                            System.out.println(service.updateContactsUsingProcedure(id2, studentDTO0));
                            break;
                        case "4":
                            System.out.println("Enter Students Details : ");
                            System.out.print("Enter Student Id : ");
                            int id5 = inp.nextInt();
                            System.out.println(service.deleteStudentUsingProcedure(id5));
                            break;
                        case "5":
                            System.out.println("Enter Students Details : ");
                            System.out.print("Enter Student Id : ");
                            int id6 = inp.nextInt();
                            System.out.println(service.findStudentUsingProcedure(id6));
                            break;
                    }
                    break;
            }
//            System.out.print("Do you want to continue?\n(Y/N) - ");
//            Continue = inp.next();
        }while (flag.equalsIgnoreCase("ON"));
    }
}
