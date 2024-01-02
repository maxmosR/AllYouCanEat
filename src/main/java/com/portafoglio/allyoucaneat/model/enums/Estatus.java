package com.portafoglio.allyoucaneat.model.enums;

import lombok.Getter;

@Getter

public enum Estatus {
    CREATED("Created"),
    PENDING("Pending"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private final String displayValue;

    Estatus(String displayValue) {
        this.displayValue = displayValue;
    }
}
