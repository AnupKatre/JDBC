package org.example;

import org.example.DTO.ContactDTO;
import org.example.Model.Contact;
import org.example.Repository.ContactDBUtil;
import org.example.service.ContactServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static ContactDBUtil dbUtil;
    public static void main(String[] args) throws SQLException {
        ContactServiceImpl contactService = new ContactServiceImpl();
        Scanner inp = new Scanner(System.in);
        String Continue = "yes";
        do{
            System.out.println("Choose Operation :\n1.Add Contact \n2.Get Contacts \n3.Update Mobile Num \n4.Delete contact");
            int choise = inp.nextInt();
            switch (choise){
                case 1 :
                    System.out.println("Enter Contact Details : ");
                    System.out.print("contact Id : ");
                    Integer contactId = inp.nextInt();
                    System.out.print("contact Name : ");
                    String contactName = inp.next();
                    System.out.print("contact Email : ");
                    String email = inp.next();
                    System.out.print("contact Address : ");
                    String address = inp.next();
                    System.out.print("contact Mobile Number : ");
                    String MobileNum = inp.next();
                    ContactDTO contactDTO = new ContactDTO();
                    contactDTO.setContactId(contactId);
                    contactDTO.setContactName(contactName);
                    contactDTO.setEmail(email);
                    contactDTO.setAddress(address);
                    contactDTO.setMobileNum(MobileNum);
                    System.out.println();
                    System.out.println(contactService.addContact(contactDTO));
                    break;
                case 2:

                    List<Contact> contacts = contactService.getContacts();
                    contacts.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter contact Details : ");
                    System.out.print("Enter contact Id : ");
                    Integer id = inp.nextInt();
                    System.out.print("contact Mobile Number : ");
                    String mobileNum = inp.next();
                    System.out.println(contactService.updateContacts(id,mobileNum));
                    break;
                case 4:
                    System.out.println("Enter contact Details : ");
                    System.out.print("Enter contact Id : ");
                    Integer Id = inp.nextInt();
                    System.out.println(contactService.deleteContacts(Id));
                    break;
            }
            System.out.print("Do you want to continue?");
            Continue = inp.next();
        }while (Continue.equals("yes"));


    }
}