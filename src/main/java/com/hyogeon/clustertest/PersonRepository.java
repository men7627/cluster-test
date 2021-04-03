package com.hyogeon.clustertest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findFirstByName(String name);

    @Modifying(clearAutomatically = true)
    @Query("update person p set p.age = ?2 where p.id = ?1")
    void updateAge(Long id, int age);
}
