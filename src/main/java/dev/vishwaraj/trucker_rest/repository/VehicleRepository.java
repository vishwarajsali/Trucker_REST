package dev.vishwaraj.trucker_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.vishwaraj.trucker_rest.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{
    Vehicle findByVin(String vin);

    
}