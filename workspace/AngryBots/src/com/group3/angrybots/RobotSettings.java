package com.group3.angrybots;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class RobotSettings extends RobotActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_settings);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_robot_settings, menu);
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
	
	@Override
	protected void onResume() { 
		super.onResume();
		this.flipServer();
		this.flip(findViewById(R.id.robot_flip_top_hat), adapters.PersistentSettings.prefs.robotTopHat);
		this.flip(findViewById(R.id.robot_flip_monocle), adapters.PersistentSettings.prefs.robotMonocle);
		this.flip(findViewById(R.id.robot_flip_cowboy_hat), adapters.PersistentSettings.prefs.robotCowboyHat);
		this.flip(findViewById(R.id.robot_flip_mustache), adapters.PersistentSettings.prefs.robotMustache);
	}
	
	public void flipServer() {
		if (adapters.PersistentSettings.prefs.offlineMode) {
			findViewById(R.id.robot_server_status).setBackgroundResource(R.drawable.robot_server_status_off);
		} else {
			findViewById(R.id.robot_server_status).setBackgroundResource(R.drawable.robot_server_status_on);
		}
	}
	
	protected void flip(View view, boolean flipped) {
		if (flipped) {
			view.setBackgroundResource(R.drawable.robot_setting_button_on);
		} else {
			view.setBackgroundResource(R.drawable.robot_setting_button_off);
		}
	}
	
	public void flipTopHat(View view) {
		if (adapters.PersistentSettings.prefs.achievementTopHat) {
			adapters.PersistentSettings.prefs.robotTopHat ^= true;
		}
		this.flip(view, adapters.PersistentSettings.prefs.robotTopHat);
		adapters.PersistentSettings.prefs.savePreferences();
	}
	
	public void flipMonocle(View view) {
		if (adapters.PersistentSettings.prefs.achievementMonocle) {
			adapters.PersistentSettings.prefs.robotMonocle ^= true;
		}
		this.flip(view, adapters.PersistentSettings.prefs.robotMonocle);
		adapters.PersistentSettings.prefs.savePreferences();
	}
	
	public void flipCowboyHat(View view) {
		if (adapters.PersistentSettings.prefs.achievementCowboyHat) {
			adapters.PersistentSettings.prefs.robotCowboyHat ^= true;
		}
		this.flip(view, adapters.PersistentSettings.prefs.robotCowboyHat);
		adapters.PersistentSettings.prefs.savePreferences();
	}
	
	public void flipMustache(View view) {
		if (adapters.PersistentSettings.prefs.achievementMustache) {
			adapters.PersistentSettings.prefs.robotMustache ^= true;
		}
		this.flip(view, adapters.PersistentSettings.prefs.robotMustache);
		adapters.PersistentSettings.prefs.savePreferences();
	}

}
