package com.udea.drools.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Flight {

    @NotNull(message = "El retraso es obligatorio")
    @Min(value = 0, message = "El retraso no puede ser negativo")
    private Integer delay;     // en minutos

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 0, message = "La duración no puede ser negativa")
    private Integer duration;  // en horas

    public Flight() {
        this.delay = 190;
        // this.delay = (int)(Math.random() * 200);
        this.duration = (int)(Math.random() * 23) + 1;
    }

    public Integer getDelay() { return delay; }
    public void setDelay(Integer delay) { this.delay = delay; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}