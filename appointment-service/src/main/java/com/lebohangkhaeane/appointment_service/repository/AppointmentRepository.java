package com.lebohangkhaeane.appointment_service.repository;

import com.lebohangkhaeane.appointment_service.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepository {

    private List<Appointment> appointments
            = new ArrayList<>();

    public Appointment add(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    public Appointment findById(Long id) {
        return appointments.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Appointment> findAll() {
        return appointments;
    }

    public List<Appointment> findByPatient(Long patientId) {
        return appointments.stream()
                .filter(a -> a.patientId().equals(patientId))
                .toList();
    }
}
