package dev.vishwaraj.trucker_rest.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.vishwaraj.trucker_rest.entity.Geolocation;
import dev.vishwaraj.trucker_rest.entity.Reading;
import dev.vishwaraj.trucker_rest.entity.Vehicle;
import dev.vishwaraj.trucker_rest.exception.NoVehicleFoundException;
import dev.vishwaraj.trucker_rest.repository.ReadingRepository; 

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired 
    private VehicleService vehicleService;

    @Autowired
    private AlertService alertService;


    public Reading saveReading(Reading reading){

        Vehicle exist = vehicleService.findVehicle(reading.getVin());

        if(exist == null){
            throw new NoVehicleFoundException();
        }
        alertService.checkRules(reading, exist);
        return readingRepository.save(reading);
    }

    public List<Reading> saveReading(List<Reading> readings){
        return readingRepository.saveAll(readings);
    }

    public List<Reading> getAllReadings(){
        return readingRepository.findAll();
    }


    public List<Geolocation> geolocations(String vin){
        List<Geolocation> locations = new ArrayList<>();
        List<Reading> readings = readingRepository.findByVinAndAndCreatedAt(vin, Timestamp.from(Instant.now().minus(Duration.ofHours(1))));
        readings.forEach(reading -> {
            locations.add(new Geolocation(reading.getLatitude(), reading.getLongitute()));
        });;
        return locations;
    }
    
}