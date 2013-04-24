package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PersistentSettings extends Activity {
	public static final String PREFS_NAME = "User_Preferences";
	
	public String email, password, faction;
	public boolean offlineMode;
	public boolean robotCowboyHat, robotMonocle, robotMustache, robotTopHat;
	
	public void readPreferences(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		this.email = settings.getString("email", "");
		this.password = settings.getString("password", "");
		this.faction = settings.getString("faction", "");
		this.offlineMode = settings.getBoolean("offlineMode", false);
		this.robotCowboyHat = settings.getBoolean("robotCowboyHat", false);
		this.robotMonocle = settings.getBoolean("robotMonocle", false);
		this.robotMustache = settings.getBoolean("robotMustache", false);
		this.robotTopHat = settings.getBoolean("robotTopHat", false);
	}
	
	public void savePreferences(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("email", this.email);
		editor.putString("password", this.password);
		editor.putString("faction", this.faction);
		editor.putBoolean("offlineMode", this.offlineMode);
		editor.putBoolean("robotCowboyHat", this.robotCowboyHat);
		editor.putBoolean("robotMonocle", this.robotMonocle);
		editor.putBoolean("robotMustache", this.robotMustache);
		editor.putBoolean("robotTopHat", this.robotTopHat);
		editor.commit();
	}
	
	public static PersistentSettings prefs = null;
	
	private PersistentSettings() {}
	
	public static void populate(Context context) {
		PersistentSettings.prefs = new PersistentSettings();
		PersistentSettings.prefs.readPreferences(context);
	}
}
