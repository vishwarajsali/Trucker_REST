package dev.vishwaraj.trucker_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.vishwaraj.trucker_rest.entity.Vehicle;
import dev.vishwaraj.trucker_rest.repository.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {

        vehicles.forEach(vehicle -> {
            changeVehicleInfo(vehicle);
        });

        return vehicles;
    }

    public Vehicle changeVehicleInfo(Vehicle vehicle, String vin) {

        Vehicle v = vehicleRepository.findByVin(vin);
        if (v == null)
            return vehicleRepository.save(vehicle);
        if (v.getMake() != vehicle.getMake())
            v.setMake(vehicle.getMake());
        if (v.getModel() != vehicle.getModel())
            v.setModel(vehicle.getModel());
        if (v.getYear() != vehicle.getYear())
            v.setYear(vehicle.getYear());
        if (v.getLastServiceDate() != vehicle.getLastServiceDate())
            v.setLastServiceDate(vehicle.getLastServiceDate());
        if (v.getRedlineRpm() != vehicle.getRedlineRpm())
            v.setRedlineRpm(vehicle.getRedlineRpm());

        return vehicleRepository.save(v);

    }

    public Vehicle changeVehicleInfo(Vehicle vehicle) {

        Vehicle v = vehicleRepository.findByVin(vehicle.getVin());
        if (v == null)
            {
                return vehicleRepository.save(vehicle);
                
            }
        if (v.getMake() != vehicle.getMake())
            v.setMake(vehicle.getMake());
        if (v.getModel() != vehicle.getModel())
            v.setModel(vehicle.getModel());
        if (v.getYear() != vehicle.getYear())
            v.setYear(vehicle.getYear());
        if (v.getLastServiceDate() != vehicle.getLastServiceDate())
            v.setLastServiceDate(vehicle.getLastServiceDate());
        if (v.getRedlineRpm() != vehicle.getRedlineRpm())
            v.setRedlineRpm(vehicle.getRedlineRpm());

        return vehicleRepository.save(v);

    }

    public Vehicle findVehicle(String vin){
        return vehicleRepository.findByVin(vin);
    }

    public List<Vehicle> findVehicles(){
        return vehicleRepository.findAll();
    }
}