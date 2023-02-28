package com.atos.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.management.system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
