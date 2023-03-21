package com.example.synonym.java;

import com.example.synonym.java.service.SynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {
  
  @Autowired
  private SynonymService synonymService;
  
  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
  @Override
  public void run(final String... args) {
    synonymService.addSynonym("important", "large");
    synonymService.addSynonym("important", "big");
    synonymService.addSynonym("important", "critical");
    
    
  }
}
