package com.ringoxcoffee.furniture_fix_request.repository;

import com.ringoxcoffee.furniture_fix_request.model.Furniture;
import com.ringoxcoffee.furniture_fix_request.model.FurnitureId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, FurnitureId> {
}
