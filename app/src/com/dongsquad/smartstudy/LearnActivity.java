package com.dongsquad.smartstudy;

import java.util.ArrayList;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LearnActivity extends Activity {

	public static final String EXTRA_TERMSET = "com.dongsquad.smartstudy.extra.TERMSET";
	public static ArrayList<Long> times = new ArrayList<Long>();
	private static long timeNow = 0;
	private TermSet terms;
	private int index = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn);
		// Show the Up button in the action bar.
		setupActionBar();

		Bundle extras = getIntent().getExtras();
		terms = (TermSet) extras.getSerializable(EXTRA_TERMSET);

		index = 0;
		setTerm();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.learn, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void pass(View source) {
		times.set(index, System.currentTimeMillis() - timeNow);
		nextTerm();
		System.out.println("Passed!");
	}

	public void fail(View source) {
		times.set(index, System.currentTimeMillis()- timeNow);
		((Button) findViewById(R.id.btn_learn_fail)).setEnabled(false);

		findViewById(R.id.view_separator).setVisibility(View.VISIBLE);
		findViewById(R.id.lbl_definition).setVisibility(View.VISIBLE);
	}

	private void nextTerm() {
		((Button) findViewById(R.id.btn_learn_pass)).setEnabled(false);
		((Button) findViewById(R.id.btn_learn_fail)).setEnabled(false);

		final View lblTerm = findViewById(R.id.lbl_term);
		final View lblDefinition = findViewById(R.id.lbl_definition);
		final View separator = findViewById(R.id.view_separator);
		lblTerm.animate().alpha(0f).setDuration(200);
		findViewById(R.id.view_separator).animate().alpha(0f).setDuration(200)
				.setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						lblTerm.animate().alpha(1f).setDuration(200);
						lblDefinition.setAlpha(1f);
						separator.setAlpha(1f);
					}
				});
		findViewById(R.id.lbl_definition).animate().alpha(0f).setDuration(200)
				.setListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						LearnActivity.this.index++;
						LearnActivity.this.setTerm();
					}
				});
	}

	private void setTerm() {
		findViewById(R.id.view_separator).setVisibility(View.INVISIBLE);
		findViewById(R.id.lbl_definition).setVisibility(View.INVISIBLE);

		Term term = terms.terms.get(index);
		((TextView) findViewById(R.id.lbl_term)).setText(term.getTerm());
		((TextView) findViewById(R.id.lbl_definition)).setText(term
				.getDefinition());
		
		((Button) findViewById(R.id.btn_learn_pass)).setEnabled(true);
		((Button) findViewById(R.id.btn_learn_fail)).setEnabled(true);
		timeNow = System.currentTimeMillis();
	}

}
