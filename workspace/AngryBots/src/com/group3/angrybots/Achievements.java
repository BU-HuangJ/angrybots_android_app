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

public class Achievements extends Activity {

	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_achievements);
	    
	    TextView myTextView=(TextView)findViewById(R.id.title);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
		myTextView.setTypeface(typeFace);
		myTextView.setText("Achievements");
		myTextView.setTextColor(Color.DKGRAY);
		
		myTextView=(TextView)findViewById(R.id.tv);
		myTextView.setTypeface(typeFace);
		myTextView.setText("1. Bob Smith\n" +
				"2. Roberto Smith\n" +
				"3. Killian Jones\n" +
				"4. Sampson Lares\n" +
				"5. Larenzo Saul\n" +
				"6. Bobby Smith\n" +
				"7. Isla Fisher\n" +
				"8. Harper Fish\n" +
				"9. Richard Loren\n" +
				"10. Ralph Lauren\n");
		myTextView.setTextColor(Color.DKGRAY);
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

}

