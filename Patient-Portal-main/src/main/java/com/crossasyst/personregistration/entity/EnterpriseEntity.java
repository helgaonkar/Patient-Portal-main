package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enterprise")
@SQLDelete(sql = "UPDATE enterprise SET deleted = true WHERE enterprise_id=?")
@Where(clause = "deleted=false")
public class EnterpriseEntity {

    @Id
    @SequenceGenerator(name = "enterprise_seq_id", sequenceName = "enterprise_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprise_seq_id")
    @Column(name = "enterprise_id")
    private Long enterpriseId;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_id")
    private List<PracticeEntity> practiceEntity;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE; //FALSE= not deleted, TRUE= deleted
}
