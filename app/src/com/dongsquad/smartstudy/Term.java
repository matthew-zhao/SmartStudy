package com.dongsquad.smartstudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.dongsquad.smartstudy.json.JSONObject;

public class Term implements Serializable {

	private String term;
	private String definition;
	private TreeSet<CharSequence> categories = new TreeSet<CharSequence>();
	
	public Term(String term, String definition) {
		this.term = term;
		this.definition = definition;
	}
	
	public Term(JSONObject jsonObject) {
		term = jsonObject.getString("term");
		definition = jsonObject.getString("definition");
	}

	public String getTerm() { return term; }
	public String getDefinition() { return definition; }
	public Set<CharSequence> getCategories() { return Collections.unmodifiableSet(categories); }
	public void setTerm(String term) { this.term = term; }
	public void setDefinition(String definition) { this.definition = definition; }
	public boolean addCategory(String category) { return categories.add(category); }
	public boolean removeCategory(String category) { return categories.remove(category); }
	public void clearCategories() { categories.clear(); }
	public void setCategories(ArrayList<CharSequence> categories) { this.categories.addAll(categories); }
	
}
