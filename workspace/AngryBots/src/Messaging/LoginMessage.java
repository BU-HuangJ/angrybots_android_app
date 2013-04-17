package Messaging;
import java.io.IOException;

import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonWriter;

public class LoginMessage extends Message {
	public final static String TYPE = "login";
	@SerializedName("type")
	private final String id = TYPE;
	private String member;
	private String password;
	
	public LoginMessage(String m, String password){
		this.member = m;
		this.password = password;
	}
	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("member").value(member);
		w.name("password").value(password);
		w.endObject();
		w.close();
	}
	public String getTheMember() {
		return member;
	}


	public void setTheMember(String theMember) {
		this.member = theMember;
	}
	public String getThePassword() {
		return password;
	}
	public void setThePassword(String thePassword) {
		this.password = thePassword;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
