package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Mappoint1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mappoint1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mappoint1, menu);
		return true;
	}

}
