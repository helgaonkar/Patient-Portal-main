package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareProvider {

    private String primaryCareProviderName;

    private List<PrimaryCareProviderInformation> primaryCareProviderInformation;
}
