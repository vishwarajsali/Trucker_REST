package dev.vishwaraj.trucker_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vishwaraj.trucker_rest.entity.Alert;
import dev.vishwaraj.trucker_rest.service.AlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/alerts")
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> getHighAlerts() {
        return alertService.getAllHighAlert();
    }

    @GetMapping(value = "{vin}")
    public List<Alert> getAlerts(@PathVariable String vin) {
        return alertService.getAlerts(vin);
    }
    
}