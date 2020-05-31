package dev.vishwaraj.trucker_rest.service;

import java.sql.Timestamp; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.vishwaraj.trucker_rest.entity.Alert;
import dev.vishwaraj.trucker_rest.entity.Reading;
import dev.vishwaraj.trucker_rest.entity.Vehicle;
import dev.vishwaraj.trucker_rest.repository.AlertRepository;

@Service
public class AlertService {
    
    @Autowired
    private AlertRepository alertRepository;

 

    public List<Alert> getAllHighAlert(){
        //Timestamp i =  Timestamp.from(Instant.now().minus(Duration.ofHours(2)));
        //Instant i = Instant.now().minus(Duration.ofHours(2));
        //System.out.println(Timestamp.from(Instant.now().minus(Duration.ofHours(2))));
        return alertRepository.getHighAlerts("HIGH", new Timestamp(System.currentTimeMillis() - (60 * 60 * 1000)));
        //return null;
    }

    public List<Alert> getAlerts(String vin){
        return alertRepository.findByVin(vin);
    }
    

    public void saveAlert(Alert alert){
        alertRepository.save(alert);
    }

    private void sendMail(String body){
        System.out.println("Email Sent with with body: "+ body);
    }


    private void sendText(String body){
        System.out.println("Text Sent with with body: "+ body);

    }



    public void checkRules(Reading reading, Vehicle vehicle){
        String rule = "";
        if(reading.getEngineRpm() > vehicle.getRedlineRpm()){
            rule = "Vehicle Engine RPM is : "+reading.getEngineRpm()+" greater than Readline RPM of : "+vehicle.getRedlineRpm();
            sendMail(rule);
            sendText(rule);
            saveAlert(new Alert("",vehicle.getVin(),rule,"HIGH", null));
        }
        if(reading.getFuelVolume() < (0.10 * vehicle.getMaxFuelVolume())){
            rule = "Vehicle Fuel volume is : "+reading.getFuelVolume()+" less than 10% of the maximum fuel volume of : "+vehicle.getMaxFuelVolume();
            saveAlert(new Alert("",vehicle.getVin(),rule,"MEDIUM", null));
        }
        if(reading.getTires().getFrontLeft() > 36 || reading.getTires().getFrontLeft() < 32){
            rule = "Front Left tire pressure is : "+reading.getTires().getFrontLeft()+"psi";
            saveAlert(new Alert("",vehicle.getVin(),rule,"LOW", null));
        }
        if(reading.getTires().getRearLeft() > 36 || reading.getTires().getRearLeft()< 32){
            rule = "Rear Left tire pressure is : "+reading.getTires().getRearLeft()+"psi";
            saveAlert(new Alert("",vehicle.getVin(),rule,"LOW",null));
        }
        if(reading.getTires().getFrontRight() > 36 || reading.getTires().getFrontRight() < 32){
            rule = "Front Right tire pressure is : "+reading.getTires().getFrontRight()+"psi";
            saveAlert(new Alert("",vehicle.getVin(),rule,"LOW",null));
        }
        if(reading.getTires().getRearRight() > 36 || reading.getTires().getRearRight()< 32){
            rule = "Rear Right tire pressure is : "+reading.getTires().getRearRight()+"psi";
            saveAlert(new Alert("",vehicle.getVin(),rule,"LOW",null));
        }
        if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()){
            if(reading.isEngineCoolantLow()){
                rule = "Engine Coolant is Low";
                saveAlert(new Alert("",vehicle.getVin(),rule,"LOW", null));
            }
            if(reading.isCheckEngineLightOn()){
                rule = "Engine Light is On";
                saveAlert(new Alert("",vehicle.getVin(),rule,"LOW", null));
            }
        }
    }
}