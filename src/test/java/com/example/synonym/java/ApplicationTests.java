package com.example.synonym.java;

import com.example.synonym.java.request.AddSynonymRequest;
import com.example.synonym.java.request.FindSynonymRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApplicationTests {
  
  private String host = "http://localhost:";
  
  private String pathAddSynonym = "/synonym/add";
  
  private String pathFindSynonym = "/synonym/find";
  
  @LocalServerPort
  private Integer port;
  
  @Test
  void createSynonym() {
    AddSynonymRequest addSynonymRequest = new AddSynonymRequest("crucial", "critical");
    RestAssured
        .given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(addSynonymRequest)
        .when()
        .post(host + port + pathAddSynonym)
        .then()
        .statusCode(HttpStatus.OK.value());
  }
  
  @Test
  void findSynonym() {
    FindSynonymRequest findSynonymRequest = new FindSynonymRequest("crucial");
    RestAssured
        .given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(findSynonymRequest)
        .when()
        .post(host + port + pathFindSynonym)
        .then()
        .statusCode(HttpStatus.OK.value());
  }
  
  @Test
  void shouldReturnEmptySynonymSet() {
    FindSynonymRequest findSynonymRequest = new FindSynonymRequest("test");
    RestAssured
        .given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(findSynonymRequest)
        .when()
        .post(host + port + pathFindSynonym)
        .then()
        .statusCode(HttpStatus.OK.value());
  }
  
  
  @Test
  void contextLoads() {
  }
  
}
