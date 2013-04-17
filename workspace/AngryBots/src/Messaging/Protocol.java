package Messaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public abstract class Protocol {

	public JsonObject read(Socket s) throws IOException{
		InputStream in = s.getInputStream();
		BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
		String str;
		do{
			str = rdr.readLine();
		}while(str == null);
		JsonParser parse = new JsonParser();
		JsonElement e = parse.parse(str);
		while(e.getAsJsonObject() == null){}
		return e.getAsJsonObject();
	}
	
	public void write(Socket sock,String s) throws IOException{
		OutputStream out = sock.getOutputStream();
		out.write((s+'\n').getBytes());
	}

}
