package com.hector.nunez.services;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hector.nunez.entities.WordEntity;

public class SentenceHelper {

	public List<String> getSentences(String text){
		List<String> sentences = new ArrayList<String>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(text, ".");
		
		while(stringTokenizer.hasMoreTokens()){
			sentences.add(stringTokenizer.nextToken().trim());
		}
		
		return sentences; 
	}
	
	public void doLogic(List<String> sentences, WordEntity wordEntity) {

		for (int i = 0; i < sentences.size(); i++) {

			String[] wordOfSentence = sentences.get(i).split("[^\\w]");
			for (String word : wordOfSentence) {
				if (word.trim().equalsIgnoreCase(wordEntity.getWord())) {
					wordEntity.setTotalOccurrences(wordEntity.getTotalOccurrences() + 1);
					wordEntity.setSentenceIndexes(i);
				}
			}
		}
	}
}
