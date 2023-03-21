package com.example.synonym.java.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class FindSynonymResponse {
  
  @JsonProperty("synonyms")
  private Set<String> synonyms;
  
  public FindSynonymResponse(final Set<String> synonyms) {
    this.synonyms = synonyms;
  }
  
  public Set<String> getSynonyms() {
    return synonyms;
  }
  
  public void setSynonyms(final Set<String> synonyms) {
    this.synonyms = synonyms;
  }
}
