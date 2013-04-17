package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MinigamePortal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_minigame_portal);
		
		TextView myTextView=(TextView)findViewById(R.id.title);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
		myTextView.setTypeface(typeFace);
		
		myTextView.setText("Mini Games");
		myTextView.setTextColor(Color.DKGRAY);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_minigame_portal, menu);
		return true;
	}

	public void minigame(View view) {
		Intent intent = new Intent(this, MiniGame.class);
		startActivity(intent);
	}

	public void minigame2(View view) {
		Intent intent = new Intent(this, MiniGame2.class);
		startActivity(intent);
	}

}
