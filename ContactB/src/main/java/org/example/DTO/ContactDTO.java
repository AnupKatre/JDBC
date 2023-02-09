package org.example.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Integer contactId;
    private String contactName;
    private String email;
    private String Address;
    private String mobileNum;

}
