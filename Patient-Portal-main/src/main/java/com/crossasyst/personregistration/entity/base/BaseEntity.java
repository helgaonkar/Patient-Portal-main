package com.crossasyst.personregistration.entity.base;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "base_entity")
public class BaseEntity {

    @Id
    @Column(name = "base_entity_id")
    private Long baseId;

    @CreationTimestamp
    @Column(name = "created_ts", updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime createdTs;
    @Digits(integer = 19, fraction = 0)
    @NotNull
    @Column(name = "created_by", nullable = false, precision = 19)
    private Long createdBy;
    @UpdateTimestamp
    @Column(name = "updated_ts", insertable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime updatedTs;
    @Digits(integer = 19, fraction = 0)
    @Column(name = "updated_by", precision = 19)
    @NotNull
    private Long updatedBy;
}
