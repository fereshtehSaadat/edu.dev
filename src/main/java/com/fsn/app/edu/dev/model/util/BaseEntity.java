package com.fsn.app.edu.dev.model.util;

import com.fsn.app.edu.dev.model.util.codes.ColumnDefinitionType;
import com.fsn.app.edu.dev.model.util.codes.FieldName;
import com.fsn.app.edu.dev.model.util.codes.SequenceName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import java.sql.Timestamp;

@RequiredArgsConstructor
@Getter
@Setter

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Entity{

    @Id
    @SequenceGenerator(name = SequenceName.BASIC_ENTITY, sequenceName = SequenceName.BASIC_ENTITY, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SequenceName.BASIC_ENTITY)
    @Column(name = FieldName.ID, columnDefinition = ColumnDefinitionType.NUMBER, nullable = false)
    private Long id;

    @CreatedBy
    @Column(name = FieldName.INSERT_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String insertUser;

    @LastModifiedBy
    @Column(name = FieldName.UPDATE_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String updateUser;

    @CreatedDate
    /*@CreationTimestamp*/
    @Column(name = FieldName.INSERT_DATE_TIME)
    private Timestamp insertDateTime;

    @LastModifiedDate
    /*@UpdateTimestamp*/
    @Column(name = FieldName.UPDATE_DATE_TIME)
    private Timestamp updateDateTime;

    @Version
    @Column(name = FieldName.VERSION)
    private Integer version;

    @AssertTrue
    @Column(name = FieldName.IS_ACTIVE, nullable = false)
    private boolean isActive = Boolean.TRUE;
}