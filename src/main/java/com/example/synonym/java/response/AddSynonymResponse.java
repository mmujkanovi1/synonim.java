package com.example.synonym.java.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSynonymResponse {
  
  @JsonProperty("responseMessage")
  private String addSynonymResponseMessage;
  
  public AddSynonymResponse(final String addSynonymResponseMessage) {
    this.addSynonymResponseMessage = addSynonymResponseMessage;
  }
  
  public String getAddSynonymResponseMessage() {
    return addSynonymResponseMessage;
  }
  
  public void setAddSynonymResponseMessage(final String addSynonymResponseMessage) {
    this.addSynonymResponseMessage = addSynonymResponseMessage;
  }
}
