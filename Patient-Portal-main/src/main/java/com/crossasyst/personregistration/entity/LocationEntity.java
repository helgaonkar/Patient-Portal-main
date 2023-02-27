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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
@SQLDelete(sql = "UPDATE location SET deleted = true WHERE location_id=?")
@Where(clause = "deleted=false")
public class LocationEntity {

    @Id
    @SequenceGenerator(name = "location_seq_id", sequenceName = "location_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq_id")
    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practice_id")
    private PracticeEntity practiceEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationEntity")
    private List<LocationAddressEntity> locationAddressEntity;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE; //FALSE= not deleted, TRUE= deleted
}
