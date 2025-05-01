package com.udea.drools.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class Request {
    @NotNull(message = "El pasajero es obligatorio")
    @Valid
    private Passenger passenger;

    public Request() {}

    public Request(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}