package Messaging;

import java.io.IOException;

import com.google.gson.stream.JsonWriter;

public class AchievementMessage extends Message{
	public final static String TYPE = "achievement";
	private int member_id;
	private int achievement_id;
	
	
	public AchievementMessage(int member_id, int achievement_id) {
		super();
		this.member_id = member_id;
		this.achievement_id = achievement_id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("member_id").value(member_id);
		w.name("achievement_id").value(achievement_id);
		w.endObject();
		w.close();
		
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}


	public int getAchievement_id() {
		return achievement_id;
	}


	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}


	@Override
	public String getType() {
		return TYPE;
	}

}
