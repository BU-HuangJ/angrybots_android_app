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
		// adapters.NetworkAdapter.getRobotLeaderBoard()
		ArrayList<base.Member> members = adapters.NetworkAdapter.getRobotLeaderBoard();
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
		for(base.Member member : members) {
			if (i.hasNext() && member != null) {
				TextView tv = i.next();
				tv.setText( member.getUsername() );
				tv.setTypeface(this.getTypeface());
			} else {
				break;
			}
		}
	}
}
