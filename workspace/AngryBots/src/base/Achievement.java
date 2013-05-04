package base;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;



public class Achievement {
	public static Achievement TOP_HAT    = new Achievement(1, "TOP_HAT",     20);
	public static Achievement COWBOY_HAT = new Achievement(2, "COWBOY_HAT",  10);
	public static Achievement MONOCLE    = new Achievement(3, "MONOCLE",    100);
	public static Achievement MUSTACHE   = new Achievement(4, "MUSTACHE",    50);
	
	private String name;
	private int points;
	private int id;
	
	public Achievement(int id, String name, int points) {
		super();
		this.name = name;
		this.points = points;
		this.id = id;
	}
	public Achievement(JsonObject o){
		this.name = o.get("title").getAsString();
		this.points = o.get("value").getAsInt();
		this.id = o.get("id").getAsInt();
	}
	
	public void encode(JsonWriter w) throws IOException{
		w.beginObject();
		w.name("title");
		w.value(name);
		
		w.name("id").value(id);
		
		w.name("value");
		w.value(points);
		w.endObject();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public static List<Achievement> ListFromArray(JsonArray arr){
		System.out.println("*"+arr.toString());
		Iterator<JsonElement> itr = arr.iterator();
		List<Achievement> achievements = new ArrayList<Achievement>();
		while(itr.hasNext()){
			JsonElement ele = (JsonElement)itr.next();
			JsonObject o = ele.getAsJsonObject();
			achievements.add(new Achievement(o));
		}
		return achievements;
		
	}
}
