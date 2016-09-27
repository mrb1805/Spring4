package com.java.demo2;

public class TextEditor {
	
	private SpellChecker spellChecker;

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void load(String document){
		System.out.println("Loading given document "+ document + " completed.");
		spellChecker.checkSpelling(document);
	}
}
