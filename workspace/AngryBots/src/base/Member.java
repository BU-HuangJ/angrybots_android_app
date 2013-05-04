package base;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonArray;
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
	private int rank;
	private int deaths;
	private int time_played;
	private List<Achievement> achievements;
	private HashMap<Integer,Achievement> achievement_map;
	
	public Member(String username, String email, int points, Faction aFaction,
			List<Achievement> achievements,int fired, int shot,int id) {
		super();
		achievement_map = new HashMap<Integer,Achievement>();
		this.username = username;
		this.email = email;
		this.points = points;
		this.aFaction = aFaction;
		this.fired = fired;
		this.hit = shot;
		this.id = id;
		setAchievements(achievements);
	}

	public Member(JsonObject obj){
		System.out.println(obj.toString());
		achievement_map = new HashMap<Integer,Achievement>();
		setUsername(obj.get("username").getAsString());
		setEmail(obj.get("email").getAsString());
		setPoints(obj.get("points").getAsLong());
		setFired(obj.get("fired").getAsInt());
		setHit(obj.get("hit").getAsInt());
		setId(obj.get("id").getAsInt());
		setRank(obj.get("rank").getAsInt());
		setDeaths(obj.get("deaths").getAsInt());
		setTime_played(obj.get("time").getAsInt());
		JsonArray arr = obj.get("achievements").getAsJsonArray();
		System.out.println(arr.toString());
		setAchievements(Achievement.ListFromArray(arr));
		try{
			setaFaction(new Faction(obj.get("faction").getAsJsonObject()));
		}catch(Exception e){
			
		}
	}

	public void encode(JsonWriter w) throws  IOException{
		w.beginObject();
		w.name("username");
		w.value(getUsername());
		
		w.name("id").value(getId());
		w.name("email");
		w.value(getEmail());

		w.name("points");
		w.value(getPoints());
		
		w.name("hit").value(getHit());
		w.name("fired").value(getFired());
		
		w.name("time").value(getTime_played());
		w.name("deaths").value(getDeaths());
		w.name("rank").value(getRank());
		
		w.name("hit").value(getHit());
		w.name("faction");
		aFaction.encode(w);
		w.name("achievements");
		w.beginArray();
		if(achievements != null){
			for(Achievement a : achievements){
				a.encode(w);
			}
		}
		w.endArray();
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
		if(achievements != null){
			this.achievements = achievements;
		}else{
			this.achievements = new ArrayList<Achievement>();
		}
		
		this.achievement_map.clear();
		for(Achievement a : this.achievements){
			System.out.println(a.toString());
			achievement_map.put(a.getId(), a);
		}
	}

	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getTime_played() {
		return time_played;
	}

	public void setTime_played(int time_played) {
		this.time_played = time_played;
	}
	
	public HashMap<Integer,Achievement> getAchievementMap() {
		return this.achievement_map;
	}

	@Override
	public String toString() {
		return "Member [username=" + username + ", email=" + email
				+ ", points=" + points + ", aFaction=" + aFaction + ", fired="
				+ fired + ", hit=" + hit + ", id=" + id + ", rank=" + rank
				+ ", deaths=" + deaths + ", time_played=" + time_played
				+ ", achievements=" + achievements + "]";
	}
}
