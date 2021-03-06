package adapters;

import java.util.concurrent.ExecutionException;

import android.os.AsyncTask;

/* Usage:
		return ( new AsyncTaskThread<P, R>(new AsyncTaskThread.Runner<P, R>() {
			@Override
			public R run(P... params) {
				return foo(params);
			}
		}) ).run(member);
 */

public class AsyncTaskThread<P, R> {
	
	private class Thread extends AsyncTask<P, Void, R> {
		
		@Override
		protected R doInBackground(P... params) {
			return r.run(params);
		}
	
		private Runner<P, R> r;
		
		public Thread(Runner<P, R> r) {
			this.r = r;
		}
		
	}
	
	public interface Runner<P, R> {
		public abstract R run(P... params);
	}
	
	private Thread t;
	
	public AsyncTaskThread(Runner<P, R> r) {
		this.t = new Thread(r);
	}
	
	public R run(P... params) throws InterruptedException, ExecutionException {
		return t.execute(params).get();
	}
	
	public R runUnsafe(P... params) {
		try {
			return t.execute(params).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
