package com.udea.drools.model;

public class Response {

    private Passenger passenger;
    private String message;

    public Response() {}

    public Response(Passenger passenger, String message) {
        this.passenger = passenger;
        this.message = message;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}