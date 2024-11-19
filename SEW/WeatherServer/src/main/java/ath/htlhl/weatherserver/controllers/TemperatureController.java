package ath.htlhl.weatherserver.controllers;

import ath.htlhl.weatherserver.models.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/weatherserver/temperature")
public class TemperatureController {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Temperature addTemperature(Temperature temperature){
        if (temperature.getMeasureTime() == null){
            temperature.setMeasureTime(LocalDateTime.now());
        }
        System.out.println("Add Temperature: " + temperature);
        return temperature;
    }
}
