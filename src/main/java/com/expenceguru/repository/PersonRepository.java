package com.expenceguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenceguru.entites.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
