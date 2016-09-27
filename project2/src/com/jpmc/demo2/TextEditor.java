package com.jpmc.demo2;

public class TextEditor {
	
	private SpellChecker spellChecker;
	
	public void load(String document){
		System.out.println("Loading given document "+ document + " completed.");
		spellChecker.checkSpelling(document);
	}

}
