package Messaging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import base.Member;


public class LeaderBoardMessage extends Message {
	public final static String TYPE = "leaderboard";
	private ArrayList<Member> members;
	public LeaderBoardMessage(ArrayList<Member> m){
		members = m;
	}
	public LeaderBoardMessage(JsonObject obj){
		members = new ArrayList<Member>();
		JsonArray arr = (JsonArray)obj.get("leaders");
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
		w.beginArray();
		for(Member m : members){
			m.encode(w);
		}
		w.endArray();
	}
	@Override
	public String getType() {
		return TYPE;
	}

}
