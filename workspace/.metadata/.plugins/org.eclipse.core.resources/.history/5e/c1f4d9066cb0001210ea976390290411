package Messaging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import base.Entry;
import base.Member;

public class CodexMessage extends Message{
	public final static String TYPE = "CODEX";
	private List<Entry> codex;
	
	public CodexMessage(JsonObject obj){
		codex = new ArrayList<Entry>();
		JsonArray json_arr = obj.get("entries").getAsJsonArray();
		for(int i = 0 ; i < json_arr.size(); i++){
			codex.add(new Entry(json_arr.get(i).getAsJsonObject()));
		}
	}
	public CodexMessage(List<Entry> codex) {
		super();
		this.codex = codex;
	}


	public List<Entry> getCodex() {
		return codex;
	}


	public void setCodex(List<Entry> codex) {
		this.codex = codex;
	}

	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("entries");
		w.beginArray();
		for(Entry e: codex){
			e.encode(w);
		}
		w.endArray();
		
		w.endObject();
		w.close();
	}
	@Override
	public String getType() {
		return TYPE;
	}
}
