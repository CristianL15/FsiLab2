package com.udea.drools.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Luggage {

    @NotNull(message = "El peso es obligatorio")
    @Min(value = 0, message = "El peso no puede ser negativo")
    private Double weight;

    private double discount;
    private boolean eligibleForUpgrade = true;
    private boolean allowed = true;

    public Luggage() {}

    public Luggage(Double weight) {
        this.weight = weight;
        this.discount = 0;
        this.eligibleForUpgrade = true;
        this.allowed = true;
    }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public void setEligibleForUpgrade(boolean eligible) { this.eligibleForUpgrade = eligible; }

    public boolean isAllowed() { return allowed; }
    public void setAllowed(boolean allowed) { this.allowed = allowed; }
}