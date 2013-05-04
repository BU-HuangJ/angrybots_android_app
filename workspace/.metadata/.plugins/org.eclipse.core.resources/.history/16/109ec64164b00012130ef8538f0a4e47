package Messaging;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

public class RPC_Action extends Message {
	public final static String TYPE = "ACTION";
	public final static int ROCK = 1;
	public final static int PAPER = 2;
	public final static int SCISSORS = 3;
	public int action;
	public String key;
	private int mem_id;
	
	public RPC_Action(int action,String key,int mem_id) throws Exception{
		setAction(action);
		setKey(key);
		setMemberId(mem_id);
	}
	
	public RPC_Action(JsonObject o) throws Exception{
		setAction(o.get("action").getAsInt());
		setKey(o.get("key").getAsString());
		setMemberId(o.get("member_id").getAsInt());
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public int getMemberId() {
		return mem_id;
	}

	public void setMemberId(int mem_id) {
		this.mem_id = mem_id;
	}

	public void setAction(int action) throws Exception{
		switch(action){
			case ROCK:break;
			case PAPER: break;
			case SCISSORS: break;
			default: throw new Exception();
		}
		this.action = action;
	}
	
	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("action").value(action);
		w.name("key").value(key);
		w.name("member_id").value(getMemberId());
		w.endObject();
		w.close();
	}
	public int getAction() {
		return action;
	}
	
	@Override
	public String getType() {
		return TYPE;
	}
	
	
	public boolean RPClogic(int a_move,int b_move){
		return true;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @return the member id of the winner , -1 if error
	 */
	public static int getWinner(RPC_Action a, RPC_Action b){
		int a_action = a.getAction();
		int b_action = b.getAction();
		
		switch(a_action){
			case ROCK : 
				switch(b_action){
					case ROCK : return 0;
					case SCISSORS: return -1;
					case PAPER: return 1;
				}
				break;
			case SCISSORS: 
				switch(b_action){
					case ROCK : return -1;
					case SCISSORS: return 0;
					case PAPER: return 1;
				}
				break;
			case PAPER: 
				switch(b_action){
					case ROCK : return -1;
					case SCISSORS: return 1;
					case PAPER: return 0;
				}
			break;
		}
		return 0;
	}
	
}
