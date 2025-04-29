package com.udea.drools.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Request {
    @NotNull(message = "El pasajero es obligatorio")
    @Valid
    private Passenger passenger;

    @NotNull(message = "El tipo de asiento es obligatorio")
    @NotBlank(message = "El tipo de asiento es obligatorio")
    private Seat seat;

    @NotNull(message = "El equipaje es obligatorio")
    @NotBlank(message = "El equipaje es obligatorio")
    private Luggage luggage;


    public Request() {}

    public Request(Passenger passenger, Seat seat, Luggage luggage) {
        this.passenger = passenger;
        this.seat = seat;
        this.luggage = luggage;

    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Seat getAssignedSeat() {
        return passenger.getAssignedSeat();
    }

    public void setAssignedSeat(Seat assignedSeat) {
        passenger.setAssignedSeat(assignedSeat);
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }
}