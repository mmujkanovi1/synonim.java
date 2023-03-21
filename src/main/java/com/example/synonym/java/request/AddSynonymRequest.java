package com.example.synonym.java.request;

public class AddSynonymRequest extends FindSynonymRequest {
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
