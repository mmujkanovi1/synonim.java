package com.example.synonym.java.request;

public class FindSynonymRequest {
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
