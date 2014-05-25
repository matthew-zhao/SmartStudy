package com.dongsquad.smartstudy;

import java.util.ArrayList;
import java.util.List;

public class DummySetSource implements SetsSource {

	private ArrayList<TermSet> sets;
	
	public DummySetSource() {
		sets = new ArrayList<TermSet>();
		
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
		
		term = new Term("Badminton", "Badminton is a racquet sport played by either two opposing players (singles) or two opposing pairs (doubles), who take positions on opposite halves of a rectangular court divided by a net. Players score points by striking a shuttlecock with their racquet so that it passes over the net and lands in their opponents' half of the court. Each side may only strike the shuttlecock once before it passes over the net. A rally ends once the shuttlecock has struck the floor, or if a fault has been called by either the umpire or service judge or, in their absence, the offending player, at any time during the rally.");
		term.addCategory("Racket sport");
		term.addCategory("Olympic sport");
		set.terms.add(term);
		
		term = new Term("Hockey", "Hockey is a family of sports in which two teams play against each other by trying to maneuver a ball or a puck into the opponent's goal using a hockey stick. In many areas, one sport (typically field hockey or ice hockey[1]) is generally referred to simply as hockey.");
		term.addCategory("Olympic sport");
		set.terms.add(term);
		
		term = new Term("Basketball", "Basketball is a sport played by two teams of five players on a rectangular court. The objective is to shoot a ball through a hoop 18 inches (46 cm) in diameter and 10 feet (3.0 m) high mounted to a backboard at each end. A  team can score a field goal by shooting the ball through the basket during regular play. A field goal scores two points for the shooting team if a player is touching or closer to the basket than the three-point line, and three points (known commonly as a 3 pointer or three) if the player is behind the three-point line.");
		term.addCategory("Olympic sport");
		set.terms.add(term);
		
		term = new Term("Baseball", "Baseball is a bat-and-ball game played between two teams of nine players who take turns batting and fielding. The offense attempts to score runs by hitting a ball thrown by the pitcher with a bat and moving counter-clockwise around a series of four bases: first, second, third and home plate. A run is scored when the runner advances around the bases and returns to home plate.");
		set.terms.add(term);
		//--

		
		set = new TermSet();
		set.name = "Elements";
		set.categories.add("Noble gas");
		set.categories.add("Alkali metal");
		set.categories.add("Liquid at room temp");
		sets.add(set);
		
		term = new Term("Mercury", "a metallic chemical element with the symbol Hg and atomic number 80");
		term.addCategory("Liquid at room temp");
		set.terms.add(term);
		
		term = new Term("Iron", "Iron is a chemical element with the symbol Fe (from Latin: ferrum) and atomic number 26.");
		set.terms.add(term);
		
		term = new Term("Helium", "Helium is a chemical element with symbol He and atomic number 2.");
		term.addCategory("Noble Gas");
		set.terms.add(term);
		
		term = new Term("Sodium", "Sodium is a chemical element with the symbol Na (from Latin: natrium) and atomic number 11.");
		term.addCategory("Alkali metal");
		set.terms.add(term);
		
		
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
	}
	
	@Override
	public List<TermSet> getSet() {
		return sets;
	}

}
