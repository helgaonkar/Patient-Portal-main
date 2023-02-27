package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticeContact {
    private Long practiceContactId;
    private String phoneNumber;
    private String emailId;
    private String alternatePhoneNumber;
    private String contactPerson;
    private Practice practice;
    private PracticeContactType practiceContactType;
}
