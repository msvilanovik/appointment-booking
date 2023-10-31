package com.nativecreativa.appointment_booking.Service.Implementations;


import com.nativecreativa.appointment_booking.Model.Appointment;
import com.nativecreativa.appointment_booking.Model.FitnessCenter;
import com.nativecreativa.appointment_booking.Repository.Appointment_Repository;
import com.nativecreativa.appointment_booking.Service.Appointment_Service;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Appointment_Service_Impl implements Appointment_Service {
    private final Appointment_Repository appointmentRepository;

    public Appointment_Service_Impl(Appointment_Repository appointmentRepository) {this.appointmentRepository = appointmentRepository;}

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> listAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment addNew(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Long id) {appointmentRepository.deleteById(id);}

    @Override
    public Optional<Appointment> update(Long Id, LocalDateTime dateTime, FitnessCenter fitnessCenter) {
        Appointment appointment = this.findById(Id).orElseThrow();
        return Optional.of(appointmentRepository.save(appointment));
    }
}
