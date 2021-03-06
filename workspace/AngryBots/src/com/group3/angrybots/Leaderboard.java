package com.group3.angrybots;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.group3.angrybots.RobotActivity.Populater;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Leaderboard extends Activity {

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_leaderboard);
	    
	    TextView myTextView=(TextView)findViewById(R.id.humanpoints);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
		myTextView.setTypeface(typeFace);
		
		myTextView.setText("HUMANPOINTS");
		myTextView.setTextColor(Color.DKGRAY);
		

	    myTextView=(TextView)findViewById(R.id.robotpoints);
	    myTextView.setTypeface(typeFace);
	    myTextView.setText("ROBOTPOINTS");
		myTextView.setTextColor(Color.DKGRAY);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_leaderboard, menu);
		return true;
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
				
				iv = (ImageView)findViewById(R.id.robotbar);
				val = 1 - robot_points/total_points;
				iv.setLayoutParams(new TableLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, (val)));
				
				iv = (ImageView)findViewById(R.id.humanbar);
				val = 1 - human_points/total_points;
				iv.setLayoutParams(new TableLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, (val)));
			}
			TextView tv;
			
			tv = (TextView)findViewById(R.id.robotpoints);
			tv.setText(Float.toString(robot_points) + " ");
			tv.setTypeface(this.getTypeface());
			
			tv = (TextView)findViewById(R.id.humanpoints);
			tv.setText(Float.toString(human_points) + " ");
			tv.setTypeface(this.getTypeface());

		}
	
	 private Typeface getTypeface() {
			// TODO Auto-generated method stub
			return null;
		}

	/** Called when the user clicks the Lerpz Profile button */
    public void angrybotsProfile(View view) {
    	Intent intent = new Intent(this, AngryBotsProfile.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the leaderboard button */
    public void leaderboard(View view) {
    	Intent intent = new Intent(this, Leaderboard.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the leaderboard button */
    public void humanwiki(View view) {
    	Intent intent = new Intent(this, HumanWiki.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the achievements button */
    public void achievements(View view) {
    	Intent intent = new Intent(this, Achievements.class);
    	startActivity(intent);
    }
    
    public void map(View view){
    	Intent intent = new Intent(this, Map.class);
    	startActivity(intent);
    }
    
    public void server(View view){
    	Intent intent = new Intent(this, Server.class);
    	startActivity(intent);
	}

    public void settings(View view){
    	Intent intent = new Intent(this, Settings.class);
    	startActivity(intent);
    }

    public void minigame(View view){
    	Intent intent = new Intent(this, MinigamePortal.class);
    	startActivity(intent);
    } 
}

