package com.lebohangkhaeane.appointment_service.controller;

import com.lebohangkhaeane.appointment_service.model.Appointment;
import com.lebohangkhaeane.appointment_service.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    AppointmentRepository repository;

    @PostMapping
    public Appointment add(@RequestBody Appointment appointment) {
        LOGGER.info("Appointment added: {}", appointment);
        return repository.add(appointment);
    }

    @GetMapping
    public List<Appointment> findAll() {
        LOGGER.info("Appointment find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Appointment findById(@PathVariable("id") Long id) {
        LOGGER.info("Appointment find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> findByPatient(@PathVariable("patientId") Long patientId) {
        LOGGER.info("Appointment find: patientId={}", patientId);
        return repository.findByPatient(patientId);
    }
}
