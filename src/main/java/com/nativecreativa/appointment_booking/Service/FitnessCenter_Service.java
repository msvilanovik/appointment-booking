package com.nativecreativa.appointment_booking.Service;

import com.nativecreativa.appointment_booking.Model.FitnessCenter;

import java.util.List;
import java.util.Optional;

public interface FitnessCenter_Service {
    FitnessCenter findById(Long id);
    List<FitnessCenter> listAll();
    FitnessCenter addNew(FitnessCenter fitnessCenter);
    void delete(Long id);
    FitnessCenter update(Long id,String name, String description, String location, String address, String telephone);
}
