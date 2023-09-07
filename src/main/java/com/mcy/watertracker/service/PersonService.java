package com.mcy.watertracker.service;

import com.mcy.watertracker.entity.Person;
import com.mcy.watertracker.model.dto.PersonDTO;
import com.mcy.watertracker.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired private PersonRepository personRepository;

  public PersonDTO registerPerson(PersonDTO personDTO) {
    Person person = new Person();
    person.setFirstName(personDTO.getFirstName());
    person.setLastName(personDTO.getLastName());
    person.setCountryOfOrigin(personDTO.getCountryOfOrigin());

    var updatedPerson = personRepository.save(person);

    return new PersonDTO(
        updatedPerson.getFirstName(),
        updatedPerson.getLastName(),
        updatedPerson.getCountryOfOrigin());
  }

  // Other service methods for persons (e.g., getPersonById, updatePerson, deletePerson)
}
