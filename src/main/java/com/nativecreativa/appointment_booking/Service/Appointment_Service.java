package com.nativecreativa.appointment_booking.Service;

import com.nativecreativa.appointment_booking.Model.Appointment;
import com.nativecreativa.appointment_booking.Model.FitnessCenter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Appointment_Service {

    Optional <Appointment> findById(Long id);
    List<Appointment> listAll();
    Appointment addNew(Appointment appointment);
    void delete(Long id);
    Optional <Appointment> update(Long Id,LocalDateTime dateTime, FitnessCenter fitnessCenter);


}
