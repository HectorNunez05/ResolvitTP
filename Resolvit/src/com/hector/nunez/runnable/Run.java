package com.hector.nunez.runnable;

import java.util.List;
import java.util.Set;

import com.hector.nunez.entities.WordEntity;
import com.hector.nunez.services.SentenceHelper;
import com.hector.nunez.services.WordHelper;

public class Run {

	public static void main(String[] args) {
		
		WordHelper fileReadingHelper = new WordHelper();
		SentenceHelper sentencesHelper = new SentenceHelper();
		
		String text = "Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word "
				+ "is any form of a word often communicated with essentially the same meaning. For example, fish and fishes "
				+ "could be defined as a unique word by using their stem fish. For each unique word found in this entire "
				+ "paragraph, determine the how many times the word appears in total. Also, provide an analysis of what unique "
				+ "sentence index position or positions the word is found. The following words should not be included in your "
				+ "analysis or result set: \"a\", \"the\", \"and\", \"of\", \"in\", \"be\", \"also\" and \"as\".  Your final "
				+ "result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.";
		
		Set<WordEntity> wordSet = fileReadingHelper.getWords(text); 
		List<String> listaOraciones = sentencesHelper.getSentences(text);
		
		for (WordEntity wordEntity : wordSet) {
			sentencesHelper.doLogic(listaOraciones, wordEntity);
			System.out.println(wordEntity);
		}
		
	}
}
