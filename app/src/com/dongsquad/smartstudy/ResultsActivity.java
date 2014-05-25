package com.dongsquad.smartstudy;
import com.splunk.*;  

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ResultsActivity extends Activity {
	private TableLayout table;
	private int index = 0;
	private ServiceArgs loginArgs = new ServiceArgs();
	private Service service;
	private TermSet set;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		table = new TableLayout(this);
		table.setStretchAllColumns(true);
		table.setShrinkAllColumns(true);
	}
	
	//don't know how this is going to turn out
	public void getTimes(View source)
	{
		index = LearnActivity.times.size();
		for (int i = 0; i < index; i++)
		{
			TableRow row = new TableRow(this);
			TextView label = new TextView(this);
			label.setText("Question " + i);
			row.addView(label);
			
			TextView label2 = new TextView(this);
			label2.setText(LearnActivity.times.get(i) + " milliseconds");
			row.addView(label2);
		}
	}
	public void getCorrect(View source)
	{
		/**loginArgs.setUsername("admin");
		loginArgs.setPassword("codeday2014");
		loginArgs.setHost("localhost");
		loginArgs.setPort(8089);
		service = Service.connect(loginArgs);
		int size = set.getCategories().size();
		Character[] charat = set.getCategories().toArray(null);
		for (int i = 0; i < size; i++)
		{
			TableRow row = new TableRow(this);
			TextView label = new TextView(this);
			
			label.setText(charat[i]);
			row.addView(label);
			
			TextView label2 = new TextView(this);
			label2
		}
		/**for (int i = 0; i < set.getTerms().size(); i++ )
		{
			TableRow row = new TableRow(this);
			TextView label = new TextView(this);
			
			int numCategories = set.getTerms().get(i).getCategories().size();
			for (int j = 0; i < max; i++)
			{	
			String category = set.getTerms().get(i).getCategories().;
			label.setText("");
			
		}*/
	}
}
