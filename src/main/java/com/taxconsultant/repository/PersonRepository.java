package com.taxconsultant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxconsultant.entites.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
