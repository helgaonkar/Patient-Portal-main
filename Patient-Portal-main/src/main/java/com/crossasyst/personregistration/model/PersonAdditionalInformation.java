package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonAdditionalInformation {

    private String preferredPronoun;

    private String preferredLanguage;

    private String religion;

    private Boolean isVeteran;

    private Boolean isSmoker;

}
