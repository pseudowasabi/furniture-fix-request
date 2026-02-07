package com.pseudowasabi.spring_data_access_examples.repository.jpa;

import com.pseudowasabi.spring_data_access_examples.model.jpa.Furniture;
import com.pseudowasabi.spring_data_access_examples.model.jpa.FurnitureId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, FurnitureId> {
}
