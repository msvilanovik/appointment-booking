package com.nativecreativa.appointment_booking.Repository;

import com.nativecreativa.appointment_booking.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Appointment_Repository extends JpaRepository<Appointment, Long> {



}
