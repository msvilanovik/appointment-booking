package com.nativecreativa.appointment_booking.Repository;

import com.nativecreativa.appointment_booking.Model.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessCenter_Repository extends JpaRepository<FitnessCenter, Long> {
}
