package com.nativecreativa.appointment_booking.Service.Implementations;
import com.nativecreativa.appointment_booking.Model.Member;
import com.nativecreativa.appointment_booking.Model.Role;
import com.nativecreativa.appointment_booking.Repository.Member_Repository;
import com.nativecreativa.appointment_booking.Service.Member_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Member_Service_Impl implements Member_Service {

    @Autowired
    private Member_Repository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return memberRepository.findByUsername(username);
    }


    @Override
    public Member register(String name, String surname, String username, String password, String role) throws IllegalArgumentException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password must not be empty");
        }

        if (memberRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        Member member =new Member(name,surname,username, passwordEncoder.encode(password),Role.valueOf(role));

        return memberRepository.save(member);
    }

    @Override
    public Member update(String name, String surname, String username, String password, String role) {
        Member member =new Member(name,surname,username, passwordEncoder.encode(password),Role.valueOf(role));
        return memberRepository.save(member);
    }

}