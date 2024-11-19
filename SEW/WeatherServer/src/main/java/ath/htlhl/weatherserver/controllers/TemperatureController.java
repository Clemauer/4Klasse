package ath.htlhl.weatherserver.controllers;

import ath.htlhl.weatherserver.models.Temperature;
import ath.htlhl.weatherserver.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/weatherserver/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureRepository temperatureRepository;



    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Temperature addTemperature(@RequestBody Temperature temperature) throws SQLException{
        temperatureRepository.insert(temperature);
        return temperature;
    }
}
