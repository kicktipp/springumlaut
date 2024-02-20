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

    // does not work
    @Test
    void testWithUmlaut() {
        String url = "http://localhost:" + port + "/hallo";
        assertEquals("Hallöchen", this.restTemplate.getForObject(url, String.class));
    }

    // does work
    @Test
    void testWithoutRedirectButWithUmlaut() {
        String url = "http://localhost:" + port + "/hallöchen";
        assertEquals("Hallöchen", this.restTemplate.getForObject(url, String.class));
    }

    // ok with redirectattributes
    @Test
    void testWithRedirectattributes() {
        String url = "http://localhost:" + port + "/redirectattributes";
        assertEquals("Hallöchen", this.restTemplate.getForObject(url, String.class));
    }

    // ok with manual encoding
    @Test
    void testWithEncoding() {
        String url = "http://localhost:" + port + "/encoding";
        assertEquals("Hallöchen", this.restTemplate.getForObject(url, String.class));
    }

    // ok without any umlauts
    @Test
    void testWithoutUmlaut() {
        String url = "http://localhost:" + port + "/hello";
        assertEquals("Hi", this.restTemplate.getForObject(url, String.class));
    }
}