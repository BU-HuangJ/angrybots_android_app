package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class RobotHomePage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_home_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_robot_home_page, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
        startActivity( new Intent(this, RobotCompetition.class) );
	}

}
