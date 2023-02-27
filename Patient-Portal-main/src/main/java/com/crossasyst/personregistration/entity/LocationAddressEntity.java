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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location_address")
public class LocationAddressEntity {
    @Id
    @SequenceGenerator(name = "location_address_seq_id", sequenceName = "location_address_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_address_seq_id")
    @Column(name = "location_address_id", nullable = false)
    private Long locationAddressId;

    @Column(name = "address_line_1")
    private String addressLineOne;

    @Column(name = "address_line_2")
    private String addressLineTwo;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    private LocationEntity locationEntity;
}
