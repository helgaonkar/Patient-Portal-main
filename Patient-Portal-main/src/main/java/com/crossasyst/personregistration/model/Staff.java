package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private String phoneNo;
    private StaffType staffType;
    private User user;
}
