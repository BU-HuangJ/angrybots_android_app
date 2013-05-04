package base;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;




public class Entry {
	private String title;
	private String description;
	public Entry(JsonObject o){
		setTitle(o.get("title").getAsString());
		setDescription(o.get("description").getAsString());
	}
	public Entry(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void encode(JsonWriter w) throws IOException{
		w.beginObject();
		w.name("title").value(title);
		w.name("description").value(description);
		w.endObject();
	}
	@Override
	public String toString() {
		return "Entry [title=" + title + ", description=" + description + "]";
	}
}
