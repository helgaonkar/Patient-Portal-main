package com.crossasyst.personregistration.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String address1;
    private String address2;
    private String addressType;
    private String country;
    private String state;
    private String city;
    private Long zipCode;
}
