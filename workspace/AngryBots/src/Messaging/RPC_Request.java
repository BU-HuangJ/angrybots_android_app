package Messaging;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

public class RPC_Request extends Message{
	private int member_id;
	public static final String TYPE = "RPC_Request";
	
	
	public RPC_Request(JsonObject o){
		member_id = o.get("member_id").getAsInt();
	}
	public RPC_Request(int member_id) {
		super();
		this.member_id = member_id;
	}

	
	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("member_id").value(member_id);
		w.endObject();
		w.close();
	}
	
	@Override
	public String getType() {
		return TYPE;
	}



}
