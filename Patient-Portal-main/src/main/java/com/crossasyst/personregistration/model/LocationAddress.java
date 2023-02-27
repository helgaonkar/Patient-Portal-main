package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationAddress {
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private Long zipCode;
    private String state;
    private String country;

    private Location location;
}
