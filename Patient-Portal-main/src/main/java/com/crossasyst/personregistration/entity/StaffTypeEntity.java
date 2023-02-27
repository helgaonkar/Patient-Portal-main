package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff_type")
public class StaffTypeEntity {

    @Id
    @SequenceGenerator(name = "staff_type_seq_id", sequenceName = "staff_type_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_type_seq_id")
    private Long staffId;

    @Column(name = "staff_type")
    private String staffType;

    @OneToOne
    private StaffEntity staffEntity;
}
