package com.example.synonym.java.controller;

import com.example.synonym.java.request.AddSynonymRequest;
import com.example.synonym.java.request.FindSynonymRequest;
import com.example.synonym.java.response.AddSynonymResponse;
import com.example.synonym.java.response.FindSynonymResponse;
import com.example.synonym.java.service.SynonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("synonym")
@CrossOrigin
public class SynonymController {
  
  @Autowired
  private SynonymService synonymService;
  
  @PostMapping("/add")
  public ResponseEntity<AddSynonymResponse> addSynonym(@RequestBody final AddSynonymRequest addSynonymRequest) {
    AddSynonymResponse addSynonymResponse = new AddSynonymResponse(synonymService.addSynonym(addSynonymRequest.getWord().toLowerCase(), addSynonymRequest.getWord2().toLowerCase()));
  
    return new ResponseEntity<>(
        addSynonymResponse,
        HttpStatus.OK
    );
  }
  
  @PostMapping("/find")
  public ResponseEntity<FindSynonymResponse> findSynonyms(@RequestBody final FindSynonymRequest findSynonymRequest) {
    FindSynonymResponse findSynonymResponse = new FindSynonymResponse(synonymService.findSynonymsForWord(findSynonymRequest.getWord().toLowerCase()));
    return new ResponseEntity<>(
        findSynonymResponse,
        HttpStatus.OK
    );
  }
  
}
