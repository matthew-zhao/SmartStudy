package com.dongsquad.smartstudy;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Term {

	private String term;
	private String definition;
	private TreeSet<String> categories = new TreeSet<String>();
	
	public Term(String term, String definition) {
		this.term = term;
		this.definition = definition;
	}
	
	public String getTerm() { return term; }
	public String getDefinition() { return definition; }
	public Set<String> getCategories() { return Collections.unmodifiableSet(categories); }
	public void setTerm(String term) { this.term = term; }
	public void setDefinition(String definition) { this.definition = definition; }
	public boolean addCategory(String category) { return categories.add(category); }
	public boolean removeCategory(String category) { return categories.remove(category); }
	
}
