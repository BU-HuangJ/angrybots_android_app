package Messaging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import base.Member;


public class LeaderBoardMessage extends Message {
	public final static String TYPE = "leaderboard";
	private ArrayList<Member> members;
	public LeaderBoardMessage(List<Member> m){
		members = (ArrayList<Member>) m;
	}
	public LeaderBoardMessage(JsonObject obj){
		members = new ArrayList<Member>();
		JsonArray json_arr = obj.get("leaders").getAsJsonArray();
		for(int i = 0 ; i < json_arr.size(); i++){
			members.add(new Member(json_arr.get(i).getAsJsonObject()));
		}
	}
	public void addMember(Member m){
		members.add(m);
	}
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	
	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("leaders");
		w.beginArray();
		for(Member m : members){
			m.encode(w);
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
