package ath.htlhl.weatherserver.repository;

import ath.htlhl.weatherserver.models.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TemperatureRepository {

    // Constants **************************************************************

    private final static String INSERT_TEMPERATURE =
            "INSERT INTO temperature (temperature, measure_time) VALUES (?, ?)";


    // Fields *****************************************************************

    private JdbcTemplate jdbcTemplate;

    @Autowired
    protected void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Database CRUD operations (CRUD = Create, Read, Update, Delete) *********

    public Temperature insert(Temperature temperature) {
        jdbcTemplate.update(INSERT_TEMPERATURE, temperature.getTemperature(), temperature.getMeasureTime());
        return temperature;
    }


}
