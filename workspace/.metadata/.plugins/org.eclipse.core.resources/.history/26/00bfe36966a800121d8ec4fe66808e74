package Messaging;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
public class Response extends Message {
	public static final String type = "response";
	private String message;
	public Response(String msg){
		setMessage(msg);
	}
	
	public Response(JsonObject o) {
		message = o.get("resource").getAsString();
	}

	public String getMessage() {
		return message;
	}

	public void encode(JsonWriter w) throws IOException{
		super.encode(w);
		w.name("resource").value(message);
		w.endObject();
		w.close();
		
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getType() {
		return type;
	}

}
