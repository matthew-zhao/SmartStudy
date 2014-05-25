package com.dongsquad.smartstudy;

import java.util.ArrayList;
import java.util.TreeSet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dongsquad.smartstudy.CategoriesDialogFragment.CategoriesDialogListener;

public class TermActivity extends Activity implements CategoriesDialogListener {

	private GestureDetector gestureDetector;

	private ArrayList<Term> terms = new ArrayList<Term>();
	private int index = 0;

	private CategoriesDialogFragment categoriesDialog = new CategoriesDialogFragment();

	private TreeSet<CharSequence> categories = new TreeSet<CharSequence>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_term);

		gestureDetector = new GestureDetector(this, new GestureListener());
		
		updateCurrentView();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.term, menu);
	// return true;
	// }

	private final class GestureListener extends SimpleOnGestureListener {

		private static final int SWIPE_DISTANCE_THRESHOLD = 100;
		private static final int SWIPE_VELOCITY_THRESHOLD = 100;

		@Override
		public boolean onDown(MotionEvent e) {
			return true;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			float distanceX = e2.getX() - e1.getX();
			float distanceY = e2.getY() - e1.getY();
			if (Math.abs(distanceX) > Math.abs(distanceY)
					&& Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD
					&& Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
				if (distanceX > 0)
					onSwipeRight();
				else
					onSwipeLeft();
				return true;
			}
			return false;
		}
	}

	// go to previous term
	public void onSwipeRight() {
		if (index == 0)
			return;

		updateCurrentTerm();

		index--;

		updateCurrentView();

		toast("Swipe Right");
	}

	// go to next term
	public void onSwipeLeft() {
		updateCurrentTerm();

		index++;

		updateCurrentView();

		toast("Swipe Left");
	}

	private void updateCurrentTerm() {
		if (index >= terms.size()) {
			Term newTerm = new Term(
					((EditText) findViewById(R.id.txt_term_name)).getText()
							.toString(),
					((EditText) findViewById(R.id.txt_term_definition))
							.getText().toString());
			terms.add(newTerm);
		} else {
			Term currentTerm = terms.get(index);
			currentTerm.setTerm(((EditText) findViewById(R.id.txt_term_name))
					.getText().toString());
			currentTerm
					.setDefinition(((EditText) findViewById(R.id.txt_term_definition))
							.getText().toString());
		}
	}

	private void updateCurrentView() {
		if (index >= terms.size()) {
			((EditText) findViewById(R.id.txt_term_name)).setText(null);
			((EditText) findViewById(R.id.txt_term_definition)).setText(null);
			((Button) findViewById(R.id.btn_term_categories)).setEnabled(false);
		} else {
			Term currentTerm = terms.get(index);
			((EditText) findViewById(R.id.txt_term_name)).setText(currentTerm
					.getTerm());
			((EditText) findViewById(R.id.txt_term_definition))
					.setText(currentTerm.getDefinition());
			((Button) findViewById(R.id.btn_term_categories)).setEnabled(true);
		}

		((TextView) findViewById(R.id.lbl_number)).setText("Term #"
				+ (index + 1));
	}

	private void toast(final CharSequence text) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(getApplicationContext(), text,
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	public void exit(View source) {
		toast("exit");
	}

	public void showCategories(View source) {
		categoriesDialog
				.setChoiceItems(categories.toArray(new CharSequence[0]));
		categoriesDialog.setSelectedItems(terms.get(index).getCategories());
		categoriesDialog.show(getFragmentManager(), "categories_dialog");
	}

	@Override
	public void onCategoriesDialogDoneClick(CategoriesDialogFragment dialog,
			ArrayList<CharSequence> selected) {
		terms.get(index).clearCategories();
		terms.get(index).setCategories(selected);
		toast("selected " + selected.size() + " categories");
	}

	@Override
	public void onCategoriesDialogAddClick(CategoriesDialogFragment dialog) {
		final EditText input = new EditText(this);

		new AlertDialog.Builder(TermActivity.this)
				.setTitle("New category")
				.setMessage("Enter category name")
				.setView(input)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						TermActivity.this.categories.add((CharSequence)input.getText().toString());
						TermActivity.this.toast("added category:" + input.getText().toString());
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								TermActivity.this.showCategories(null);
							}
						});
//						InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//				        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// Do nothing.
							}
						}).show();
	}
	
	

}
