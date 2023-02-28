package com.atos.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.management.system.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);

}
