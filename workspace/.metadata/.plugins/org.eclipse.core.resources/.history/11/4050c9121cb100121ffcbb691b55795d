package Messaging;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DB.AndroidDB;
import base.Entry;
import base.Member;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
public class Client extends Protocol{
	private Member me;
	private Socket sock;
	
	public Client(String host, Member m) throws UnknownHostException, IOException{
		sock = new Socket();
		sock.setSoTimeout(5000);
		sock.connect(new InetSocketAddress(host, 9999));
		me = m;
	}
	public Client(String host) throws ClassNotFoundException, SQLException, IOException{
		sock = new Socket();
		sock.setSoTimeout(5000);
		sock.connect(new InetSocketAddress(host, 9999));
	}
	
	public Member login(String user,String pass) throws IOException{
		LoginMessage msg = new LoginMessage(user,pass);
		write(sock,msg);
		JsonObject obj = read(sock);
		String type = obj.get("id").getAsString();
		if(type.compareTo(Update.TYPE) == 0){
			JsonObject member_obj = obj.get("member").getAsJsonObject();
			me = new Member(member_obj);
			return me;
		}
		return null;
	}
	public String start_rpc() throws IOException{
		RPC_Request req = new RPC_Request(me.getId());
		this.write(sock, req);
		JsonObject o = this.read(sock);
		Response rsp = new Response(o);
		return rsp.getMessage();
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
	
	public void save() throws IOException{
		Update msg = new Update(me);
		write(sock,msg);
		read(sock);
	}
	public String sendRPC_Action(int action, String key) throws Exception{
		RPC_Action rpc_action = new RPC_Action(action,key,me.getId());
		write(sock,rpc_action);
		JsonObject obj = read(sock);
		return obj.get("resource").getAsString();
	}
	
	public String grantAchievement(int i ) throws IOException{
		AchievementMessage msg = new AchievementMessage(me.getId(),i);
		write(sock,msg);
		JsonObject obj = read(sock);
		return obj.get("resource").getAsString();
	}
	public List<Entry> getCodex() throws IOException{
		Request req = new Request("codex");
		write(sock,req);
		JsonObject o = read(sock);
		CodexMessage msg = new CodexMessage(o);
		return msg.getCodex();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			String server = "";
			boolean local = false;
			if(AndroidDB.production){
				server = "65.111.126.38";
			}else{
				if(local){
					server = "192.168.0.10";
				}else{
					server = "localhost";
				}
			}
			
			
			Client robot_client = new Client(server);
			Member m = robot_client.login("bob@bob.com", "12345678");
			robot_client.setMember(m);
			System.out.println(m.toString());
			System.out.println(robot_client.grantAchievement(0));
			
			
			/*
			final Client human_client= new Client(server);
			final Client robot_client = new Client(server);
			//init members
			Member robot_member = null;
			Member human_member = null;
			
			//login 
			robot_member = robot_client.login("test01@test.com", "12345678");
			human_member = human_client.login("bob@bob.com", "12345678");
			
			//set client members
			robot_client.setMember(robot_member);
			human_client.setMember(human_member);
			int x = 1;
			if(x == 1){
				while(true){
					Random gen = new Random();
					int choice = gen.nextInt(2);
					int[] choices = new int[]{RPC_Action.SCISSORS,RPC_Action.PAPER,RPC_Action.ROCK};
					String human_key = human_client.start_rpc();
					System.out.println(human_client.sendRPC_Action(
							choices[choice], human_key));
				}
			}else{
				String robot_key = robot_client.start_rpc();
				System.out.println(robot_client.sendRPC_Action(RPC_Action.PAPER,robot_key));	
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
