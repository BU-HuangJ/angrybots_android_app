package com.group3.angrybots;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class RobotProfile extends RobotActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_profile);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_robot_profile, menu);
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
		if (!adapters.PersistentSettings.prefs.offlineMode) {
			this.setStats();
			this.setProfile();
		}
	}
	
	protected void setStats() {
		( (TextView)findViewById(R.id.RobotName) ).setText(adapters.MemberAdapter.getMember().getUsername());
		//( (TextView)findViewById(R.id.RobotRank) ).setText(adapters.MemberAdapter.getMember().getRank());
		( (TextView)findViewById(R.id.HitCount) ).setText( Integer.toString(adapters.MemberAdapter.getMember().getHit()) );
		//( (TextView)findViewById(R.id.DeathCount) ).setText(adapters.MemberAdapter.getMember().getDeaths());
		( (TextView)findViewById(R.id.PointCount) ).setText( Long.toString(adapters.MemberAdapter.getMember().getPoints()) );
		//( (TextView)findViewById(R.id.PlayTime) ).setText(adapters.MemberAdapter.getMember().getPlayTime());
	}
	
	protected void setProfile() {
		if (adapters.PersistentSettings.prefs.robotCowboyHat) {
			findViewById(R.id.RobotCowboyHat).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotCowboyHat).setVisibility(View.INVISIBLE);
		}
		
		if (adapters.PersistentSettings.prefs.robotMonocle) {
			findViewById(R.id.RobotMonocle).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotMonocle).setVisibility(View.INVISIBLE);
		}
		
		if (adapters.PersistentSettings.prefs.robotMustache) {
			findViewById(R.id.RobotMustache).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotMustache).setVisibility(View.INVISIBLE);
		}
		
		if (adapters.PersistentSettings.prefs.robotTopHat) {
			findViewById(R.id.RobotTopHat).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotTopHat).setVisibility(View.INVISIBLE);
		}
		
	}

}
