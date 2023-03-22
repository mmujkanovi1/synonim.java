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
    synonymService.addSynonym("big1", "large");
    synonymService.addSynonym("important", "big");
    synonymService.addSynonym("important", "critical");
    synonymService.addSynonym("important", "BIG");
  
    synonymService.addSynonym("large", "string");
    synonymService.addSynonym("string", "prvi");
    synonymService.addSynonym("nevezano", "nevezano1");
    synonymService.addSynonym("nevezano", "nevezano");
    synonymService.addSynonym("big1", "Large");
    synonymService.addSynonym("large", "laptop");
    synonymService.addSynonym("nevezano", "big");
    synonymService.addSynonym("tv", "tv1");
    synonymService.addSynonym("tv2", "tv1");
    synonymService.addSynonym("tv3", "tv2");
    synonymService.addSynonym("tv2", "tv4");
    synonymService.addSynonym("tv2", "laptop");
    
  
  }
}
