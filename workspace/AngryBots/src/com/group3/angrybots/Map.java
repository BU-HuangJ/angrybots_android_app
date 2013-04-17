package com.group3.angrybots;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Map extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
	}

	public void mappoint1(View view) {
		Intent intent = new Intent(this, Mappoint1.class);
		startActivity(intent);
	}

	public void mappoint2(View view) {
		Intent intent = new Intent(this, Mappoint2.class);
		startActivity(intent);
	}

	public void mappoint3(View view) {
		Intent intent = new Intent(this, Mappoint3.class);
		startActivity(intent);
	}

	public void mappoint4(View view) {
		Intent intent = new Intent(this, Mappoint4.class);
		startActivity(intent);
	}

	public void mappoint5(View view) {
		Intent intent = new Intent(this, Mappoint5.class);
		startActivity(intent);

	}

	public void mappoint6(View view) {
		Intent intent = new Intent(this, Mappoint6.class);
		startActivity(intent);
	}
}
