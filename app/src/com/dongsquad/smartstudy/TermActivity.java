package com.dongsquad.smartstudy;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TermActivity extends Activity {

	private GestureDetector gestureDetector;

	private ArrayList<Term> terms = new ArrayList<Term>();
	private int index = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_term);

		gestureDetector = new GestureDetector(this, new GestureListener());
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

		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Swipe Right", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}

	// go to next term
	public void onSwipeLeft() {
		updateCurrentTerm();

		index++;

		updateCurrentView();

		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Swipe Left", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
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
		} else {
			Term currentTerm = terms.get(index);
			((EditText) findViewById(R.id.txt_term_name)).setText(currentTerm
					.getTerm());
			((EditText) findViewById(R.id.txt_term_definition))
					.setText(currentTerm.getDefinition());
		}

		((TextView) findViewById(R.id.lbl_number)).setText("Term #"
				+ (index + 1));
	}

}
