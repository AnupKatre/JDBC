package org.example.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Integer contactId;
    private String contactName;
    private String email;
    private String Address;
    private String mobileNum;

}
