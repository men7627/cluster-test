package com.hyogeon.clustertest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonApplicationService personApplicationService;

    private final PersonDomainService personDomainService ;


    public PersonController(PersonApplicationService personApplicationService, PersonDomainService personDomainService) {
        this.personApplicationService = personApplicationService;
        this.personDomainService = personDomainService;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personDomainService.findById(id);
    }

    @PostMapping("/{name}/{age}/{phoneNumber}")
    public Person createPerson(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("phoneNumber") String phoneNumber) {
        return personDomainService.save(name, age, phoneNumber);
    }

    @PutMapping("/{id}/{age}")
    public Person changeAge(@PathVariable("id") Long id, @PathVariable("age") int age) throws InterruptedException {
        return personApplicationService.changeAge(id, age);
    }
}
