package com.example.synonym.java.request;

//import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty;

public class AddSynonymRequest extends FindSynonymRequest {
  
  @NotEmpty(message = "Word could not be empty")
  private String word2;
  
  
  public AddSynonymRequest(final String word1, final String word2) {
    super(word1);
    this.word2 = word2;
  }
  
  
  
  public String getWord2() {
    return word2;
  }
  
  public void setWord2(final String word2) {
    this.word2 = word2;
  }
  
  
}
