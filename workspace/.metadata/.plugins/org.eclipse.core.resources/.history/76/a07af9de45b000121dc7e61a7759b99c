package base;
import java.io.IOException;

import com.google.gson.stream.JsonWriter;



public class Achievement {
	private String name;
	private int points;
	public Achievement(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}
	
	public void encode(JsonWriter w) throws IOException{
		w.beginObject();
		w.name("name");
		w.value(name);
		
		w.name("points");
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
	
	
	
	
}
