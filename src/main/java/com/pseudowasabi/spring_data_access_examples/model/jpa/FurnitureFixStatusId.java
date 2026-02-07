package com.pseudowasabi.spring_data_access_examples.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureFixStatusId implements Serializable {
    private String requestId;
}
