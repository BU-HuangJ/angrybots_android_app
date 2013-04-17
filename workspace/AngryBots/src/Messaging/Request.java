package Messaging;

import java.io.IOException;
import com.google.gson.stream.JsonWriter;

public class Request extends Message {
	public final static String TYPE= "request";
	private String resource;
	
	public Request(String resource) {
		super();
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public void encode(JsonWriter writer) throws IOException{
		writer.name("resource");
		writer.value(resource);
	}
	@Override
	public String getType() {
		return TYPE;
	}
}
