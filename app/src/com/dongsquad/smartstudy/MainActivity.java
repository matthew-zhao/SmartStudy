package com.dongsquad.smartstudy;

import com.dongsquad.smartstudy.SetChooserDialogFragment.SetChooserDialogListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements SetChooserDialogListener {

	private static final int EDIT = 1;
	private static final int QUIZ = 2;
	private static final int LEARN = 3;
	private int action = 0;
	
	private SetChooserDialogFragment setChooser = new SetChooserDialogFragment();
	private SetsSource source = new DummySetSource();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
	public void newQuiz(View source) {
		Intent intent = new Intent(MainActivity.this, TermActivity.class);
		startActivity(intent);
	}
	
	public void quit(View source) {
		finish();
	}
	
	public void edit(View source) {
		action = EDIT;
		setChooser.setSource(this.source);
		setChooser.show(getFragmentManager(), "setChooser");
	}
	
	public void takeQuiz(View source) {
		action = QUIZ;
		setChooser.setSource(this.source);
		setChooser.show(getFragmentManager(), "setChooser");
	}
	
	public void learn(View source) {
		action = LEARN;
		setChooser.setSource(this.source);
		setChooser.show(getFragmentManager(), "setChooser");
	}
	
	public void doImport(View source) {
		Intent intent = new Intent(MainActivity.this, ImportActivity.class);
		startActivity(intent);
	}

	@Override
	public void onSetChooserDialogPositiveClick(SetChooserDialogFragment dialog) {
		Utility.toast(this, "chose set: " + setChooser.getSelected());
		
		TermSet chosenSet = null;
		for (TermSet set : source.getSets()) {
			if (set.name.equals(setChooser.getSelected().toString()))
				chosenSet = set;
		}
		
		if (action == LEARN) {
			Intent intent = new Intent(MainActivity.this, LearnActivity.class);
			intent.putExtra(LearnActivity.EXTRA_TERMSET, chosenSet);
			startActivity(intent);
		}
	}

	@Override
	public void onSetChooserDialogNegativeClick(SetChooserDialogFragment dialog) {
		
	}

}
