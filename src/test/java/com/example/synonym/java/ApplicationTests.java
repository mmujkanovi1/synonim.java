package com.example.synonym.java;

import com.example.synonym.java.request.AddSynonymRequest;
import com.example.synonym.java.request.FindSynonymRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest
class ApplicationTests {
  
  private String host = "http://localhost:8080/synonym";
  
  private String pathAddSynonym = "/add";
  
  private String pathFindSynonym = "/find";
  
  @Test
  void createSynonym() {
    AddSynonymRequest addSynonymRequest = new AddSynonymRequest("crucial", "critical");
    RestAssured
        .given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(addSynonymRequest)
        .when()
        .post(host + pathAddSynonym)
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
        .post(host + pathFindSynonym)
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
        .post(host + pathFindSynonym)
        .then()
        .statusCode(HttpStatus.OK.value());
  }
  
  
  @Test
  void contextLoads() {
  }
  
}
