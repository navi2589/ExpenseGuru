package com.expenceguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenceguru.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
