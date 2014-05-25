package com.dongsquad.smartstudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TermSet implements Serializable {
	public String name = null;
	public Set<CharSequence> categories = new TreeSet<CharSequence>();
	public List<Term> terms = new ArrayList<Term>();
}
