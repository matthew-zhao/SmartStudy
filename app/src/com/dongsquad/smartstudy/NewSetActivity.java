package com.dongsquad.smartstudy;

import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewSetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_set);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new_set, menu);
		Button button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				EditText text = (EditText) findViewById(R.id.editText1);
				
				String filename = "userSets";
				String set = text.getText().toString();
				FileOutputStream outputStream;

				try {
				  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
				  outputStream.write(set.getBytes());
				  outputStream.close();
				} catch (Exception e) {
				  e.printStackTrace();
				}
				
				Intent intent = new Intent(NewSetActivity.this, TermActivity.class);
				startActivity(intent);
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(NewSetActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		return true;
	}

}
