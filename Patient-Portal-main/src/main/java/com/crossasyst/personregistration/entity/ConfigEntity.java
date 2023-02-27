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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "config_entity")
public class ConfigEntity {
    @Id
    @SequenceGenerator(name = "config_entity_seq_id", sequenceName = "config_entity_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "config_entity_seq_id")
    @Column(name = "config_id")
    private Long configId;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "abbreviation_description")
    private String abbreviationDescription;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private GroupEntity groupEntity;
}
