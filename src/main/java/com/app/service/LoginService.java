package com.app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Tomasz on 11.04.2016.
 */
@Service
public interface LoginService extends UserDetailsService{

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
