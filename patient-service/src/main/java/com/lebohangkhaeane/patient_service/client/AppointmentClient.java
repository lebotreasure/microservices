package com.lebohangkhaeane.patient_service.client;

import com.lebohangkhaeane.patient_service.model.Appointment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface AppointmentClient {

    @GetExchange("/appointment/patient/{patientId}")
    public List<Appointment> findByPatient(@PathVariable("patientId") Long patientId);
}