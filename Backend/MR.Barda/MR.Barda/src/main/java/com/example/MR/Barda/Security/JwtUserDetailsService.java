package com.example.MR.Barda.Security;
import com.example.MR.Barda.Models.User;
import com.example.MR.Barda.Repo.IUserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Clase S4
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findOneByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("Username not found: " + email);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
    }
}
