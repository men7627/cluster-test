package com.hyogeon.clustertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonApplicationServiceTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonApplicationService personApplicationService;

    @Autowired
    private PersonDomainService personDomainService;

    @BeforeEach
    void setUp() {
        Person person = new Person("hyogeon", 20, "01012341234");
        personRepository.save(person);
    }

    @Test
    void changeName() {
        int i = 21;

        while(true) {
            personApplicationService.changeAge(1L, i);
            Person person = personDomainService.findById(1L);

            assertThat(person.getAge()).isEqualTo(i++);
        }
    }
}