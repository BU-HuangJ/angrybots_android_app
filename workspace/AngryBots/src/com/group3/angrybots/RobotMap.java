package com.group3.angrybots;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class RobotMap extends RobotActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_map);
		// Show the Up button in the action bar.
		setupActionBar();
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
		getMenuInflater().inflate(R.menu.robot_map, menu);
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
		this.enableMappoints();
	}
	
	protected void disableMappoints() {
		findViewById(R.id.mappoint1).setClickable(false);
		findViewById(R.id.mappoint3).setClickable(false);
		findViewById(R.id.mappoint4).setClickable(false);
		findViewById(R.id.mappoint5).setClickable(false);
		findViewById(R.id.mappoint6).setClickable(false);
		findViewById(R.id.mappoint7).setClickable(false);
		findViewById(R.id.mappoint8).setClickable(false);
		findViewById(R.id.mappoint9).setClickable(false);
		findViewById(R.id.mappoint10).setClickable(true);
	}
	
	protected void enableMappoints() {
		findViewById(R.id.mappoint1).setClickable(true);
		findViewById(R.id.mappoint3).setClickable(true);
		findViewById(R.id.mappoint4).setClickable(true);
		findViewById(R.id.mappoint5).setClickable(true);
		findViewById(R.id.mappoint6).setClickable(true);
		findViewById(R.id.mappoint7).setClickable(true);
		findViewById(R.id.mappoint8).setClickable(true);
		findViewById(R.id.mappoint9).setClickable(true);
		findViewById(R.id.mappoint10).setClickable(false);
	}

	public void mappoint1(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_1);
		this.disableMappoints();
	}

	public void mappoint3(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_3);
		this.disableMappoints();
	}

	public void mappoint4(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_4);
		this.disableMappoints();
	}

	public void mappoint5(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_5);
		this.disableMappoints();
	}

	public void mappoint6(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_6);
		this.disableMappoints();
	}

	public void mappoint7(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_7);
		this.disableMappoints();
	}

	public void mappoint8(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_8);
		this.disableMappoints();
	}

	public void mappoint9(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_9);
		this.disableMappoints();
	}

	public void mappoint10(View view) {
		findViewById(R.id.robot_map).setBackgroundResource(R.drawable.map_image_10);
		this.enableMappoints();
	}

}
