package com.ringoxcoffee.furniture_fix_request.repository;

import com.ringoxcoffee.furniture_fix_request.model.Manufacturer;
import com.ringoxcoffee.furniture_fix_request.model.ManufacturerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, ManufacturerId> {
}
