package com.example.service;

import com.example.mapper.AccoutMapper;
import com.example.pojo.Accout;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Resource
    AccoutMapper accoutMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accout accout = accoutMapper.GetUserByName(username);
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
        if(accout == null){
             throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return User
                .withUsername(accout.getUserName())
                .password(accout.getPassword())
                .roles("Admin")
                .build();
    }
}
