package com.hyogeon.clustertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonIntegrationTest {

    @Autowired
    protected WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient.post().uri("/person/hyogeon/20/01000000000")
                .exchange().expectStatus().isOk()
                .expectBody()
                .jsonPath("$.age").isEqualTo(20);
    }

    @Test
    void test() {
        int i = 25;

        while(true) {
            webTestClient.put().uri("/person/1/" + i)
                    .exchange().expectStatus().isOk();

            webTestClient.get().uri("/person/1")
                    .exchange().expectStatus().isOk()
                    .expectBody()
                    .jsonPath("$.age").isEqualTo(i);

            i++;
        }
    }
}
