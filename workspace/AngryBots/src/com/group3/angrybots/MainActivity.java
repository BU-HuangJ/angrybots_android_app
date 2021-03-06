package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	public enum Faction {
		HUMAN, ROBOT
	}
	public static Faction faction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_home_page);
		adapters.PersistentSettings.populate(this.getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_human_home_page, menu);
        return true;
    }
    
    @Override
    public void onResume() {
    	super.onResume();
        Intent intent = new Intent(this, LoginActivity.class);
    	if (MainActivity.faction != null) {
    		switch (MainActivity.faction) {
			case HUMAN:
				intent = new Intent(this, HumanHomePage.class);
				break;
			case ROBOT:
				intent = new Intent(this, RobotHomePage.class);
				break;

			default:
				break;
			}
    	}
        startActivity(intent);
    }
    
}
