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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "state")
public class StateEntity {
    @Id
    @SequenceGenerator(name = "state_seq_id", sequenceName = "state_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq_id")
    @Column(name = "state_Id")
    private Long stateId;

    @Column(name = "state_abbreviation")
    private String stateAbbreviation;

    @Column(name = "state_name")
    private String stateName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateEntity")
    private List<CityEntity> cityEntityList;
}
