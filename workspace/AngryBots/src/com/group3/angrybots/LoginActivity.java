package com.group3.angrybots;

import java.io.IOException;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;

	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		// Set up the login form.
		mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
		mEmailView = (EditText) findViewById(R.id.email);
		mEmailView.setText(mEmail);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
					}
				});

		mEmailView.setText(adapters.PersistentSettings.prefs.email);
		mPasswordView.setText(adapters.PersistentSettings.prefs.password);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!mEmail.contains("@")) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
			showProgress(true);
			mAuthTask = new UserLoginTask();
			String[] params = {this.mEmail, this.mPassword};
			mAuthTask.execute( params );
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<String, Void, Boolean> {		
		@Override
		protected Boolean doInBackground(String... params) {			
			String mEmail = params[0];
			String mPassword = params[1];
			
			boolean connected;
			try {
				//adapters.NetworkAdapter.connect("65.111.126.38");
				adapters.NetworkAdapter.connect("129.62.89.231");
				connected = true;
			} catch (IOException e) {
				connected = false;
			}
			
			if (connected) {
				base.Member member = adapters.NetworkAdapter.login(mEmail, mPassword);
				// if logged in
				if (member != null) {
					adapters.PersistentSettings.prefs.email = mEmail;
					adapters.PersistentSettings.prefs.password = mPassword;
					
					adapters.PersistentSettings.prefs.username = member.getUsername();
					adapters.PersistentSettings.prefs.rank = member.getRank();
					adapters.PersistentSettings.prefs.hits = member.getHit();
					adapters.PersistentSettings.prefs.deaths = member.getDeaths();
					adapters.PersistentSettings.prefs.points = member.getPoints();
					adapters.PersistentSettings.prefs.play_time = member.getTime_played();

					adapters.PersistentSettings.prefs.achievementTopHat    = member.getAchievementMap().containsKey(base.Achievement.TOP_HAT.getId());
					adapters.PersistentSettings.prefs.achievementCowboyHat = member.getAchievementMap().containsKey(base.Achievement.COWBOY_HAT.getId());
					adapters.PersistentSettings.prefs.achievementMonocle   = member.getAchievementMap().containsKey(base.Achievement.MONOCLE.getId());
					adapters.PersistentSettings.prefs.achievementMustache  = member.getAchievementMap().containsKey(base.Achievement.MUSTACHE.getId());
					
					String faction = member.getaFaction().getName();
					if (faction.equalsIgnoreCase("humans")) {
						MainActivity.faction = MainActivity.Faction.HUMAN;
					} else if (faction.equalsIgnoreCase("robots")) {
						MainActivity.faction = MainActivity.Faction.ROBOT;
					}
					adapters.PersistentSettings.prefs.faction = faction;
					adapters.PersistentSettings.prefs.offlineMode = false;
					adapters.PersistentSettings.prefs.lastLoginAttemptWasSuccessful = true;
					
					adapters.PersistentSettings.prefs.savePreferences();
					return true;
				} else {
					adapters.PersistentSettings.prefs.lastLoginAttemptWasSuccessful = false;
					adapters.PersistentSettings.prefs.savePreferences();
					return false;
				}
			} else {
				// if previously logged in
				if (adapters.PersistentSettings.prefs.lastLoginAttemptWasSuccessful == true &&
					adapters.PersistentSettings.prefs.email.equals(mEmail) &&
					adapters.PersistentSettings.prefs.password.equals(mPassword) ) {
					
					adapters.PersistentSettings.prefs.offlineMode = true;
					
					String faction = adapters.PersistentSettings.prefs.faction;
					if (faction.equalsIgnoreCase("humans")) {
						MainActivity.faction = MainActivity.Faction.HUMAN;
					} else if (faction.equalsIgnoreCase("robots")) {
						MainActivity.faction = MainActivity.Faction.ROBOT;
					}
					
					adapters.PersistentSettings.prefs.savePreferences();
					return true;
				} else {
					adapters.PersistentSettings.prefs.lastLoginAttemptWasSuccessful = false;
					adapters.PersistentSettings.prefs.savePreferences();
					return false;
				}
			}
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			showProgress(false);

			if (success) {
				finish();
			} else {
				mPasswordView
						.setError(getString(R.string.error_incorrect_password));
				mPasswordView.requestFocus();
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
}
