package com.lebohangkhaeane.patient_service.model;

import java.util.Date;

public record Appointment(Long id, Long patientId, String name, Date dob, String address) {
}
