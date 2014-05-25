package com.dongsquad.smartstudy;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;

public class ImportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_import);
	}

	protected void onStart() {
		super.onStart();
		final EditText input = new EditText(this);
		new AlertDialog.Builder(ImportActivity.this)
				.setTitle("Quizlet Import")
				.setMessage("Enter your Quizlet username")
				.setView(input)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						Utility.toast(ImportActivity.this, "starting import");
						ImportActivity.this.new ImportSetsTask().execute(input.getText().toString());
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								ImportActivity.this.finish();
							}
						}).show();
	}

	public class ImportSetsTask extends AsyncTask<String, Void, List<TermSet>> {

		@Override
		protected List<TermSet> doInBackground(String... params) {
			QuizletSource source = new QuizletSource();
			try {
				source.getSets(params[0]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			return source.getSets();
		}

		@Override
		protected void onPostExecute(final List<TermSet> sets) {
			Utility.toast(ImportActivity.this, "done with import, " + sets.size() + " sets");
		}

		@Override
		protected void onCancelled() {
		}
	}

}
