package com.hyogeon.clustertest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonApplicationService {

    private final PersonDomainService personDomainService;

    public PersonApplicationService(PersonDomainService personDomainService) {
        this.personDomainService = personDomainService;
    }

    @Transactional //있고 없고 차이
    public Person changeAge(Long id, int age) {
        personDomainService.changeAge(id, age);
        return personDomainService.findByName("hyogeon");
    }
}
