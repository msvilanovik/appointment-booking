package com.nativecreativa.appointment_booking.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private Long id ;
    private String Name_Lastname;
    private String email;
    private String phone;
    private LocalDateTime dateTime;
    @OneToOne
    private FitnessCenter fitnessCenter;


    public Appointment(String nameLastname, String email, String phone, LocalDateTime localDateTime, FitnessCenter fitnessCenter) {
        this.Name_Lastname = nameLastname;
        this.email = email;
        this.phone = phone;
        this.dateTime = localDateTime;
        this.fitnessCenter = fitnessCenter;
    }

    public Long getId() {
        return id;
    }

    public String getName_Lastname() {
        return Name_Lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

}
