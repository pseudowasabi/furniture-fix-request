package com.ringoxcoffee.furniture_fix_request.repository.jpa;

import com.ringoxcoffee.furniture_fix_request.model.jpa.Manufacturer;
import com.ringoxcoffee.furniture_fix_request.model.jpa.ManufacturerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, ManufacturerId> {
}
