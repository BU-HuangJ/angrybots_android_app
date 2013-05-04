package Messaging;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;


public abstract class Protocol {
	public final static boolean DEBUG = true;
	public void DEBUG(String str){
		if(DEBUG)
			System.out.println(str);
	}
	public JsonObject getFrom(String str){
		JsonParser parse = new JsonParser();
		JsonElement e = parse.parse(str);
		return e.getAsJsonObject();
	}
	public JsonObject read(Socket s) throws IOException, SocketException{
		InputStream in = s.getInputStream();
		BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
		String str;
		do{
			str = rdr.readLine();
		}while(str == null);
		
		return getFrom(str);
	}
	
	public void write(Socket sock,String s) throws IOException{
		OutputStream out = sock.getOutputStream();
		out.write((s+"\n").getBytes());
	}
	public void write(Socket sock,Message msg) throws IOException{
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(output));
		msg.encode(writer);
		write(sock,output.toString());
	}

}
