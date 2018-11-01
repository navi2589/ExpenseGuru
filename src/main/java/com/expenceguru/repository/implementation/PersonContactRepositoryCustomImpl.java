package com.expenceguru.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.expenceguru.pojo.PersonContactPojo;
import com.expenceguru.repository.PersonContactRepositoryCustom;


@Repository
public class PersonContactRepositoryCustomImpl implements PersonContactRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	public List<PersonContactPojo> getPersonContactsByPersonId(long personId) {
		
		List<PersonContactPojo> personContacts = entityManager.createNamedQuery("getPersonContactsByPersonId")
				.setParameter("personId", personId)
				.getResultList();
		
		return personContacts;
	}
}
