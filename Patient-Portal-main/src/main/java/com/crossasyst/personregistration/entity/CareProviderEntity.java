package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "care_provider")
public class CareProviderEntity {
    @Id
    @SequenceGenerator(name = "care_provider_seq_id", sequenceName = "care_provider_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "care_provider_seq_id")
    @Column(name = "care_provider_id")
    private Long careProviderId;

    @Column(name = "primary_care_provider_name")
    private String primaryCareProviderName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "careProviderEntity")
    private List<PrimaryCareProviderInformationEntity> primaryCareProviderInformationEntity;

    @OneToOne
    private PersonAdditionalInformationEntity personAdditionalInformation;

}
