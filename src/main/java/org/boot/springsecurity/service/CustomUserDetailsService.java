package org.boot.springsecurity.service;

import org.boot.springsecurity.dto.CustomUserDetails;
import org.boot.springsecurity.entity.UserEntity;
import org.boot.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity byUsername = userRepository.findByUsername(username);

        if(byUsername != null){
            return new CustomUserDetails(byUsername);
        }

        return null;
    }
}
