package Messaging;

import java.io.IOException;

import com.google.gson.stream.JsonWriter;

import base.Member;

public class Update extends Message{
	private Member member;
	public final static String TYPE = "UPDATE";
	
	public Update(Member m) {
		this.member = m;
	}

	
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("member");
		member.encode(w);
		w.endObject();
		w.close();
	}
}
