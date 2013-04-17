package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class HumanWiki extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		
		setContentView(R.layout.activity_human_wiki);
		
		TextView myTextView=(TextView)findViewById(R.id.tv);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
		myTextView.setTypeface(typeFace);
		
		myTextView=(TextView)findViewById(R.id.title);
		myTextView.setTypeface(typeFace);
		myTextView.setText("Wiki");
		myTextView.setTextColor(Color.DKGRAY);
		
		TextView text = (TextView)findViewById(R.id.tv2);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
		
		text.setText("INTRODUCTION Plenty of people have opinions on the best way to train a dog, " +
				"but what works for one dog might not necessarily work for another one. All dogs learn things differently," +
				" much like humans do, so it makes sense that multiple training styles exist and are used. " +
				"Differences exist among dogs within the same breed, making the first step of any training program a challenge." +
				" To correctly understand a dog and convince him to obey commands, the owner must first figure out what motivates" +
				" the dog. This paper will explain the differences between the two most popular training methods and " +
				"why clicker training is the better choice.\nThe first type of training uses a correction collar " +
				"to give the dog negative feedback when he performs a command incorrectly. Though this is a " +
				"popular option heralded by some dog trainers, others stand on the argument that correction " +
				"training can harm a dog. Many people suggest throwing all training collars into the nearest " +
				"full body of water. Some anti-correction trainers vote for clicker training, which is " +
				"using a small box that makes a clicking noise. Whenever the dog performs a command correctly, " +
				"he receives a click and a treat. Both of these rewards are positive feedback, and the " +
				"dog associates the command with a good experience to be repeated. \nOther trainers disagree on the " +
				"use of clickers in positive training. Some of the common problems with clicker training include that " +
				"the clicker isnt always around, and sometimes the dog decides that something else is more " +
				"interesting than a treat. Both types of training have pros and cons that will " +
				"expanded upon further.\n\n\n\n\n\n\n");
		
		text = (TextView)findViewById(R.id.title2);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_human_wiki, menu);
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
