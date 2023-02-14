package com.JDBC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDTO {
    private int stdId;
    private String stdName;
    private String stdAddress;
    private String stdEmail;
}
