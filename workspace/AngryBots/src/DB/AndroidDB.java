package DB;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import base.Faction;
import base.Member;


public class AndroidDB {
	private Connection conn;
	private final String url = "jdbc:mysql://0.0.0.0:3306/AndroidSite_development";	
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public static JsonObject getJSON(String s){		
		JsonParser parse = new JsonParser();
		return parse.parse(s).getAsJsonObject();
	}
	
	public AndroidDB(String user, String password) throws SQLException{
		try {
			System.out.println("initiating db...");
			Class.forName("com.mysql.jdbc.Driver");
			connect(user,password);
		} catch (ClassNotFoundException e) {
			throw new SQLException();
		}
	}
	public List<Member> getLeaderBoard(int limit) throws IOException, SQLException{
		URL memberUrl = new URL("http://127.0.0.1:3000/leaderboard.json");
		URLConnection conn = memberUrl.openConnection();
		String s = Messaging.Message.read(conn.getInputStream());
		JsonParser parse = new JsonParser();
		JsonElement o =  parse.parse(s);
		JsonArray json_arr = o.getAsJsonArray();
		JsonElement json_obj = null;
		List<Member> leaderboard = new ArrayList<Member>();
		for(int i = 0; i < json_arr.size() ; i++){
			json_obj = json_arr.get(i);
			JsonObject mem_obj = (json_obj.getAsJsonObject());
			System.out.println(mem_obj.toString());
			Faction f = getFaction(mem_obj.get("faction_id").getAsInt());
			mem_obj.remove("faction_id");
			Member m = new Member(mem_obj);
			m.setaFaction(f);
			leaderboard.add(m);
		}
		return leaderboard;
	}
	public Member getMember(int i) throws IOException, SQLException{
		URL memberUrl = new URL("http://127.0.0.1:3000/members/"+i+".json");
		URLConnection conn = memberUrl.openConnection();
		InputStream in = conn.getInputStream();
		String s = Messaging.Message.read(in);
		JsonParser parser = new JsonParser();
		JsonElement json_element = parser.parse(s);
		JsonObject mem_obj = json_element.getAsJsonObject();
		Faction f = getFaction(mem_obj.get("faction_id").getAsInt());
		mem_obj.remove("faction_id");
		Member m = new Member(mem_obj);
		m.setaFaction(f);
		return m;
	}
	public Faction getFaction(int i) throws SQLException{
		String strSQL = "Select * from factions where id = " + i;
		System.out.println(strSQL);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(strSQL);
		rs.next();
		try{
			int id = rs.getInt(1);
			String name = rs.getString("name");
			return new Faction(id,name);
		}catch(Exception e){
			
		}
		return null;
	}
	public Member getMember(String email) throws SQLException, IOException{
		String strSQL = "Select id From members where email='"+email+"' LIMIT 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(strSQL);
		rs.next();
		int id = rs.getInt(1);
		return getMember(id);
	}
	public void connect(String user, String password) throws SQLException{
		System.out.println("connecting to " + url);
		conn = DriverManager.getConnection(url, user, password);
	}

	public void updateMember(Member m) throws SQLException{
		String sql = "UPDATE members SET points = " + m.getPoints() + " WHERE email = \"" + m.getEmail()+"\""; 
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
	}
	public void register(String email, String password, String username) throws SQLException{
		Statement stmnt = conn.createStatement();
		java.util.Date d = new java.util.Date();
		Timestamp ts = new Timestamp(d.getTime());
		String created_at = ts.toString();
		String updated_at = created_at;
		String sql = "INSERT INTO members (email,encrypted_password,username,created_at,updated_at) VALUES('"+email+"','"+BCrypt.hashpw(password, BCrypt.gensalt())+"','"+username+"','"+created_at+"','"+updated_at+"')";
		stmnt.execute(sql);
	}
	public boolean login(String email, String password) throws SQLException, IOException{
		String db_password = null;
		String strSQL = "Select id,encrypted_password From members where email='"+email+"' LIMIT 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(strSQL);
		while (rs.next()) {
			db_password = rs.getString(2);
		}
		stmt.close();
		if(db_password == null || password == null){
			return false;
		}
		if(BCrypt.checkpw(password, db_password)){
			return true;
		}
		return false;
	}
	public void givePoints(int memberId, int points) throws SQLException{
		Statement stmt = conn.createStatement();
		String sql = "UPDATE members SET points = points+" + points +" WHERE id="+memberId;
		stmt.execute(sql);
	}
	public void close() throws SQLException{
		conn.close();
	}
	public int getHumanPoints() throws SQLException {
		String sql = "SELECT sum(points) as total_points from members where faction_id = 2";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		return rs.getInt("total_points");	
	}
	public int getRobotPoints() throws SQLException {
		String sql = "SELECT sum(points) as total_points from members where faction_id = 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		return rs.getInt("total_points");
		
	}
	/**
	 * @param args
	 */
	public static void main(String arg[]) {
		try {
			
			AndroidDB db = new AndroidDB("AndroidDev","droidme");
			System.out.println(db.getRobotPoints());
			System.out.println(db.getHumanPoints());
			db.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
