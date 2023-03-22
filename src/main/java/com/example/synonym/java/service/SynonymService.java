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
      return false;
    }
    return true;
  }
  
  private void addingValuesIntoMap(final String word1, final String word2) {
    Set<String> emptySet = new HashSet<>();
    //if map contans key with word1 value, then find it and add word2 synonym
    
    if (synonymMapContainsWord(word1.toLowerCase(), word2.toLowerCase())) {
      synonymTable.get(word1.toLowerCase()).add(word2.toLowerCase());
    } else {
      emptySet.add(word2.toLowerCase());
      synonymTable.put(word1.toLowerCase(), emptySet);
    }
    
  }
  
  //add synonyms in both ways
  public String addSynonym(final String word1, final String word2) {
    
    if (word1.toLowerCase().equals(word2.toLowerCase())) {
      return "Word and it's synonym are the same and can't be added";
    }
    addingValuesIntoMap(word1, word2);
    addingValuesIntoMap(word2, word1);
    transitiveRule(word1.toLowerCase(), word2.toLowerCase());
    return "Synonym has been added succesufully";
  }
  
  private void transitiveRule(final String word1, final String word2) {
    addingValuesIntoMap(word1, word2);
    addingValuesIntoMap(word2, word1);
    for (String word : synonymTable.get(word1)) {
      if (!word.equals(word2)) {
        synonymTable.get(word).add(word2);
        synonymTable.get(word2).add(word);
      }
      if (!synonymTable.get(word2).isEmpty()) {
        for (String word01 : synonymTable.get(word2)) {
          if (!word.equals(word01)) {
            synonymTable.get(word).add(word01);
            synonymTable.get(word01).add(word);
          }
        }
      }
    }
    for (String word : synonymTable.get(word2)) {
      if (!word.equals(word1)) {
        synonymTable.get(word).add(word1);
        synonymTable.get(word1).add(word);
      }
    }
    
  }
  
  public Set<String> findSynonymsForWord(final String word) {
    //if word can't be found, we will return the empty set of values
    if (!synonymTable.containsKey(word.toLowerCase())) {
      Set<String> synonyms = new HashSet<>();
      return synonyms;
    }
    //else we will return list of synonyms for requested word
    return synonymTable.get(word.toLowerCase());
  }
  
}
