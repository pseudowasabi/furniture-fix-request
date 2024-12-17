package com.ringoxcoffee.furniture_fix_request.repository.jpa;

import com.ringoxcoffee.furniture_fix_request.model.jpa.Furniture;
import com.ringoxcoffee.furniture_fix_request.model.jpa.FurnitureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, FurnitureId> {
}
