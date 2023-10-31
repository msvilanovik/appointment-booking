package com.nativecreativa.appointment_booking.Configuration;
import com.nativecreativa.appointment_booking.Service.Member_Service;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class AuthProvider implements AuthenticationProvider {
    private final Member_Service memberService;
    private final PasswordEncoder passwordEncoder;

    public AuthProvider(Member_Service memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if(Objects.equals(username, "") || Objects.equals(password, "")){
            throw new BadCredentialsException("Not enough information!");
        }

        UserDetails user = memberService.loadUserByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("User does not exist");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}