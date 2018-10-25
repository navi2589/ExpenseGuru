package com.expenceguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenceguru.entites.PersonContact;

public interface PersonContactRepository extends JpaRepository<PersonContact, Long> {

}
