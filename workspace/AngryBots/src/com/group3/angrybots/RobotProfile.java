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
			// TODO check for updated stats
		}
		this.setStats();
		this.setProfile();
	}
	
	protected void setStats() {
		String rank = Integer.toString(adapters.PersistentSettings.prefs.rank);
		switch(adapters.PersistentSettings.prefs.rank) {
		case 1:  rank += "st"; break;
		case 2:  rank += "nd"; break;
		case 3:	 rank += "rd"; break;
		default: rank += "th"; break;
		}
		
		int minutes = adapters.PersistentSettings.prefs.play_time % 60;
		int hours   = adapters.PersistentSettings.prefs.play_time / 60;
		String hour_minutes = Integer.toString(hours) + " hrs\n\t" + Integer.toString(minutes) + " mins";
		
		this.setFont( (TextView)findViewById(R.id.RobotName)  ).setText("\t" + adapters.PersistentSettings.prefs.username);
		this.setFont( (TextView)findViewById(R.id.RobotRank)  ).setText("\t" + rank);
		this.setFont( (TextView)findViewById(R.id.HitCount)   ).setText("\t" + adapters.PersistentSettings.prefs.hits);
		this.setFont( (TextView)findViewById(R.id.DeathCount) ).setText("\t" + adapters.PersistentSettings.prefs.deaths);
		this.setFont( (TextView)findViewById(R.id.PointCount) ).setText("\t" + adapters.PersistentSettings.prefs.points);
		this.setFont( (TextView)findViewById(R.id.PlayTime)   ).setText("\t" + hour_minutes);

		this.setFont( (TextView)findViewById(R.id.robot_achievement_top_hat_req)    );
		this.setFont( (TextView)findViewById(R.id.robot_achievement_cowboy_hat_req) );
		this.setFont( (TextView)findViewById(R.id.robot_achievement_monocle_req)    );
		this.setFont( (TextView)findViewById(R.id.robot_achievement_mustache_req)   );
	}
	
	protected void setProfile() {
		adapters.PersistentSettings prefs = adapters.PersistentSettings.prefs;
		if (prefs.achievementCowboyHat && prefs.robotCowboyHat) {
			findViewById(R.id.RobotCowboyHat).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotCowboyHat).setVisibility(View.INVISIBLE);
		}
		
		if (prefs.achievementMonocle && prefs.robotMonocle) {
			findViewById(R.id.RobotMonocle).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotMonocle).setVisibility(View.INVISIBLE);
		}
		
		if (prefs.achievementMustache && prefs.robotMustache) {
			findViewById(R.id.RobotMustache).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotMustache).setVisibility(View.INVISIBLE);
		}
		
		if (prefs.achievementTopHat && prefs.robotTopHat) {
			findViewById(R.id.RobotTopHat).setVisibility(View.VISIBLE);
		} else {
			findViewById(R.id.RobotTopHat).setVisibility(View.INVISIBLE);
		}
		
	}

}
