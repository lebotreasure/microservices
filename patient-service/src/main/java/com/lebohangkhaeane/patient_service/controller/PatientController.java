package com.lebohangkhaeane.patient_service.controller;

import com.lebohangkhaeane.patient_service.client.AppointmentClient;
import com.lebohangkhaeane.patient_service.model.Patient;
import com.lebohangkhaeane.patient_service.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientRepository repository;

    @Autowired
    private AppointmentClient appointmentClient;

    @PostMapping
    public Patient add(@RequestBody Patient patient) {
        LOGGER.info("Patient add: {}", patient);
        return repository.addPatient(patient);
    }

    @GetMapping
    public List<Patient> findAll() {
        LOGGER.info("Patient find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable Long id) {
        LOGGER.info("Patient find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/with-appointments")
    public List<Patient> findAllWithAppointments() {
        LOGGER.info("Patient find");
        List<Patient> patients
                = repository.findAll();

        patients.forEach(patient ->
                patient.setAppointment(
                        appointmentClient.findByPatient(
                                patient.getId())));
        return patients;
    }
}
