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
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_entity_seq_id", sequenceName = "user_entity_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_entity_seq_id")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_type")
    private String userType;

    @OneToOne
    private StaffEntity staffEntity;
}
