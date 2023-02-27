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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class StaffEntity {

    @Id
    @SequenceGenerator(name = "staff_seq_id", sequenceName = "staff_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq_id")
    @Column(name = "staff_id")
    private Long staff_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_no")
    private String phoneNo;

    @OneToOne(mappedBy = "staffEntity")
    private StaffTypeEntity staffTypeEntity;

    @OneToOne(mappedBy = "staffEntity")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practiceEntity")
    private List<PracticeStaffEntity> practiceStaffEntities;
}
