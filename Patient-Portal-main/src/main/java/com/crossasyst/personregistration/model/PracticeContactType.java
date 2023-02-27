package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticeContactType {

    private String practiceContactType;

    private Practice practice;
}
