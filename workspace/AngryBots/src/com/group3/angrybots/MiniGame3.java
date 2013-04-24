package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MiniGame3 extends Activity {
	
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
	}
	
	public void chooseRock(View view) {
		this.updateGame( RPC.Gesture.ROCK, RPC.getRandomGesture() );
	}
	
	public void choosePaper(View view) {
		this.updateGame( RPC.Gesture.PAPER, RPC.getRandomGesture() );
	}
	
	public void chooseScissors(View view) {
		this.updateGame( RPC.Gesture.SCISSORS, RPC.getRandomGesture() );
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
	protected void onPause() {
		super.onPause();
		long mPoints = adapters.MemberAdapter.getMember().getPoints();
		mPoints += this.winCount;
		adapters.MemberAdapter.getMember().setPoints(mPoints);
		adapters.NetworkAdapter.setMember( adapters.MemberAdapter.getMember() );
	}

}
