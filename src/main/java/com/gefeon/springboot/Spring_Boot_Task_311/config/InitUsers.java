package com.gefeon.springboot.Spring_Boot_Task_311.config;

import com.gefeon.springboot.Spring_Boot_Task_311.model.Role;
import com.gefeon.springboot.Spring_Boot_Task_311.model.User;
import com.gefeon.springboot.Spring_Boot_Task_311.service.RoleService;
import com.gefeon.springboot.Spring_Boot_Task_311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUsers {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addDefaultUsers() {
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleService.getRoleByName("ROLE_ADMIN"));
        adminRoles.add(roleService.getRoleByName("ROLE_USER"));

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getRoleByName("ROLE_USER"));

        User admin = new User();
        User user = new User();

        admin.setUsername("ADMIN");
        admin.setPassword("admin");
        admin.setName("Ivan");
        admin.setSurname("Ivanov");
        admin.setAge((byte) 99);
        admin.setPhoneNumber("+79998765432");
        admin.setRoles(adminRoles);
        userService.addUser(admin);

        user.setUsername("USER2");
        user.setPassword("user");
        user.setName("Petr");
        user.setSurname("Petrov");
        user.setAge((byte) 18);
        user.setPhoneNumber("+79998765555");
        user.setRoles(userRoles);
        userService.addUser(user);
    }
}
