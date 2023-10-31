package com.nativecreativa.appointment_booking.Configuration;

import com.nativecreativa.appointment_booking.Model.Appointment;
import com.nativecreativa.appointment_booking.Model.FitnessCenter;
import com.nativecreativa.appointment_booking.Service.Appointment_Service;
import com.nativecreativa.appointment_booking.Service.FitnessCenter_Service;
import com.nativecreativa.appointment_booking.Service.Member_Service;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class Data_Creation {
    private final FitnessCenter_Service fitnessCenterService;
    private final Member_Service memberService;
    private final Appointment_Service appointmentService;

    public Data_Creation(FitnessCenter_Service fitnessCenterService, Member_Service memberService, Appointment_Service appointmentService) {
        this.fitnessCenterService = fitnessCenterService;
        this.memberService = memberService;
        this.appointmentService = appointmentService;
    }
    @PostConstruct
    public void DataCreation(){
        this.fitnessCenterService.addNew(new FitnessCenter(1L,"Magnus","Centar za borecki sportovi","Skopje","Misko Mihajlovski","075222358"));
        this.fitnessCenterService.addNew(new FitnessCenter("Atleta","Atleta Aerodrom","Skopje","Ruger Boskovic","075222358"));
        this.memberService.register("Martin","Fidanovski","martin","200200200Ss#","ROLE_ADMIN");
        this.memberService.register("Martin","Fidanovski","martin_member","200200200Ss#","ROLE_USER");
        LocalDateTime localDateTime = LocalDateTime.now();
        this.appointmentService.addNew(new Appointment("Martin Fidanovski","fidanovski.martin@gmail.com", "075222358",localDateTime,fitnessCenterService.findById(1L)));
        this.appointmentService.addNew(new Appointment("Goran Josifovski","goran.josifovski@gmail.com", "075222358",localDateTime,fitnessCenterService.findById(1L)));



    }

}
