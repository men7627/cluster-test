package com.hyogeon.clustertest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonDomainService {

    private final PersonRepository personRepository;

    public PersonDomainService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Person save(String name, int age, String phoneNumber) {
        Person person = new Person(name, age, phoneNumber);
        return personRepository.save(person);
    }

    @Transactional
    public void changeAge(Long id, int age) {
        personRepository.updateAge(id, age);
    }

    @Transactional(readOnly = true)
    public Person findByName(String name) {
        return personRepository.findFirstByName(name);
    }


}
