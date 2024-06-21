package com.lebohangkhaeane.patient_service.model;

public record Appointment(Long id, Long patientId, String name, int age, String address) {
}
