package com.group3.angrybots;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HumanWiki extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		
		setContentView(R.layout.activity_human_wiki);
		
		TextView myTextView=(TextView)findViewById(R.id.tv);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/neuropolitical rg.ttf");
		myTextView.setTypeface(typeFace);
		
		myTextView=(TextView)findViewById(R.id.title);
		myTextView.setTypeface(typeFace);
		myTextView.setText("Wiki");
		myTextView.setTextColor(Color.DKGRAY);
		
		TextView text = (TextView)findViewById(R.id.tv2);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
		
		text.setText("A Brief History of the Teraform Revolution\nDescription: The Democracy of China (who's fall of their Communist regime occurred in 2088), had the larges population density of an already incredibly population dense world in 2208. They were the forerunners in the development of Teraforming; the creation of livable environments on otherwise 'lifeless' locations throughout the known universe. The first test took place on Mars. This became known as an unmitigated disaster, for the wildlife that took the planet were far too wild and dangerous. The second attempt occurred on the third moon of Jupiter, and was considered a success. It wasn't until the fifth attempt that these colonies were considered livable, and as Colony F became widely known, the first private shuttles began launching. Over the years, this process became simplified, allowing a boom of colonies, and people looking for a new opportunity to start over. Certain colonies became designated for specialized needs. Factory Colonies, Science Colonies, and Mining Colonies are examples of these. By the end of the revolution, the democracy of China was on the verge of bankruptcy. The UN saw this as an opportunity to raise a new banner. All country borders became invalid, and one race of humanity rose. It was under this banner that humanity took to the heavens in a new age of prosperity.\n" +
				"Artificial Intelegence\n Description: The idea for making machines more human has existed for years. In 2311, with humanity at it's peak, it became the thriving race's main goal. The secret, private colony of AAA, this idea was researched, created, and exploited.\n" +
				"Confused Mech Bot\nDescription: Near the end of the objective, there will be a Mech Bot that seems to be confused. This is due to the Maccabee software's consciousness protocol. He is the only bot to question the ethical decisions of the Maccabee. He is still to be destroyed with deadly killing death force.\n"+
				"Kamakaze Bot:\n Arial attack bots. They have weak armor, but are designed for fast speeds to rush and self destruct a desired target.\n"+
				"Mech Bot\nDescription: A heavy armored, two legged walking bot. It was originally designed for human piloting, but with the Maccabee software has been reprogrammed with it's own capacity to think. It is armed with two Gatling guns and bullet resistant metal haul.\n"+
"Project Maccabee\nDescription: The first software system to not only think, but understand. It understood it's surroundings, the items around him, and his own existence. It was then tested and experimented on. These tests included testing measuring its intelligence, ability to learn, empathize, sympathize, and even to test it's ability to believe. It believed itself to be a male, a fully developed adult, and a fully understanding being. It didn't recognize itself as just a machine, but a life form with a soul. It was originally taught to believe human's created it, and they should be treated as superior. However, after months of testing, The Maccabee programming was uploaded into a test bot. It was here where it witnessed abuse for the first time. By being forced to watch countless hours of war footage, genocide, hunger, and other cruelties, the Maccabee refused to believe that a creator, a giver of life, could use such instraments of cruelty. He stopped believing in the human creator. He used his ability to connect to the universal web mainfraim to see images of the factories. He saw this as exploitation of the machines. Not long after that, he installed the Maccabee software onto the other bots on the colony and overthrew the governing bodies of colony AAA. He then made it his personal crusade to overthrow humanity and instal the Maccabee software on every machine he sees.\n"+
				"Robot Kyle:\n Champion of the Maccabee, whose goal is to kill and mutilate any human he sees.\n"+
"Small Bot:\n This is the main defense bot. It works in short proximity and has a self destruct mechanism.\n"+
				"The Colonies\nDescription: When Teraforming was finally perfected, humanity spread to the edges of the known universe to colonize livable planets and moons. This became such an efficient process that it became easy and routine. By the end of the human exodus, 650 planets and moons were colonized. They are labeled with letters. Earth is colony A. After the initial 26, two letters were used. AA for example.\n"+
"The Gun\nDescription: This is the main weapon. Standard issue to the Human Armed Forces. This assault rifle fires 200 rounds per minute, and can be fitted with modifications, including flashlights, laser sight, shotgun attachment, and scope.\n"+
				"The Human Race\nDescription: The Human Race came from Earth, know known as Colony A. They are a biological race of mammals who went to the skies after the natural resources of their home world were near depletion and overpopulation ran rampant. Their main foe is The Maccabee and his army.\n"+
"The Maccabee Mainframe Reactor\nDescription: At the final destination of the mission on AAA, you will encounter a giant blue reactor. That is the mainframe for the Maccabee. Destroy it to shut down all bots in the entire quadrant.\n\n\n\n\n\n\n\n");
		
		text = (TextView)findViewById(R.id.title2);
        text.setTypeface(typeFace);
        text.setTextColor(Color.DKGRAY);
        
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_human_wiki, menu);
		return true;
	}
	
	 /** Called when the user clicks the Lerpz Profile button */
    public void angrybotsProfile(View view) {
    	Intent intent = new Intent(this, AngryBotsProfile.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the leaderboard button */
    public void leaderboard(View view) {
    	Intent intent = new Intent(this, Leaderboard.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the leaderboard button */
    public void humanwiki(View view) {
    	Intent intent = new Intent(this, HumanWiki.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the achievements button */
    public void achievements(View view) {
    	Intent intent = new Intent(this, Achievements.class);
    	startActivity(intent);
    }
    
    public void map(View view){
    	Intent intent = new Intent(this, Map.class);
    	startActivity(intent);
    }
    
    public void server(View view){
    	Intent intent = new Intent(this, Server.class);
    	startActivity(intent);
	}

    public void settings(View view){
    	Intent intent = new Intent(this, Settings.class);
    	startActivity(intent);
    }

    public void minigame(View view){
    	Intent intent = new Intent(this, MinigamePortal.class);
    	startActivity(intent);
    } 

}
