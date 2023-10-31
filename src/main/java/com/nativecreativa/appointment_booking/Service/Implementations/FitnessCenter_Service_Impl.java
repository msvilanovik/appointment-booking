package com.nativecreativa.appointment_booking.Service.Implementations;
import com.nativecreativa.appointment_booking.Model.FitnessCenter;
import com.nativecreativa.appointment_booking.Repository.FitnessCenter_Repository;
import com.nativecreativa.appointment_booking.Service.FitnessCenter_Service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FitnessCenter_Service_Impl implements FitnessCenter_Service {
    private final FitnessCenter_Repository fitnessCenterRepository;

    public FitnessCenter_Service_Impl(FitnessCenter_Repository fitnessCenterRepository) {
        this.fitnessCenterRepository = fitnessCenterRepository;
    }

    @Override
    public FitnessCenter findById(Long id) {return fitnessCenterRepository.findById(id).orElseThrow();}

    @Override
    public List<FitnessCenter> listAll() {return fitnessCenterRepository.findAll();}

    @Override
    public FitnessCenter addNew(FitnessCenter fitnessCenter) {
        return fitnessCenterRepository.save(fitnessCenter);
    }

    @Override
    public void delete(Long id) {fitnessCenterRepository.deleteById(id);}

    @Override
    public FitnessCenter update(Long id,String name, String description, String location, String address, String telephone) {
        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findById(id).orElseThrow();
        fitnessCenter.setName(name);
        fitnessCenter.setAddress(address);
        fitnessCenter.setDescription(description);
        fitnessCenter.setLocation(location);
        fitnessCenter.setTelephone(telephone);
        return fitnessCenter;
    }
}
