package com.dongsquad.smartstudy;

import android.app.Activity;
import android.widget.Toast;

public class Utility {

	public static void toast(final Activity activity, final CharSequence text) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(activity.getApplicationContext(), text,
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}
}
