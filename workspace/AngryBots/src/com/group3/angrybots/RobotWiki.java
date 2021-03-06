package com.group3.angrybots;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class RobotWiki extends RobotActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_robot_wiki);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_robot_wiki, menu);
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
	public void onResume() {
		super.onResume();
		this.set_wiki_buttons(null);
	}
	
	protected void setEntries(ArrayList<adapters.CodexReader.Pair> entries) {
		LinearLayout ll = (LinearLayout)findViewById(R.id.robot_wiki_buttons_bar);
		ll.setVisibility(View.INVISIBLE);
		for (int i = 0; i < ll.getChildCount(); i++) {
			LinearLayout child = (LinearLayout)ll.getChildAt(i);
			for (int j = 0; j < child.getChildCount(); j++) {
				child.getChildAt(j).setClickable(false);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		if (entries != null) {
			for(adapters.CodexReader.Pair pair : entries) {
				list.add(pair.title + "\n\n" + pair.description);
			}
		} else {
			list.add("No Entries");
		}
		ListView lv = (ListView)findViewById(R.id.robot_codex_text_bar);
		lv.bringToFront();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener () {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				set_wiki_buttons(null);
			}
		});
	}
	
	public void set_wiki_buttons(View view) {
		ListView lv = (ListView)findViewById(R.id.robot_codex_text_bar);
		ArrayList<String> list = new ArrayList<String>();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		lv.setAdapter(adapter);
		
		LinearLayout ll = (LinearLayout)findViewById(R.id.robot_wiki_buttons_bar);
		ll.setVisibility(View.VISIBLE);
		ll.bringToFront();
		for (int i = 0; i < ll.getChildCount(); i++) {
			LinearLayout child = (LinearLayout)ll.getChildAt(i);
			for (int j = 0; j < child.getChildCount(); j++) {
				child.getChildAt(j).setClickable(true);
			}
		}
	}
	
	public void a_button(View view) { this.setEntries( adapters.CodexReader.getEntries('a', getApplicationContext()) );	}
	public void b_button(View view) { this.setEntries( adapters.CodexReader.getEntries('b', getApplicationContext()) );	}
	public void c_button(View view) { this.setEntries( adapters.CodexReader.getEntries('c', getApplicationContext()) );	}
	public void d_button(View view) { this.setEntries( adapters.CodexReader.getEntries('d', getApplicationContext()) );	}
	public void e_button(View view) { this.setEntries( adapters.CodexReader.getEntries('e', getApplicationContext()) );	}
	public void f_button(View view) { this.setEntries( adapters.CodexReader.getEntries('f', getApplicationContext()) );	}
	public void g_button(View view) { this.setEntries( adapters.CodexReader.getEntries('g', getApplicationContext()) );	}
	public void h_button(View view) { this.setEntries( adapters.CodexReader.getEntries('h', getApplicationContext()) );	}
	public void i_button(View view) { this.setEntries( adapters.CodexReader.getEntries('i', getApplicationContext()) );	}
	public void j_button(View view) { this.setEntries( adapters.CodexReader.getEntries('j', getApplicationContext()) );	}
	public void k_button(View view) { this.setEntries( adapters.CodexReader.getEntries('k', getApplicationContext()) );	}
	public void l_button(View view) { this.setEntries( adapters.CodexReader.getEntries('l', getApplicationContext()) );	}
	public void m_button(View view) { this.setEntries( adapters.CodexReader.getEntries('m', getApplicationContext()) );	}
	public void n_button(View view) { this.setEntries( adapters.CodexReader.getEntries('n', getApplicationContext()) );	}
	public void o_button(View view) { this.setEntries( adapters.CodexReader.getEntries('o', getApplicationContext()) );	}
	public void p_button(View view) { this.setEntries( adapters.CodexReader.getEntries('p', getApplicationContext()) );	}
	public void q_button(View view) { this.setEntries( adapters.CodexReader.getEntries('q', getApplicationContext()) );	}
	public void r_button(View view) { this.setEntries( adapters.CodexReader.getEntries('r', getApplicationContext()) );	}
	public void s_button(View view) { this.setEntries( adapters.CodexReader.getEntries('s', getApplicationContext()) );	}
	public void t_button(View view) { this.setEntries( adapters.CodexReader.getEntries('t', getApplicationContext()) );	}
	public void u_button(View view) { this.setEntries( adapters.CodexReader.getEntries('u', getApplicationContext()) );	}
	public void v_button(View view) { this.setEntries( adapters.CodexReader.getEntries('v', getApplicationContext()) );	}
	public void w_button(View view) { this.setEntries( adapters.CodexReader.getEntries('w', getApplicationContext()) );	}
	public void x_button(View view) { this.setEntries( adapters.CodexReader.getEntries('x', getApplicationContext()) );	}
	public void y_button(View view) { this.setEntries( adapters.CodexReader.getEntries('y', getApplicationContext()) );	}
	public void z_button(View view) { this.setEntries( adapters.CodexReader.getEntries('z', getApplicationContext()) );	}

}
