package com.dongsquad.smartstudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.dongsquad.smartstudy.json.JSONArray;
import com.dongsquad.smartstudy.json.JSONObject;

public class TermSet implements Serializable {
	
	public String name = null;
	public Set<CharSequence> categories = new TreeSet<CharSequence>();
	public List<Term> terms = new ArrayList<Term>();

	public TermSet() {
	}

	public TermSet(JSONObject jsonObject) {
		name = jsonObject.getString("title");
		JSONArray termsJson = jsonObject.getJSONArray("terms");
		for (int i = 0; i < termsJson.length(); i++) {
			terms.add(new Term(termsJson.getJSONObject(i)));
		}
	}

}
