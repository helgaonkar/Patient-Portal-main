package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @SequenceGenerator(name = "address_seq_id", sequenceName = "address_seq_id", initialValue = 20000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_id")
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_line_1")
    private String address1;

    @Column(name = "address_line_2")
    private String address2;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private Long zipCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;

//    @OneToOne(fetch = FetchType.LAZY)
//    private PracticeEntity practiceEntity;


}
