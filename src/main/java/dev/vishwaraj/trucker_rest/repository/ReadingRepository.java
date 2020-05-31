package dev.vishwaraj.trucker_rest.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import dev.vishwaraj.trucker_rest.entity.Reading;

public interface ReadingRepository extends JpaRepository<Reading, String> {

    @Query(value = "select * From reading r WHERE r.vin = ?1 AND r.created_at >= ?2", nativeQuery = true)
    List<Reading> findByVinAndAndCreatedAt(@Param("vin")String vin,@Param("created_at")Timestamp timestamp);
}   