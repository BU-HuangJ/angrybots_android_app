package adapters;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class NetworkAdapter {
	protected static Messaging.Client client = null;
	private NetworkAdapter() {}
	
	public static void connect(String host) throws IOException {
		NetworkAdapter.close();
		try {
			NetworkAdapter.client = new Messaging.Client(host);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close() {
		Messaging.Client client = NetworkAdapter.client;
		if (client != null) {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			client = null;
		}
	}
	
	public static base.Member login(String email, String password) {
		if (NetworkAdapter.client == null) { return null; }
		
		try {
			return client.login(email, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static base.Member getMember() {
		if (NetworkAdapter.client == null) { return null; }
		
		try {
			return ( new AsyncTaskThread<Void, base.Member>(new AsyncTaskThread.Runner<Void, base.Member>() {
				@Override
				public base.Member run(Void... params) {
					return NetworkAdapter.client.getMember();
				}
			}) ).run((Void) null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void save() {
		if (NetworkAdapter.client == null) { return; }
		
		try {
			( new AsyncTaskThread<Void, Void>(new AsyncTaskThread.Runner<Void, Void>() {
				@Override
				public Void run(Void... params) {
					try {
						NetworkAdapter.client.save();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}) ).run((Void) null);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static ArrayList<base.Member> getLeaderBoard() {
		if (NetworkAdapter.client == null) { return null; }
		
		try {
			return ( new AsyncTaskThread<Void, ArrayList<base.Member>>(new AsyncTaskThread.Runner<Void, ArrayList<base.Member>>() {
				@Override
				public ArrayList<base.Member> run(Void... params) {
					try {
						return adapters.NetworkAdapter.client.getLeaderBoard();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}) ).run((Void) null);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<base.Member> getRobotLeaderBoard() {
		if (NetworkAdapter.client == null) { return null; }
		
		try {
			return ( new AsyncTaskThread<Void, ArrayList<base.Member>>(new AsyncTaskThread.Runner<Void, ArrayList<base.Member>>() {
				@Override
				public ArrayList<base.Member> run(Void... params) {
					try {
						return adapters.NetworkAdapter.client.getRobotLeaderBoard();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}) ).run((Void) null);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	public static int getHumanTotalPoints() {
		if (NetworkAdapter.client == null) { return 0; }
		
		try {
			return ( new AsyncTaskThread<Void, Integer>(new AsyncTaskThread.Runner<Void, Integer>() {
				@Override
				public Integer run(Void... params) {
					try {
						return adapters.NetworkAdapter.client.getHumanTotalPoints();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}) ).run((Void) null);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}
	
	public static int getRobotTotalPoints() {
		if (NetworkAdapter.client == null) { return 0; }
		
		try {
			return ( new AsyncTaskThread<Void, Integer>(new AsyncTaskThread.Runner<Void, Integer>() {
				@Override
				public Integer run(Void... params) {
					try {
						return adapters.NetworkAdapter.client.getRobotTotalPoints();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}) ).run((Void) null);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}
	
	public static String startRPC() {
		if (NetworkAdapter.client == null) { return null; }
		
		try {
			return ( new AsyncTaskThread<Void, String>(new AsyncTaskThread.Runner<Void, String>() {
				@Override
				public String run(Void... params) {
					try {
						return adapters.NetworkAdapter.client.start_rpc();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "";
				}
			}) ).run((Void) null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String sendRPC_Action(final int action, final String key) {
		if (NetworkAdapter.client == null) { return null; }
		
		try {
			return ( new AsyncTaskThread<Void, String>(new AsyncTaskThread.Runner<Void, String>() {
				@Override
				public String run(Void... params) {
					try {
						return adapters.NetworkAdapter.client.sendRPC_Action(action, key);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "";
				}
			}) ).run((Void) null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String grantAchievement(int i) {
		if (NetworkAdapter.client == null) { return null; }
		
		return ( new AsyncTaskThread<Integer, String>(new AsyncTaskThread.Runner<Integer, String>() {
			@Override
			public String run(Integer... params) {
				try {
					return adapters.NetworkAdapter.client.grantAchievement(params[0]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "";
			}
		}) ).runUnsafe(i);
	}
}
