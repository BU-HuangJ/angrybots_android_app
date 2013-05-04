package com.group3.angrybots;

import android.app.Activity;

public class SuperMiniGames extends Activity {
	protected void saveResults(int score) {
		if (adapters.PersistentSettings.prefs.offlineMode == false) {
			
			long points = adapters.NetworkAdapter.getMember().getPoints();
			if (points > 0) {
				points += score;
			}
			adapters.NetworkAdapter.getMember().setPoints(points);
			adapters.NetworkAdapter.save();

			if (adapters.PersistentSettings.prefs.achievementTopHat == false && points >= 100) {
				adapters.NetworkAdapter.grantAchievement(base.Achievement.TOP_HAT.getId());
				adapters.PersistentSettings.prefs.achievementTopHat = true;
			}
			if (adapters.PersistentSettings.prefs.achievementMonocle == false && points >= 500) {
				adapters.NetworkAdapter.grantAchievement(base.Achievement.MONOCLE.getId());
				adapters.PersistentSettings.prefs.achievementMonocle = true;
			}
		}
	}
}
