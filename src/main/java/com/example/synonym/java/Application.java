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
    synonymService.addSynonym("beautiful", "pretty");
    synonymService.addSynonym("pretty", "good-looking");
    synonymService.addSynonym("beaut", "atractive");
    synonymService.addSynonym("pleasing", "gorgeous");
    synonymService.addSynonym("pleasing", "atractive");
    synonymService.addSynonym("atractive", "pretty");
    synonymService.addSynonym("lovely", "alluring");
    synonymService.addSynonym("lovely", "beautiful");
    synonymService.addSynonym("magnificent", "beautiful");
  
  //  Good- acceptable, favorable, positive, satisfactory, satisfying, valuable, efficient, proper,  suitable
    
    synonymService.addSynonym("Good-acceptable", "favorable");
    synonymService.addSynonym("positive", "satisfactory");
    synonymService.addSynonym("satisfactory", "favorable");
    synonymService.addSynonym("satisfying", "valuable");
    synonymService.addSynonym("efficient", "valuable");
    synonymService.addSynonym("proper", "suitable");
    synonymService.addSynonym("Good-acceptable", "suitable");
    synonymService.addSynonym("Good-acceptable", "satisfying");
  
    synonymService.addSynonym("Happy-content", "contented");
    synonymService.addSynonym("joyful", "contented");
    synonymService.addSynonym("merry", "jovial");
    synonymService.addSynonym("cheery", "fortunate");
    synonymService.addSynonym("fortunate", "contented");
    synonymService.addSynonym("cheery", "merry");
    synonymService.addSynonym("delighted", "joyous");
    synonymService.addSynonym("joyous", "ecstatic");
    synonymService.addSynonym("cheery", "thrilled");
    synonymService.addSynonym("cheery", "elated");
    synonymService.addSynonym("joyous", "thrilled");
  
    //Ethical-moral, right-minded, right-thinking, righteous, blameless, guiltless, virtuous, trustworthy, just
  
    synonymService.addSynonym("Ethical-moral", "right-minded");
    synonymService.addSynonym("right-thinking", "right-minded");
    synonymService.addSynonym("righteous", "blameless");
    synonymService.addSynonym("blameless", "guiltless");
    synonymService.addSynonym("right-minded", "guiltless");
    synonymService.addSynonym("virtuous", "righteous");
    synonymService.addSynonym("trustworthy", "just");
    synonymService.addSynonym("right-minded", "trustworthy");
  }
}
