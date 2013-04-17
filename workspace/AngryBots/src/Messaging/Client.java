package Messaging;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;


import base.Member;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
public class Client extends Protocol{
	private Member me;
	private Socket sock;
	public Client(String host) throws ClassNotFoundException, SQLException, IOException{
		sock = new Socket(host,9999);
	}
	
	public boolean login(String user,String pass) throws IOException{
		LoginMessage msg = new LoginMessage(user,pass);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(output));
		msg.encode(writer);
		write(sock,output.toString());
		JsonObject obj = read(sock);
		System.out.println(obj.toString());
		String type = obj.get("id").getAsString();
		if(type.compareTo("response") == 0){
			String msg2 = obj.get("message").getAsString();
			return msg2.compareTo("success") == 0;
		}
		return false;
		
	}


	
	public void close() throws IOException{
		sock.close();
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Client c = new Client("localhost");
			System.out.println(c.login("testme2@test.com", "12345678"));
			c.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
