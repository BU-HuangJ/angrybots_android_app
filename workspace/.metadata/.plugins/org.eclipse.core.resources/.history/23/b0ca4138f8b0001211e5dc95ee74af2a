package com.group3.angrybots;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MiniGame3 extends SuperMiniGames {
	
	private static class RPC {
		public enum Gesture {
			ROCK, PAPER, SCISSORS;
		}
		public enum Result {
			WIN, TIE, LOSS;
		}
		public static Result getResult(Gesture lhs, Gesture rhs) {
			if (lhs == rhs) {
				return Result.TIE;
			} else if ( (lhs == Gesture.ROCK && rhs == Gesture.SCISSORS) || 
						(lhs == Gesture.PAPER && rhs == Gesture.ROCK) ||
						(lhs == Gesture.SCISSORS && rhs == Gesture.PAPER) ) {
				return Result.WIN;
			} else {
				return Result.LOSS;
			}
		}
		public static String getString(Gesture g) {
			switch(g) {
			case ROCK:		return "rock";
			case PAPER:		return "paper";
			case SCISSORS:	return "scissors";
			default:		return null;
			}
		}
		public static Gesture getRandomGesture() {
			switch( (new java.util.Random()).nextInt(3) ) {
			case 0:		return Gesture.ROCK;
			case 1:		return Gesture.PAPER;
			case 2:		return Gesture.SCISSORS;
			default:	return null;
			}
		}
	}
	
	private String key = null;
	private int winCount  = 0;
	private int tieCount  = 0;
	private int loseCount = 0;
	
	public void updateGame(RPC.Gesture lhs, RPC.Gesture rhs) {
		( (TextView)findViewById(R.id.p1_choice) ).setText( RPC.getString(lhs) );
		( (TextView)findViewById(R.id.p2_choice) ).setText( RPC.getString(rhs) );
		switch( RPC.getResult(lhs, rhs) ) {
		case WIN:  ( (TextView)findViewById(R.id.RPC_wins)   ).setText(Integer.toString(++winCount) ); break;
		case TIE:  ( (TextView)findViewById(R.id.RPC_ties)   ).setText(Integer.toString(++tieCount) ); break;
		case LOSS: ( (TextView)findViewById(R.id.RPC_losses) ).setText(Integer.toString(++loseCount)); break;
		}
		this.set_up_game();
	}
	
	public void chooseRock(View view) {
		RPC.Gesture opponent_gesture;
		if (this.key != null) {
			String results = adapters.NetworkAdapter.sendRPC_Action(Messaging.RPC_Action.ROCK, this.key);
			if (results.equalsIgnoreCase("winner")) {
				opponent_gesture = RPC.Gesture.SCISSORS;
			} else if (results.equalsIgnoreCase("loser")) {
				opponent_gesture = RPC.Gesture.PAPER;
			} else if (results.equalsIgnoreCase("tie")) {
				opponent_gesture = RPC.Gesture.ROCK;
			} else {
				opponent_gesture = RPC.getRandomGesture();
			}
		} else {
			opponent_gesture = RPC.getRandomGesture();
		}
		this.updateGame( RPC.Gesture.ROCK, opponent_gesture );
	}
	
	public void choosePaper(View view) {
		RPC.Gesture opponent_gesture;
		if (this.key != null) {
			String results = adapters.NetworkAdapter.sendRPC_Action(Messaging.RPC_Action.PAPER, this.key);
			if (results.equalsIgnoreCase("winner")) {
				opponent_gesture = RPC.Gesture.ROCK;
			} else if (results.equalsIgnoreCase("loser")) {
				opponent_gesture = RPC.Gesture.SCISSORS;
			} else if (results.equalsIgnoreCase("tie")) {
				opponent_gesture = RPC.Gesture.PAPER;
			} else {
				opponent_gesture = RPC.getRandomGesture();
			}
		} else {
			opponent_gesture = RPC.getRandomGesture();
		}
		this.updateGame( RPC.Gesture.PAPER, opponent_gesture );
	}
	
	public void chooseScissors(View view) {
		RPC.Gesture opponent_gesture;
		if (this.key != null) {
			String results = adapters.NetworkAdapter.sendRPC_Action(Messaging.RPC_Action.SCISSORS, this.key);
			if (results.equalsIgnoreCase("winner")) {
				opponent_gesture = RPC.Gesture.PAPER;
			} else if (results.equalsIgnoreCase("loser")) {
				opponent_gesture = RPC.Gesture.ROCK;
			} else if (results.equalsIgnoreCase("tie")) {
				opponent_gesture = RPC.Gesture.SCISSORS;
			} else {
				opponent_gesture = RPC.getRandomGesture();
			}
		} else {
			opponent_gesture = RPC.getRandomGesture();
		}
		this.updateGame( RPC.Gesture.SCISSORS, opponent_gesture );
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mini_game3);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mini_game3, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		this.set_up_game();
	}
	
	public void set_up_game() {
		if (adapters.PersistentSettings.prefs.offlineMode == false) {
			LinearLayout ll = (LinearLayout)findViewById(R.id.RPC_bot);
			for(int i = 0; i < ll.getChildCount(); i++) {
				ll.getChildAt(i).setVisibility(View.GONE);
			}
			findViewById(R.id.find_opponent_button).setVisibility(View.VISIBLE);
		}
	}

	public void find_opponent(View view) {
		if (adapters.PersistentSettings.prefs.offlineMode == false) {
			this.key = adapters.NetworkAdapter.startRPC();
		}
		LinearLayout ll = (LinearLayout)findViewById(R.id.RPC_bot);
		for(int i = 0; i < ll.getChildCount(); i++) {
			ll.getChildAt(i).setVisibility(View.VISIBLE);
		}
		findViewById(R.id.find_opponent_button).setVisibility(View.GONE);
	}

	@Override
	protected void onPause() {
		super.onPause();
		saveResults(this.winCount * 100 - this.loseCount * 50);
	}

}
