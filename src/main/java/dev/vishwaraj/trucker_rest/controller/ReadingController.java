package dev.vishwaraj.trucker_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vishwaraj.trucker_rest.entity.Geolocation;
import dev.vishwaraj.trucker_rest.entity.Reading;
import dev.vishwaraj.trucker_rest.service.ReadingService;
 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/readings")
public class ReadingController {
    
    @Autowired
    private ReadingService readingService;

    @PostMapping(value="")
    public Reading saveReading(@RequestBody Reading reading) {
        //TODO: process POST request
        
        return readingService.saveReading(reading);
    }

    @PostMapping(value="/readings")
    public List<Reading> saveReading(@RequestBody List<Reading> readings) {
        //TODO: process POST request
        
        return readingService.saveReading(readings);
    }


    @GetMapping(value="")
    public List<Reading> getMethodName() {
        return readingService.getAllReadings();
    }
    

    @GetMapping(value="/geolocation/{vin}")
    public List<Geolocation> geolocations(@PathVariable String vin) {
        return readingService.geolocations(vin);
    }
    


    
    
}