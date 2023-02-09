package org.example.service;

import org.example.DTO.ContactDTO;
import org.example.Model.Contact;

import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    public Contact findContact (Integer contactId) throws Exception;
    public String addContact (ContactDTO contactDTO) throws SQLException;
    public List<Contact> getContacts () throws SQLException;
    public String updateContacts (Integer contactId, String mobileNum) throws SQLException;
    public String deleteContacts (Integer contactId) throws SQLException;

}
