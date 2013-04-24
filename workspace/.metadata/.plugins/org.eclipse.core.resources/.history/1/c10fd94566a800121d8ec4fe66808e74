package Messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import DB.AndroidDB;


public class Server extends Protocol{
	private ServerSocket sock;
	private AndroidDB db;
	public Server() throws IOException, ClassNotFoundException, SQLException{
		sock = new ServerSocket(9999);
		db = new AndroidDB("AndroidDev","droidme");
	}
	
	public void run() throws IOException, SQLException{
		while(true){
			Socket s = sock.accept();
			System.out.println("got connection");
			JsonObject obj = read(s);
			handle(s,obj);
			s.close();
		}
	}
	
	public void handle(Socket s,JsonObject o) throws IOException{
		String type = o.get("id").getAsString();
		if(type.compareTo(LoginMessage.TYPE) == 0){
			System.out.println("YES!");
			Response rsp = new Response("success");
			Gson g = new Gson();
			String str = g.toJson(rsp,Response.class);
			this.write(s,str);
		}
	}
	
	public static void main(String[] args){
		Server serv;
		try {
			serv = new Server();
			serv.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
