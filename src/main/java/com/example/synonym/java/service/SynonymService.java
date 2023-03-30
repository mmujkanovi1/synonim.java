package com.example.synonym.java.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
public class SynonymService {
  
  // created map with key(String) and it's synonyms(Set<String>)
  //why Set instead of List? With this approach we will avoid checking whether synonym is already exist, set does not duplicate the values!!!
  private Map<String, Set<String>> synonymTable = new ConcurrentHashMap<>();
  
  //checking whether synonymMap contains key with the requested word
  private boolean synonymMapContainsKey(final String word1) {
    Set<String> synonyms = new HashSet<>();
    if (!synonymTable.containsKey(word1)) {
      return false;
    }
    return true;
  }
  
  //checking whether synonymMap contains synonym already
  private boolean synonymMapContainsSynonym(final String word1, final String word2) {
    return synonymTable.get(word1).contains(word2);
  }
  
  //in this method everything (word1, his synonyms, word2, his synonyms) has been added in one set
  private Set<String> addEverySynonymToOneCollection(final String word1, final String word2, final Set<String> synonymsWord1, final Set<String> synonmsWord2) {
    Set<String> allSynonymsSet = new HashSet<>();
    allSynonymsSet.addAll(synonymsWord1);
    allSynonymsSet.addAll(synonmsWord2);
    allSynonymsSet.add(word1);
    allSynonymsSet.add(word2);
    return allSynonymsSet;
  }
  
  //whole logic for addSynonyms
  private void addingValuesWithTransitiveRule(final String word1, final String word2) {
  
  
    Set<String> synonymsWord1Key = synonymTable.get(word1);
    boolean isItPresentInMap = true;
    if (synonymsWord1Key == null) {  //if word1 does not contains synonyms we are setting synonymsWord1Key to be empty, not null
      isItPresentInMap = false;
      synonymsWord1Key = new HashSet<String>();
    }
    Set<String> synonymsWord2Key = synonymTable.get(word2);
    if (synonymsWord2Key == null) {  //the same excercise for synonymsWord2Key
      synonymsWord2Key = new HashSet<>();
      if (!isItPresentInMap) {       // if word1 and word2 have empty list of synonyms I set them to be each other synonyms and return
        synonymsWord2Key.add(word2);
        synonymTable.put(word1, synonymsWord2Key);
        synonymsWord1Key.add(word1);
        synonymTable.put(word2, synonymsWord1Key);
        return;
      }
    }
    
    Set<String> wholeSynonymList = addEverySynonymToOneCollection(word1, word2, synonymsWord1Key, synonymsWord2Key);
    for (String value : wholeSynonymList) { //set each value from wholeSynonymList to be key and wholeSynonymList as the key synonyms
      synonymTable.put(value, wholeSynonymList.stream().filter(s -> s != value).collect(Collectors.toSet())); //filtering to avoid this situation beautiful -> pretty, beautiful...
    }
  }
  
  public String addSynonym(final String word1, final String word2) {
    if (word1.toLowerCase().equals(word2.toLowerCase())) {
      return "The word and its synonym are the same! Try again.";
    }
    
    if (synonymMapContainsKey(word1.toLowerCase())) {
      if (synonymMapContainsSynonym(word1.toLowerCase(), word2.toLowerCase())) {
        return "Synonym is already here! Try again.";
      }
    }
    
    addingValuesWithTransitiveRule(word1.toLowerCase(), word2.toLowerCase());
    return "Synonym added successfully";
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
