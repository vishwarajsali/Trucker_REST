package dev.vishwaraj.trucker_rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.vishwaraj.trucker_rest.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, String>{
    List<Alert> findByVin(String vin);

    
    @Query(value = "select * From Alert a WHERE a.priority = ?1 AND a.created_at >= ?2", nativeQuery = true)
    List<Alert> getHighAlerts(@Param("priority")String priority,@Param("created_at")Timestamp timestamp);

}   