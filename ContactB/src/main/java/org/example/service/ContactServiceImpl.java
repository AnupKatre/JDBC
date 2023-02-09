package org.example.service;

import org.example.DTO.ContactDTO;
import org.example.Exception.ContactDBException;
import org.example.Model.Contact;
import org.example.Repository.ContactRepository;

import java.sql.SQLException;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactRepository contactRepository = new ContactRepository() ;
    @Override
    public Contact findContact (Integer contactId) throws Exception{
          Contact contact =  contactRepository.findMovie(contactId);
            return contact;
    }

    @Override
    public String addContact (ContactDTO contactDTO) throws SQLException{
        try {

            if(contactRepository.findMovie(contactDTO.getContactId()) != null){
                throw new ContactDBException("Service.CONTACT_ALREADY_AVAILABLE");
            }
        }catch (ContactDBException e){
            return e.getMessage();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Contact movie = new Contact(contactDTO.getContactId(),contactDTO.getContactName(), contactDTO.getEmail(), contactDTO.getAddress(), contactDTO.getMobileNum());
        contactRepository.addMovie(movie);
        return "Added Succesfully";
    }

    @Override
    public List<Contact> getContacts () throws SQLException{
        List<Contact> movies = contactRepository.getMovie();
        try {
            if (movies == null)
                throw new ContactDBException("Service.NO_CONTACTS_UNAVAILABLE");
        }catch (ContactDBException e){
            System.out.println(e.getMessage());
        }
        return movies;
    }

    @Override
    public String updateContacts (Integer contactId, String mobileNum) throws SQLException{
        try {
            Contact ContactAlreadyExists = contactRepository.findMovie(contactId);
            if(ContactAlreadyExists == null){
                throw new ContactDBException("Service.CONTACTS_Already_Exists");
            }
        }catch (ContactDBException e){
            return e.getMessage();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return contactRepository.updateContacts(contactId,mobileNum);
    }

    @Override
    public String deleteContacts (Integer contactId) throws SQLException{
        try {
            Contact ContactAlreadyExists = contactRepository.findMovie(contactId);
            if(ContactAlreadyExists == null){
                throw new ContactDBException("Service.CONTACTS_Already_Exists");
            }
        }catch (ContactDBException e){
            return e.getMessage();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return contactRepository.deleteMovie(contactId);
    }
}
