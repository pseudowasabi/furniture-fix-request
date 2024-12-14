package com.ringoxcoffee.furniture_fix_request.repository;

import com.ringoxcoffee.furniture_fix_request.model.FurnitureFixStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureFixStatusRepository extends JpaRepository<FurnitureFixStatus, Long> {
}
