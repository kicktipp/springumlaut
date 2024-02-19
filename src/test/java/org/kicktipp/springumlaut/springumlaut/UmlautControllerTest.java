package org.kicktipp.springumlaut.springumlaut;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UmlautControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testWithUmlaut() {
        String url = "http://localhost:" + port + "/hallo/";
        assertEquals("Hallöchen", this.restTemplate.getForObject(url, String.class));
    }

    @Test
    void testWithoutUmlaut() {
        String url = "http://localhost:" + port + "/hello/";
        assertEquals("Hi", this.restTemplate.getForObject(url, String.class));
    }
}