package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "practice_contact")
public class PracticeContactEntity {

    @Id
    @SequenceGenerator(name = "practice_contact_seq_id", sequenceName = "practice_contact_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "practice_contact_seq_id")
    @Column(name = "practice_contact_id")
    private Long practiceContactId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "alternate_phone_number")
    private String alternatePhoneNumber;

    @Column(name = "contact_person")
    private String contactPerson;

   /* @ManyToOne(fetch = FetchType.LAZY)
    private PracticeEntity practiceEntity;*/
}
