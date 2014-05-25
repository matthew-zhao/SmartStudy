package com.dongsquad.smartstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class KnowActivity extends Activity {
	
	private long beginTime = 0;
	private long time = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_know);
		beginTime = System.currentTimeMillis();
	}
	
	public void revealAnswer(View view)
	{
		time = System.currentTimeMillis() - beginTime;
		
	}
}
