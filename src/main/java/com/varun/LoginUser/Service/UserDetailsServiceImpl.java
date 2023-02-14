package com.varun.LoginUser.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.varun.LoginUser.Entity.UserEntity;
import com.varun.LoginUser.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

@Autowired
private UserRepository userRepository;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
UserEntity user = userRepository.findByUsername(username);
if (user == null) {
throw new UsernameNotFoundException("User not found with username: " + username);
}
return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
new ArrayList<>());
}
}
