package ru.kata.spring.boot_security.demo.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.model.*;

@Component
public class DefaultUser {
    
    @Autowired 
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    private void initialize(){
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);


        User user1 = new User();
        user1.setAge(2);
        user1.setName("test");
        user1.setCar("testcar");
        user1.setUsername("a");
        user1.setPassword("a");

        user1.addRole(role1);


        User user2 = new User();
        user2.setName("user");
        user2.setCar("car");
        user2.setAge(1);
        user2.setUsername("user");
        user2.setPassword("user");
        user2.addRole(role2);

        userService.add(user1);
        userService.add(user2);


    }


}
