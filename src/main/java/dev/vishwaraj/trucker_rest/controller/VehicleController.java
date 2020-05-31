package dev.vishwaraj.trucker_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vishwaraj.trucker_rest.entity.Vehicle;
import dev.vishwaraj.trucker_rest.service.VehicleService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PutMapping
    public List<Vehicle> vehicles(@RequestBody List<Vehicle> vehicles) {
        // TODO: process PUT request

        return vehicleService.saveVehicles(vehicles);

    }

    @PutMapping(value = "{vin}")
    public Vehicle vehicle(@PathVariable String vin, @RequestBody Vehicle vehicle) {
        // TODO: process PUT request
        return vehicleService.changeVehicleInfo(vehicle, vin);
    }

    @GetMapping(value = "{vin}")
    public Vehicle vehicle(@RequestParam String vin) {
        return vehicleService.findVehicle(vin);
    }

    @GetMapping(value = "")
    public List<Vehicle> getMethodName() {
        return vehicleService.findVehicles();
    }

}