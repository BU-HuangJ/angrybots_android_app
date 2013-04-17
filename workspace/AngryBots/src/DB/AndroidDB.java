package DB;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import base.Member;


public class AndroidDB {
	private Connection conn;
	private final String url = "jdbc:mysql://localhost:3306/AndroidSite_development";	
	public static JsonObject getJSON(String s){		
		JsonParser parse = new JsonParser();
		return parse.parse(s).getAsJsonObject();
	}
	
	public AndroidDB(String user, String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/AndroidSite_development";
		login(user,password);
	}
	
	public List<Member> getLeaderBoard(int limit) throws IOException{
		URL memberUrl = new URL("http://127.0.0.1:3000/leaderboard.json");
		URLConnection conn = memberUrl.openConnection();
		String s = Messaging.Message.read(conn.getInputStream());
		return null;
	}
	public Member getMember(int i) throws IOException{
		URL memberUrl = new URL("http://127.0.0.1:3000/members/"+i+".json");
		URLConnection conn = memberUrl.openConnection();
		InputStream in = conn.getInputStream();
		String s = Messaging.Message.read(in);
		Gson g = new Gson();
		return null;
	}
	public Member getMember(String email) throws SQLException, IOException{
		String strSQL = "Select id From members where email='"+email+"' LIMIT 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(strSQL);
		return getMember(rs.getInt(1));
	}
	public void login(String user, String password) throws SQLException{
		conn = DriverManager.getConnection(url, user, password);
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
	public boolean attemptLogin(String email, String password) throws SQLException, IOException{
		String db_password = null;
		int memberId = -1;
		String strSQL = "Select id,encrypted_password From members where email='"+email+"' LIMIT 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(strSQL);
		while (rs.next()) {
			memberId = rs.getInt(1);
			db_password = rs.getString(2);
			System.out.println(db_password);
		}
		stmt.close();
		if(db_password == null || password == null){
			return false;
		}
		if(BCrypt.checkpw(password, db_password)){
			System.out.println("yes?");
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
	/**
	 * @param args
	 */
	public static void main(String arg[]) {
		try {
			
			AndroidDB db = new AndroidDB("AndroidDev","droidme");
			db.givePoints(10, 10);
			db.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
