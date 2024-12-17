package com.ringoxcoffee.furniture_fix_request.repository.jpa;

import com.ringoxcoffee.furniture_fix_request.model.jpa.FurnitureFixStatus;
import com.ringoxcoffee.furniture_fix_request.model.jpa.FurnitureFixStatusId;
import com.ringoxcoffee.furniture_fix_request.model.jpa.FurnitureFixStatusProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureFixStatusRepository extends JpaRepository<FurnitureFixStatus, FurnitureFixStatusId> {

    @Query(value = """
            select
            a.request_id, a.email, a.name, a.furniture_type, a.manufacturer,
            a.request_details, a.status, a.admin_message,
            b.stock, b.support_period,
            c.hq_location, c.service_center_contact
            from furniture_fix_status a
            left join furniture b
              on a.furniture_type = b.furniture_type
              and a.manufacturer = b.manufacturer
            left join manufacturer c
              on a.manufacturer = c.manufacturer
            where a.manufacturer = :manufacturer
            """, nativeQuery = true)
    List<FurnitureFixStatusProjection> getFixStatusOfSpecificManufacturer(
            @Param("manufacturer") String manufacturer
    );

    List<FurnitureFixStatus> findByManufacturer(String manufacturer);

    @Modifying
    @Query(value = """
            update furniture_fix_status
            set status = :status
            where request_id = :original_request_id
            """, nativeQuery = true)
    int updateStatus(
            @Param("original_request_id") String originalRequestId,
            @Param("status") String status
    );
}
