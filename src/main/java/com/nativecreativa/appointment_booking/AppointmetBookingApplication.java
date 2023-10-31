package com.nativecreativa.appointment_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan("com.nativecreativa.appointment_booking.*")
public class AppointmetBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmetBookingApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder(10);}

}
