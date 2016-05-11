package com.app.service.impl;

import com.app.domain.Client;
import com.app.domain.repository.ClientRepository;
import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 11.04.2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ClientRepository clientRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            Client client = clientRepository.getClientByUsername(s);
            if (client != null) {
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                return new User(client.getUsername(), client.getPassword(), authorities);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException("User not found: " + s);
    }
}