package org.example.model;

import java.time.LocalDate;

public record AdoptionRecord(Animal animal, LocalDate adoptionDate, String adopterName) {

    @Override
    public String toString() {
        return animal.getName() + " adopted by " + adopterName + " on " + adoptionDate;
    }
}