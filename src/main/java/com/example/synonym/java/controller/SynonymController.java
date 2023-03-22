package com.example.synonym.java.controller;

import com.example.synonym.java.request.AddSynonymRequest;
import com.example.synonym.java.request.FindSynonymRequest;
import com.example.synonym.java.response.AddSynonymResponse;
import com.example.synonym.java.response.FindSynonymResponse;
import com.example.synonym.java.service.SynonymService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("synonym")
@CrossOrigin
public class SynonymController {
  
  @Autowired
  private SynonymService synonymService;
  
  private Logger logger = LoggerFactory.getLogger(SynonymController.class);
  
  @PostMapping("/add")
  public ResponseEntity<AddSynonymResponse> addSynonym(@Valid @RequestBody final AddSynonymRequest addSynonymRequest) {
    AddSynonymResponse addSynonymResponse = new AddSynonymResponse(synonymService.addSynonym(addSynonymRequest.getWord(), addSynonymRequest.getWord2()));
    logger.info("New synonym has been added: " + addSynonymRequest.getWord() + " -> " + addSynonymRequest.getWord2());
    return new ResponseEntity<>(
        addSynonymResponse,
        HttpStatus.OK
    );
  }
  
  @PostMapping("/find")
  public ResponseEntity<FindSynonymResponse> findSynonyms(@Valid @RequestBody final FindSynonymRequest findSynonymRequest) {
    FindSynonymResponse findSynonymResponse = new FindSynonymResponse(synonymService.findSynonymsForWord(findSynonymRequest.getWord()));
    logger.info("Synonyms for " + findSynonymRequest.getWord());
    return new ResponseEntity<>(
        findSynonymResponse,
        HttpStatus.OK
    );
  }
  
}
