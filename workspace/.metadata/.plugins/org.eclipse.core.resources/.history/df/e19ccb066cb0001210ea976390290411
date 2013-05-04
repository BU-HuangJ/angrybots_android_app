package base;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

public class Faction {
	private String name;
	private int id;
	
	public Faction(JsonObject o){
		name = o.get("name").getAsString();
		id = o.get("id").getAsInt();
	}
	public Faction(int id,String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void encode(JsonWriter w) throws  IOException{
		w.beginObject();
		w.name("name").value(name);
		w.name("id").value(id);
		w.endObject();
	}
	
	@Override
	public String toString() {
		return "Faction [name=" + name + ", id=" + id + "]";
	}
}
