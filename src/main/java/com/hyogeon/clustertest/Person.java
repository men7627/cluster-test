package com.hyogeon.clustertest;

import javax.persistence.*;

@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "age", length = 20, nullable = false)
    private int age;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void changeAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
