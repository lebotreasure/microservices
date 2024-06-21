package com.lebohangkhaeane.patient_service.repository;

import com.lebohangkhaeane.patient_service.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository {

    private List<Patient> patients = new ArrayList<>();

    public Patient addPatient(Patient patient) {
        patients.add(patient);
        return patient;
    }

    public Patient findById(Long id) {
        return patients.stream()
                .filter(patient ->
                        patient.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Patient> findAll() {
        return patients;
    }
}
