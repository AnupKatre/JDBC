package org.example.Repository;

import org.example.Model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContactRepository {
    private static Connection con = ContactDBUtil.getConnection();

    public Contact findMovie(Integer contactId) throws SQLException {
        System.out.println("From FindMovie Method of repository ");
        System.out.println(con.toString());

        String findQuery = "select * from contacts where contactId = ?";

        PreparedStatement stmt = con.prepareStatement(findQuery);
        stmt.setInt(1,contactId);
        ResultSet res = stmt.executeQuery();

        if (res.next()) {
            Contact contact = new Contact(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            return contact;
        }
        return null;
    }

    public boolean addMovie(Contact contact) throws SQLException {
        String insertQuery = "insert into contacts values (? ,?,?,? ,?)";
        PreparedStatement stmt = con.prepareStatement(insertQuery);
        stmt.setInt(1, contact.getContactId());
        stmt.setString(2, contact.getContactName());
        stmt.setString(3, contact.getEmail());
        stmt.setString(4, contact.getAddress());
        stmt.setString(5, contact.getMobileNum());
        return stmt.execute();
    }

    public List<Contact> getMovie() throws SQLException {
        String sql1 = "Select * from contacts";
        PreparedStatement stmt = con.prepareStatement(sql1);
        ResultSet r = stmt.executeQuery();
        List<Contact> contactList = new ArrayList<>();
        while (r.next()) {
            contactList.add(new Contact(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)));
        }
        return contactList;
    }

    public String updateContacts(Integer contactId, String mobileNum) throws SQLException {
        String updateQuery = "Update contacts set mobileNum = ?  where contactId = ?";
        PreparedStatement stmt = con.prepareStatement(updateQuery);
        stmt.setString(1, mobileNum);
        stmt.setInt(2, contactId);
        stmt.executeUpdate();
        return "Updated Successfully";
    }

    public String deleteMovie(Integer contactId) throws SQLException {
        String updateQuery = "delete from contacts where contactId = ?";
        PreparedStatement stmt = con.prepareStatement(updateQuery);
        stmt.setInt(1, contactId);
        stmt.executeUpdate();
        return "Deleted Successfully";
    }
}
