package com.udea.drools.model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Passenger {
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "El estado de membresía es obligatorio")
    private String status;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer age;

    @NotNull(message = "Debe indicarse si viaja con niños")
    private Boolean travelingWithChildren;

    private String seatPreference;
    private boolean upgradeToBusinessClass = false;
    private boolean eligibleForUpgrade = true;
    private boolean priorityCheckIn = false;
    private boolean vipAccess = false;
    private double compensation = 0;
    private int loyaltyPoints = 0;
    private Luggage luggage;
    private Flight flight = new Flight();
    private Seat assignedSeat = new Seat(this.seatPreference);

    public Passenger() {}

    public Passenger(String name, String status, Integer age, String seatPreference,
                     Boolean travelingWithChildren, String membership, Luggage luggage) {
        this.name = name;
        this.status = status; //Basic, Gold, platinum, Business
        this.age = age;
        this.seatPreference = seatPreference; //Window, aisle, middle
        this.travelingWithChildren = travelingWithChildren;
        this.luggage = luggage;
        this.assignedSeat = new Seat(this.seatPreference);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getSeatPreference() { return seatPreference; }
    public void setSeatPreference(String seatPreference) { this.seatPreference = seatPreference; }

    public Boolean getTravelingWithChildren() { return travelingWithChildren; }
    public void setTravelingWithChildren(Boolean travelingWithChildren) {
        this.travelingWithChildren = travelingWithChildren;
    }

    public boolean isUpgradeToBusinessClass() { return upgradeToBusinessClass; }
    public void setUpgradeToBusinessClass(boolean upgrade) { this.upgradeToBusinessClass = upgrade; }

    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public void setEligibleForUpgrade(boolean eligible) { this.eligibleForUpgrade = eligible; }

    public boolean isPriorityCheckIn() { return priorityCheckIn; }
    public void setPriorityCheckIn(boolean priority) { this.priorityCheckIn = priority; }

    public boolean isVipAccess() { return vipAccess; }
    public void setVipAccess(boolean access) { this.vipAccess = access; }

    public double getCompensation() { return compensation; }
    public void setCompensation(double compensation) { this.compensation = compensation; }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int points) { this.loyaltyPoints = points; }
    public void addLoyaltyPoints(int points) { this.loyaltyPoints += points; }

    public Seat getAssignedSeat() { return assignedSeat; }
    public void setAssignedSeat(Seat seat) { this.assignedSeat = seat; }

    public Luggage getLuggage() { return luggage; }
    public void setLuggage(Luggage luggage) { this.luggage = luggage; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    @Override
    public String toString() {
        return super.toString();
    }
}