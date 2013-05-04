package com.group3.angrybots;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class AngryBotsProfile extends Activity {

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_angrybots_profile);
	    
	    TextView myTextView=(TextView)findViewById(R.id.title);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
		myTextView.setTypeface(typeFace);
		
		myTextView.setText("Profile");
		myTextView.setTextColor(Color.DKGRAY);
		
		TextView text = (TextView)findViewById(R.id.title2);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Lt. Greensy");
        
        text = (TextView)findViewById(R.id.prank);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Colonel Major General of the Eighth Army of the Plains - Level 9");
        
        text = (TextView)findViewById(R.id.robotkills);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Career Kills");
        
        text = (TextView)findViewById(R.id.robokills);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Robots Killed"+"\t\t\t\t\t\t"+"9000000000");
        
        text = (TextView)findViewById(R.id.waves);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Robot Wave Lasted"+"\t\t\t\t\t\t"+"80");
        
        text = (TextView)findViewById(R.id.minigamepoints);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Mini Game Points");
        
        text = (TextView)findViewById(R.id.mg1);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Mini Game 1"+"\t\t\t\t\t\t"+"44444");
        
        text = (TextView)findViewById(R.id.mg2);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Mini Game 2"+"\t\t\t\t\t\t"+"4545436");
        
        text = (TextView)findViewById(R.id.mg3);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Mini Game 3"+"\t\t\t\t\t\t"+"54545555");
        
        text = (TextView)findViewById(R.id.achievements);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Achievements");
        
        text = (TextView)findViewById(R.id.ach1);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        text.setText("Achievement 1"+"\n"+"Achievement 2"+"\n"+"Achievement 3\nAchievement 4\nAchievement5\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_achievements, menu);
		return true;
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
    
    @Override
	protected void onResume() {
		super.onResume();
		if (!adapters.PersistentSettings.prefs.offlineMode) {
			this.setStats();
			this.setProfile();
		}
	}
	
	protected void setStats() {
		
		
		( (TextView)findViewById(R.id.title2)  ).setText(adapters.PersistentSettings.prefs.username);
		( (TextView)findViewById(R.id.prank)  ).setText(adapters.PersistentSettings.prefs.rank);
		( (TextView)findViewById(R.id.robokills)   ).setText(adapters.PersistentSettings.prefs.hits);
		//( (TextView)findViewById(R.id.DeathCount) ).setText(adapters.PersistentSettings.prefs.deaths);
		( (TextView)findViewById(R.id.mg1) ).setText(Float.toString(adapters.PersistentSettings.prefs.points));
		//( (TextView)findViewById(R.id.PlayTime)   ).setText(adapters.PersistentSettings.prefs.play_time);
	}
	
	protected void setProfile() {
		
		
	}
}

