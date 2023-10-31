package com.nativecreativa.appointment_booking.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class FitnessCenter {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String description;
    private String location;
    private String address;
    private String telephone;
    @OneToMany
    private final List<Appointment> appointmentList = new ArrayList<>();

    public FitnessCenter(String name, String description, String location, String address, String telephone) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.address = address;
        this.telephone = telephone;
    }
    public FitnessCenter(Long id,String name, String description, String location, String address, String telephone) {
        this.Id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.address = address;
        this.telephone = telephone;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
