package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PersistentSettings extends Activity {
	public static final String PREFS_NAME = "User_Preferences";
	public static final int ROBOT_LEADERBOARD_SIZE = 10;
	
	protected SharedPreferences settings;
	
	public String email, password, faction;
	public boolean offlineMode;
	public boolean robotCowboyHat, robotMonocle, robotMustache, robotTopHat;
	
	public float robot_global_points, human_global_points;
	public String[] robot_leaderboard;
	public String username;
	public int rank, hits, deaths;
	public float points;
	//public Time play_time;
	
	public void readPreferences(Context context) {
		this.settings = context.getSharedPreferences(PREFS_NAME, 0);
		
		this.email = settings.getString("email", "");
		this.password = settings.getString("password", "");
		this.faction = settings.getString("faction", "");
		this.offlineMode = settings.getBoolean("offlineMode", false);
		this.robotCowboyHat = settings.getBoolean("robotCowboyHat", false);
		this.robotMonocle = settings.getBoolean("robotMonocle", false);
		this.robotMustache = settings.getBoolean("robotMustache", false);
		this.robotTopHat = settings.getBoolean("robotTopHat", false);
		
		this.robot_global_points = settings.getFloat("robot_global_points", 0.0f);
		this.human_global_points = settings.getFloat("human_global_points", 0.0f);
		this.robot_leaderboard = new String[ROBOT_LEADERBOARD_SIZE];
		for(int i = 0; i < ROBOT_LEADERBOARD_SIZE; i++) {
			this.robot_leaderboard[i] = settings.getString("robot_leaderboard_"+(Integer.toString(i)), "");
		}
		this.username = settings.getString("username", "");
		this.rank = settings.getInt("rank", -1);
		this.hits = settings.getInt("hits", 0);
		this.deaths = settings.getInt("deaths", 0);
	}
	
	public void savePreferences() {
		SharedPreferences.Editor editor = this.settings.edit();
		
		editor.putString("email", this.email);
		editor.putString("password", this.password);
		editor.putString("faction", this.faction);
		editor.putBoolean("offlineMode", this.offlineMode);
		editor.putBoolean("robotCowboyHat", this.robotCowboyHat);
		editor.putBoolean("robotMonocle", this.robotMonocle);
		editor.putBoolean("robotMustache", this.robotMustache);
		editor.putBoolean("robotTopHat", this.robotTopHat);
		
		editor.putFloat("robot_global_points", this.robot_global_points);
		editor.putFloat("human_global_points", this.human_global_points);
		for(int i = 0; i < ROBOT_LEADERBOARD_SIZE; i++) {
			editor.putString("robot_leaderboard_"+(Integer.toString(i)), this.robot_leaderboard[i]);
		}
		editor.putString("username", this.username);
		editor.putInt("rank", this.rank);
		editor.putInt("hits", this.hits);
		editor.putInt("deaths", this.deaths);
		
		editor.commit();
	}
	
	public static PersistentSettings prefs = null;
	
	private PersistentSettings() {}
	
	public static void populate(Context context) {
		PersistentSettings.prefs = new PersistentSettings();
		PersistentSettings.prefs.readPreferences(context);
	}
}