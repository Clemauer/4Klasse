package ath.htlhl.weatherserver.repository;

import ath.htlhl.weatherserver.models.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Repository
public class TemperatureRepository {

    // Constants **************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureRepository.class);
    private static final String INSERT_TEMPERATURE_SQL = "INSERT INTO temperature (measuretime, temp) VALUES (?, ?)";
    private JdbcTemplate jdbcTemplate;

    private final static String SELECT_LATEST_TEMP_SQL = """
            SELECT measuretime, temp
            FROM temperature
            ORDER BY measuretime DESC
            LIMIT 1
            """;

    // Fields *****************************************************************

    @Autowired
    protected void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Temperature insert(Temperature temperature) throws SQLException {
        if (temperature.getMeasureTime() == null) {
            temperature.setMeasureTime(java.time.LocalDateTime.now());
            LOGGER.info("Set measure time to now");
        }
        Connection connection = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_TEMPERATURE_SQL);
        ps.setTimestamp(1, Timestamp.valueOf(temperature.getMeasureTime()));
        ps.setFloat(2, temperature.getTemperature());
        ps.executeUpdate();
        connection.close();
        return temperature;
    }

        public Temperature findLatestTemperature() throws SQLException {
            ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement().executeQuery(SELECT_LATEST_TEMP_SQL);
            if(rs.next()){
                Temperature temperature = new Temperature();
                temperature.setMeasureTime(
                        rs.getTimestamp("measuretime").toLocalDateTime());
                temperature.setTemperature(rs.getFloat("temp"));
                return temperature;
            } else {
                throw new SQLException("Could not find latest temperature");
            }
    }
}