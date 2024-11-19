package ath.htlhl.weatherserver.models;

import java.time.LocalDateTime;

public class Temperature {
    private float temperature;
    private LocalDateTime measureTime;

    public Temperature(float temperature, LocalDateTime measureTime) {
        this.temperature = temperature;
        this.measureTime = measureTime;
    }

    public Temperature(){

    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(LocalDateTime measureTime) {
        this.measureTime = measureTime;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "temperature=" + temperature +
                ", measureTime=" + measureTime +
                '}';
    }
}
