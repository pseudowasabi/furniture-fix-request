package com.ringoxcoffee.furniture_fix_request.model.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@IdClass(FurnitureFixStatusId.class)
public class FurnitureFixStatus {

    @Id
    private String requestId;

    private String email;
    private String name;

    private String furnitureType;
    private String manufacturer;
    private String requestDetails;

    private String status;
    private String adminMessage;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
