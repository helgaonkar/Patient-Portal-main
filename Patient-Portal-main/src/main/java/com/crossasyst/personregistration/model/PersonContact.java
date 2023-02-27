package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonContact {

    private String homePhoneNumber;
    private String alternatePhoneNumber;
//    private State state;
}
