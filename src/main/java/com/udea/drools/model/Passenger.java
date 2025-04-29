package com.udea.drools.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Passenger {

    @NotBlank(message = "El estado de membresía es obligatorio")
    private String status;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer age;

    private String seatPreference;

    @NotNull(message = "Debe indicarse si viaja con niños")
    private Boolean travelingWithChildren;

    @NotBlank(message = "El nivel de membresía es obligatorio")
    private String membership;

    private boolean upgradeToBusinessClass;
    private boolean priorityCheckIn;
    private boolean vipLoungeAccess;
    private double compensation;
    private int loyaltyPoints;
    private Seat assignedSeat;

    public Passenger() {}

    public Passenger(String status, Integer age, String seatPreference,
                     Boolean travelingWithChildren, String membership) {
        this.status = status;
        this.age = age;
        this.seatPreference = seatPreference;
        this.travelingWithChildren = travelingWithChildren;
        this.membership = membership;
        this.upgradeToBusinessClass = false;
        this.priorityCheckIn = false;
        this.vipLoungeAccess = false;
        this.compensation = 0;
        this.loyaltyPoints = 0;
    }

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

    public String getMembership() { return membership; }
    public void setMembership(String membership) { this.membership = membership; }

    public boolean isUpgradeToBusinessClass() { return upgradeToBusinessClass; }
    public void setUpgradeToBusinessClass(boolean upgrade) { this.upgradeToBusinessClass = upgrade; }

    public boolean isPriorityCheckIn() { return priorityCheckIn; }
    public void setPriorityCheckIn(boolean priority) { this.priorityCheckIn = priority; }

    public boolean isVipLoungeAccess() { return vipLoungeAccess; }
    public void setVipLoungeAccess(boolean access) { this.vipLoungeAccess = access; }

    public double getCompensation() { return compensation; }
    public void setCompensation(double compensation) { this.compensation = compensation; }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int points) { this.loyaltyPoints = points; }
    public void addLoyaltyPoints(int points) { this.loyaltyPoints += points; }

    public Seat getAssignedSeat() { return assignedSeat; }
    public void setAssignedSeat(Seat seat) { this.assignedSeat = seat; }
}