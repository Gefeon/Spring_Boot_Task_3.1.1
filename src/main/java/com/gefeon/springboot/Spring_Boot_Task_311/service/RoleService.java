package com.gefeon.springboot.Spring_Boot_Task_311.service;

import com.gefeon.springboot.Spring_Boot_Task_311.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role> listRoles();

    Role getRoleById(Long id);

    Role getRoleByName(String name);
}