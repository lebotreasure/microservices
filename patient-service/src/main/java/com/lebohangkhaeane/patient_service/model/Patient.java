package com.lebohangkhaeane.patient_service.model;

import jdk.jfr.DataAmount;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private Long id;
    private String name;
    private List<Appointment> appointment = new ArrayList<>();

    public Patient() {
    }

    public Patient(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
}
