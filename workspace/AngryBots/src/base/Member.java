package base;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;



public class Member {
	private String username;
	private String email;
	private long points;
	private Faction aFaction;
	private int fired;
	private int hit;
	private int id;
	private List<Achievement> achievements;
	
	
	public Member(String username, String email, int points, Faction aFaction,
			List<Achievement> achievements,int fired, int shot,int id) {
		super();
		this.username = username;
		this.email = email;
		this.points = points;
		this.aFaction = aFaction;
		this.fired = fired;
		this.hit = shot;
		this.id = id;
		if(achievements != null){
			this.achievements = achievements;
		}else{
			this.achievements = new ArrayList<Achievement>();
		}
	}

	public Member(JsonObject obj){
		setUsername(obj.get("username").getAsString());
		setEmail(obj.get("email").getAsString());
		setPoints(obj.get("points").getAsLong());
		setFired(obj.get("fired").getAsInt());
		setHit(obj.get("hit").getAsInt());
		setId(obj.get("id").getAsInt());
		try{
			setaFaction(new Faction(obj.get("faction").getAsJsonObject()));
		}catch(Exception e){
			
		}
	}

	public void encode(JsonWriter w) throws  IOException{
		w.beginObject();
		w.name("username");
		w.value(getUsername());
		
		w.name("email");
		w.value(getEmail());

		w.name("points");
		w.value(getPoints());
		
		w.name("hit").value(getHit());
		w.name("fired").value(getFired());
		w.name("id").value(getId());
		w.name("faction");
		aFaction.encode(w);
		w.name("achievments");
		if(achievements == null){
			w.nullValue();
		}else{
			w.beginArray();
			for(Achievement a : achievements){
				a.encode(w);
			}
			w.endArray();
		}
		w.endObject();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFired() {
		return fired;
	}

	public void setFired(int fired) {
		this.fired = fired;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public long getPoints() {
		return points;
	}


	public void setPoints(long points) {
		this.points = points;
	}


	public Faction getaFaction() {
		return aFaction;
	}


	public void setaFaction(Faction aFaction) {
		this.aFaction = aFaction;
	}


	public List<Achievement> getAchievements() {
		return achievements;
	}


	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}

	@Override
	public String toString() {
		return "Member [username=" + username + ", email=" + email
				+ ", points=" + points + ", aFaction=" + aFaction
				+ ", achievements=" + achievements + "]";
	}
	
}
