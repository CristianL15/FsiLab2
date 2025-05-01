package com.udea.drools.model;

import jakarta.validation.constraints.NotNull;

public class Seat {

    @NotNull(message = "El tipo de asiento es obligatorio")
    private String type;

    @NotNull(message = "Disponibilidad es obligatoria")
    private Boolean available;

    public Seat() {}

    public Seat(String type) {
        this.type = type;
        this.available = true;
    }

    public Seat(String type, Boolean available) {
        this.type = type;
        this.available = available;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
