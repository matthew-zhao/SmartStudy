package com.dongsquad.smartstudy;

import java.util.ArrayList;
import java.util.List;

public class DummySetSource implements SetBankSource {

	@Override
	public List<TermSet> getSet() {
		ArrayList<TermSet> sets = new ArrayList<TermSet>();
		TermSet set;
		Term term;
		
		set = new TermSet();
		set.name = "Sports";
		set.categories.add("Racket sport");
		set.categories.add("Olympic sport");
		sets.add(set);
		
		term = new Term("Tennis", "Tennis is a sport people play individually against a single opponent (singles) or between two teams of two players each (doubles). Each player uses a racquet that is strung with cord to strike a hollow rubber ball covered with felt over or around a net and into the opponent's court. The object of the game is to play the ball in such a way that the opponent is not able to play a good return.");
		term.addCategory("Racket sport");
		term.addCategory("Olympic sport");
		set.terms.add(term);
		
		term = new Term("Badminton", "<-DEFINE->");
		// etc...

		
		set = new TermSet();
		set.name = "Elements";
		set.categories.add("Noble gas");
		set.categories.add("Alkali metal");
		set.categories.add("Liquid at room temp");
		sets.add(set);
		
		term = new Term("Mercury", "<-DEFINE->");
		term.addCategory("Liquid at room temp");
		set.terms.add(term);
		// etc...

		
		set = new TermSet();
		set.name = "Languages";
		set.categories.add("Romantic");
		set.categories.add("East Asian");
		sets.add(set);
		
		term = new Term("English", "<-DEFINE->");
		set.terms.add(term);
		
		term = new Term("Portugese", "<-DEFINE->");
		term.addCategory("Romantic");
		set.terms.add(term);
		// etc...
		
		set = new TermSet();
		set.name = "Motor vechicles";
		set.categories.add("trucks");
		set.categories.add("cars");
		set.categories.add("buses");
		sets.add(set);
		
		term = new Term("Honda Accord", "<-DEFINE->");
		term.addCategory("Cars");
		set.terms.add(term);
		
		term = new Term("F-Series", "<-DEFINE->");
		term.addCategory("Trucks");
		set.terms.add(term);
		// etc...
		
		set = new TermSet();
		set.name = "Video Games";
		set.categories.add("Single Player");
		set.categories.add("Multiplayer");
		sets.add(set);
		
		term = new Term("Runescape", "<-DEFINE->");
		term.addCategory("Multiplayer");
		set.terms.add(term);
		
		term = new Term("League of Legends", "<-DEFINE->");
		term.addCategory("Multiplayer");
		set.terms.add(term);
		// etc...
		
		set = new TermSet();
		set.name = "Bicycles";
		set.categories.add("Geared Bike");
		set.categories.add("Non-Geared Bike");
		sets.add(set);
		
		term = new Term("Schwinn Discover", "<-DEFINE->");
		term.addCategory("Geared Bike");
		set.terms.add(term);
		
		// etc...
		
		set = new TermSet();
		set.name = "Cars";
		set.categories.add("Coupe");
		set.categories.add("Sedan");
		sets.add(set);
		
		term = new Term("BMW 535d", "<-DEFINE->");
		term.addCategory("Sedan");
		set.terms.add(term);
		
		
		term = new Term("BMW 528i", "<-DEFINE->");
		term.addCategory("Coupe");
		set.terms.add(term);
		// etc...
		return sets;
	}

}
