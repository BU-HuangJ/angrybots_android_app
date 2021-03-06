package com.group3.angrybots;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

public class RobotActivity extends Activity {
	public void toRobotCompetitionPage(View view) {
		startActivity( new Intent(this, RobotCompetition.class) );
	}
	public void toRobotProfilePage(View view) {
		startActivity( new Intent(this, RobotProfile.class) );
	}
	public void toRobotWikiPage(View view) {
		startActivity( new Intent(this, RobotWiki.class) );
	}
	public void toRobotMapPage(View view) {
		startActivity( new Intent(this, RobotMap.class) );
	}
	public void toRobotSettingsPage(View view) {
		startActivity( new Intent(this, RobotSettings.class) );
	}
	public void toRobotLeaderboardPage(View view) {
		startActivity( new Intent(this, RobotLeaderboard.class) );
	}
	public void toRobotMinigamesPage(View view) {
		startActivity( new Intent(this, RobotMinigames.class) );
	}
	
	public Typeface getTypeface() {
		return Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
	}
	
	public TextView setFont(TextView view) {
		view.setTypeface(getTypeface());
		return view;
	}
	
	protected static class Populater {
		public static void populate(Runnable r) {
			( new Handler(Looper.getMainLooper()) ).post( r	);
		}
	}
}
