package com.pseudowasabi.spring_data_access_examples.repository.jpa;

import com.pseudowasabi.spring_data_access_examples.model.jpa.Manufacturer;
import com.pseudowasabi.spring_data_access_examples.model.jpa.ManufacturerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, ManufacturerId> {
}
