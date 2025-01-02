package com.ringoxcoffee.furniture_fix_request.repository.jdbc;

import com.ringoxcoffee.furniture_fix_request.model.jdbc.FurnitureFixStatusJdbcTable;
import com.ringoxcoffee.furniture_fix_request.model.jdbc.FurnitureFixStatusSelectResult;
import com.ringoxcoffee.furniture_fix_request.model.jpa.FurnitureFixStatus;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FurnitureFixStatusJdbcRepository extends CrudRepository<FurnitureFixStatusJdbcTable, Long> {

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
            """)
    List<FurnitureFixStatusSelectResult> getFixStatusOfSpecificManufacturer(
            @Param("manufacturer") String manufacturer
    );

    @Query(value = """
            select * from furniture_fix_status
            where manufacturer = :manufacturer
            """)
    List<FurnitureFixStatus> findByManufacturer(
            @Param("manufacturer") String manufacturer
    );

    @Modifying
    @Query(value = """
            update furniture_fix_status
            set status = :status
            where request_id = :original_request_id
            """)
    int updateStatus(
            @Param("original_request_id") String originalRequestId,
            @Param("status") String status
    );
}
