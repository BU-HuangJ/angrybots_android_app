package Messaging;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import base.Member;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
public class Client extends Protocol{
	private Member me;
	private Socket sock;
	
	public Client(String host, Member m) throws UnknownHostException, IOException{
		sock = new Socket(host,9999);
		me = m;
	}
	public Client(String host) throws ClassNotFoundException, SQLException, IOException{
		sock = new Socket(host,9999);
	}
	
	public Member login(String user,String pass) throws IOException{
		LoginMessage msg = new LoginMessage(user,pass);
		write(sock,msg);
		JsonObject obj = read(sock);
		String type = obj.get("id").getAsString();
		if(type.compareTo(Update.TYPE) == 0){
			JsonObject member_obj = obj.get("member").getAsJsonObject();
			Member m = new Member(member_obj);
			return m;
		}
		return null;
	}
	public void start_rpc() throws IOException{
		RPC_Request req = new RPC_Request(me.getId());
		this.write(sock, req);
		JsonObject o = this.read(sock);
		System.out.println(o.toString());
	}
	public ArrayList<Member> getLeaderBoard() throws IOException{
		Request req = new Request("leaderboard");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(output));
		req.encode(writer);
		this.write(sock, output.toString());
		JsonObject obj = this.read(sock);
		LeaderBoardMessage msg = new LeaderBoardMessage(obj);
		return msg.getMembers();
	}
	public ArrayList<Member> getRobotLeaderBoard() throws IOException{
		Request req = new Request("robot_board");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(output));
		req.encode(writer);
		this.write(sock, output.toString());
		JsonObject obj = this.read(sock);
		LeaderBoardMessage msg = new LeaderBoardMessage(obj);
		return msg.getMembers();
	}	
	public ArrayList<Member> getHumanLeaderBoard() throws IOException{
		Request req = new Request("human_board");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(output));
		req.encode(writer);
		this.write(sock, output.toString());
		JsonObject obj = this.read(sock);
		LeaderBoardMessage msg = new LeaderBoardMessage(obj);
		return msg.getMembers();
	}
	public Member getMember() {
		return me;
	}
	public void setMember(Member me) throws IOException {
		this.me = me;
		save();
	}
	public int getHumanTotalPoints() throws IOException{
		Request req = new Request("human_points");
		this.write(sock, req);
		JsonObject o = this.read(sock);
		Response resp = new Response(o);
		return Integer.valueOf(resp.getMessage());
	}
	public int getRobotTotalPoints() throws IOException{
		Request req = new Request("robot_points");
		this.write(sock,req);
		JsonObject o = this.read(sock);
		Response resp = new Response(o);
		return Integer.valueOf(resp.getMessage());
	}
	public void close() throws IOException{
		sock.close();
	}
	
	public boolean save() throws IOException{
		Update msg = new Update(me);
		write(sock,msg);
		JsonObject obj=  read(sock);
		Response rsp = new Response(obj);
		if("success".compareTo(rsp.getMessage()) ==0){
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Client c = new Client("localhost");
			Member m = c.login("test01@test.com", "12345678");
			System.out.println(c.getRobotTotalPoints());
			System.out.println(c.getHumanTotalPoints());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

}
