package com.example.synonym.java.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Service
public class SynonymService {
  
  // created map with key(String) and it's synonyms(Set<String>)
  //why Set instead of List? With this approach we will avoid checking whether synonym is already exist, set does not duplicate the values!!!
  private Map<String, Set<String>> synonymTable = new HashMap<>();
  
  //checking whether synonymMap contains key with the requested word
  private boolean synonymMapContainsWord(final String word1, final String word2) {
    Set<String> synonyms = new HashSet<>();
    if (!synonymTable.containsKey(word1)) {
      synonyms.add(word2);
      synonymTable.put(word1, synonyms);
      //adding the values and returning the truth
      return false;
    }
    return true;
  }
  
  
  //add synonyms in both ways
  public String addSynonym(final String word1, final String word2) {
    
    //if map contans key with word1 value, then find it and add word2 synonym
    if (synonymMapContainsWord(word1, word2)) {
      synonymTable.get(word1).add(word2);
    }
    
    //the same if as previos, just the other way around
    if (synonymMapContainsWord(word2, word1)) {
      synonymTable.get(word2).add(word1);
    }
    return "Synonym has been added succesufully";
  }
  
  public Set<String> findSynonymsForWord(final String word) {
    //if word can't be found, we will return the empty set of values
    if (!synonymTable.containsKey(word)) {
      Set<String> synonyms = new HashSet<>();
      synonymTable.put(word, synonyms);
      return synonyms;
    }
    //else we will return list of synonyms for requested word
    return synonymTable.get(word);
  }
  
}
