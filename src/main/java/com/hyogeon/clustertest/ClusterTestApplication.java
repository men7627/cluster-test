package com.hyogeon.clustertest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@Slf4j
public class ClusterTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClusterTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        WebClient webClient = WebClient.create();
        webClient.post().uri("http://localhost:8080/person/hyogeon/20/1234").retrieve().bodyToMono(String.class).block();

        int i = 25;

        while (true) {
            Person person = webClient.put().uri("http://localhost:8080/person/1/" + i).retrieve().bodyToMono(Person.class).block();

//            Person person = webClient.get().uri("http://localhost:8080/person/1")
//                    .retrieve()
//                    .bodyToMono(Person.class).block();

            log.info("i : {}, Age: {}", i, person.getAge());
            if (i != person.getAge()) {
                log.info("DIFF, i: {} Age: {}", i, person.getAge());
            }

            i++;

        }
    }

}
