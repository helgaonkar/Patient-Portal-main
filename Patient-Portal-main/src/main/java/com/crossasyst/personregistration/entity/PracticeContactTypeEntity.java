package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "practice_contact_type")
public class PracticeContactTypeEntity {

    @Id
    @SequenceGenerator(name = "practice_contact_type_seq_id", sequenceName = "practice_contact_type_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "practice_contact_type_seq_id")
    @Column(name = "practice_contact_type_id")
    private Long practiceContactTypeId;

    @Column(name = "practice_contact_type")
    private String practiceContactType;

    @OneToOne
    private PracticeEntity practiceEntity;
}
