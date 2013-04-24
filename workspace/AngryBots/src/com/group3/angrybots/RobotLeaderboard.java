package com.group3.angrybots;

import java.util.ArrayList;
import java.util.Iterator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class RobotLeaderboard extends RobotActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_leaderboard);
		// Show the Up button in the action bar.
		setupActionBar();

		Populater.populate(new Runnable() {
			@Override
			public void run() {
				setLeaderboard();
			}
		});
	}
    
    @Override
    public void onResume() {
    	super.onResume();

		Populater.populate(new Runnable() {
			@Override
			public void run() {
				setLeaderboard();
			}
		});
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
		getMenuInflater().inflate(R.menu.robot_leaderboard, menu);
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
	
	public void setLeaderboard() {
		// if online, check for updates 
		if (!adapters.PersistentSettings.prefs.offlineMode) {
			ArrayList<base.Member> members = adapters.NetworkAdapter.getRobotLeaderBoard();
			boolean changed = false;
			Iterator<base.Member> it = members.iterator();
			for(int i = 0; i < adapters.PersistentSettings.ROBOT_LEADERBOARD_SIZE; i++) {
				if (it.hasNext()) {
					String updated_name = it.next().getUsername();
					if (!updated_name.equals(adapters.PersistentSettings.prefs.robot_leaderboard[i])) {
						adapters.PersistentSettings.prefs.robot_leaderboard[i] = updated_name;
						changed = true;
					}
				} else {
					break;
				}
			}
			if (changed) {
				adapters.PersistentSettings.prefs.savePreferences();
			}
		}
		
		ArrayList<TextView> views = new ArrayList<TextView>();
		views.add( (TextView)findViewById(R.id.rank1) );
		views.add( (TextView)findViewById(R.id.rank2) );
		views.add( (TextView)findViewById(R.id.rank3) );
		views.add( (TextView)findViewById(R.id.rank4) );
		views.add( (TextView)findViewById(R.id.rank5) );
		views.add( (TextView)findViewById(R.id.rank6) );
		views.add( (TextView)findViewById(R.id.rank7) );
		views.add( (TextView)findViewById(R.id.rank8) );
		views.add( (TextView)findViewById(R.id.rank9) );
		Iterator<TextView> i = views.iterator();
		for(String username : adapters.PersistentSettings.prefs.robot_leaderboard) {
			if (i.hasNext() && username != null) {
				TextView tv = i.next();
				tv.setText( username );
				tv.setTypeface(this.getTypeface());
			} else {
				break;
			}
		}
	}
}
