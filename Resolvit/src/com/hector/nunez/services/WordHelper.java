package com.hector.nunez.services;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.hector.nunez.entities.WordEntity;
import com.hector.nunez.enums.ExcludedWords;

public class WordHelper {

	/**
	 * Method that returns an array of alphabetized words
	 * @param text
	 * @return
	 */
	public Set<WordEntity> getWords(String text){
	
		Set<String> wordSet = new TreeSet<String>();
		
		for (String word : text.split("[^\\w]")) {
			if(word != null && !word.trim().equalsIgnoreCase("") && !isExcludedWord(word)){
				wordSet.add(word.toLowerCase().trim());
			}
		}
		
		return getWordEntitySet(wordSet);
	}
	
	private boolean isExcludedWord(String word) {
		for (ExcludedWords excludedWords : ExcludedWords.values()) {
			if(word.equalsIgnoreCase(excludedWords.toString().trim()))
				return true;
		}
		return false;
	}
	
	
	private static Set<WordEntity> getWordEntitySet(Set<String> wordSet) {
		
		Set<WordEntity> wordEntitySet = new TreeSet<WordEntity>();
		
		for (String word : wordSet) {
			WordEntity wordEntity = new WordEntity(word);
			wordEntitySet.add(wordEntity);
		}
		
		return wordEntitySet;
	}
}
