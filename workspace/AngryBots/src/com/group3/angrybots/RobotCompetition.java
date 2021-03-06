package com.group3.angrybots;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.format.DateFormat;

public class RobotCompetition extends RobotActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_competition);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
    
    @Override
    public void onResume() {
    	super.onResume();

		Populater.populate(new Runnable() {
			@Override
			public void run() {
				setPoints();
			}
		});
    }
	
	public void setPoints() {
		float robot_points = adapters.PersistentSettings.prefs.robot_global_points;
		float human_points = adapters.PersistentSettings.prefs.human_global_points;
		
		// if online, check for updates
		if (!adapters.PersistentSettings.prefs.offlineMode) {
			float updated_robot_points = adapters.NetworkAdapter.getRobotTotalPoints();
			float updated_human_points = adapters.NetworkAdapter.getHumanTotalPoints();
			if ( (updated_robot_points != robot_points) || (updated_human_points != human_points) ) {
				robot_points = adapters.PersistentSettings.prefs.robot_global_points = updated_robot_points;
				human_points = adapters.PersistentSettings.prefs.human_global_points = updated_human_points;
				adapters.PersistentSettings.prefs.savePreferences();
			}
		}
		
		float total_points = robot_points + human_points;
		if (total_points != 0) {
			ImageView iv;
			float val;
			
			iv = (ImageView)findViewById(R.id.robot_robots_bar);
			val = 1 - robot_points/total_points;
			iv.setLayoutParams(new TableLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, (val)));
			
			iv = (ImageView)findViewById(R.id.robot_humans_bar);
			val = 1 - human_points/total_points;
			iv.setLayoutParams(new TableLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, (val)));
		}
		TextView tv;
		
		tv = (TextView)findViewById(R.id.robot_robots_points);
		tv.setText(Float.toString(robot_points) + " ");
		tv.setTypeface(this.getTypeface());
		
		tv = (TextView)findViewById(R.id.robot_humans_points);
		tv.setText(Float.toString(human_points) + " ");
		tv.setTypeface(this.getTypeface());

		GregorianCalendar calendar = new GregorianCalendar();
		// SUNDAY   = 1; (8 - SUNDAY  ) = (8 - 1) = 7 == 7 days to next Sunday
		// SATURDAY = 7; (8 - SATURDAY) = (8 - 7) = 1 == 1 days to next Sunday
		int delta = 8 - calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DAY_OF_YEAR, delta);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		
		tv = (TextView)findViewById(R.id.robot_competition_ends);
		tv.setText( DateFormat.format("MM/dd/yyyy hh:mm aa", calendar) );
		tv.setTypeface(this.getTypeface());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_robot_competition, menu);
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

}
