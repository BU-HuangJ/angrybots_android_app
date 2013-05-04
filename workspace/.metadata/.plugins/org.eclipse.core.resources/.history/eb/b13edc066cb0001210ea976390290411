package Messaging;

import java.io.IOException;
import java.io.InputStream;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;


public abstract class Message {
	public abstract String getType();
	
	public Message decode(JsonObject o){
		return null;
	}
	public static String read(InputStream in) throws IOException{
		int read;
		String s = "";
		while((read = in.read()) != -1){
			s += (char)read;
		}
		return s;
	}
	
	public static void Write(Message msg){
		
	}
	public void encode(JsonWriter w) throws IOException{
		w.beginObject();
		w.name("id").value(getType());
	}
}
