package com.taxconsultant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxconsultant.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
