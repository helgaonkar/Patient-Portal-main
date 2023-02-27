package com.crossasyst.personregistration.entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email_communication_desc")
public class EmailCommunicationDescEntity {

    @Id
    @SequenceGenerator(name = "email_communication_desc_city_seq_id", sequenceName = "email_communication_desc_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_communication_desc_seq_id")
    private Long emailCommunicationId;

    private String emailType;

    private String emailContent;
}
