package com.dongsquad.smartstudy;

import com.dongsquad.smartstudy.SetChooserDialogFragment.SetChooserDialogListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements SetChooserDialogListener {

	private boolean edit = false;
	private boolean takeQuiz = false;
	
	private SetChooserDialogFragment setChooser = new SetChooserDialogFragment();
	private SetBankSource source = new DummySetSource();
	
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
		takeQuiz = false;
		edit = true;
		setChooser.setSource(this.source);
		setChooser.show(getFragmentManager(), "setChooser");
	}
	
	public void takeQuiz(View source) {
		edit = false;
		takeQuiz = true;
		setChooser.setSource(this.source);
		setChooser.show(getFragmentManager(), "setChooser");
	}

	@Override
	public void onSetChooserDialogPositiveClick(SetChooserDialogFragment dialog) {
		Utility.toast(this, "chose set: " + setChooser.getSelected());
	}

	@Override
	public void onSetChooserDialogNegativeClick(SetChooserDialogFragment dialog) {
		
	}

}
