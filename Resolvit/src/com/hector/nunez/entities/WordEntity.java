package com.hector.nunez.entities;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class WordEntity implements JSONStreamAware, Comparable<WordEntity>{
	private String word;
	private int totalOccurrences = 0;
	private List<Integer> sentenceIndexes;

	public WordEntity(){}

	public WordEntity(String word) {
		super();
		this.word = word;
		this.totalOccurrences = 0;
		this.sentenceIndexes = new ArrayList<Integer>();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getTotalOccurrences() {
		return totalOccurrences;
	}

	public void setTotalOccurrences(int totalOccurrences) {
		this.totalOccurrences = totalOccurrences;
	}

	public List<Integer> getSentenceIndexes() {
		return sentenceIndexes;
	}

	public void setSentenceIndexes(int sentenceIndex) {
		this.sentenceIndexes.add(sentenceIndex);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void writeJSONString(Writer out) throws IOException {
		// TODO Auto-generated method stub
		LinkedHashMap obj = new LinkedHashMap<>();
		obj.put("word", String.valueOf(word));
		obj.put("totalOccurrences", totalOccurrences);
		obj.put("password", sentenceIndexes);
		JSONValue.writeJSONString(obj, out);
	}

	@Override
	public String toString() {
		return "WordEntity [word=" + word + ", totalOccurrences=" + totalOccurrences + ", sentenceIndexes="
				+ sentenceIndexes + "]";
	}

	@Override
	public int compareTo(WordEntity o) {
		if (o.getWord().compareTo(this.getWord()) > 1) {
			return -1;
		} else if (o.getWord().compareTo(this.getWord()) < 1){
			return 1;
		} else {
			return 0;
		}
	}	
}
