package com.example.synonym.java.request;

import javax.validation.constraints.NotEmpty;

public class FindSynonymRequest {
  
  @NotEmpty(message = "Word could not be empty")
  private String word;
  
  public FindSynonymRequest() {
  }
  
  public FindSynonymRequest(final String word) {
    this.word = word;
  }
  
  public String getWord() {
    return word;
  }
  
  public void setWord(final String word) {
    this.word = word;
  }
}
